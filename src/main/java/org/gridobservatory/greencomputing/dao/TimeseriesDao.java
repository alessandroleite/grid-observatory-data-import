/**
 * Copyright (C) 2013 Alessandro <alessandro dot leite at alessandro dot cc>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.gridobservatory.greencomputing.dao;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.gridobservatory.greencomputing.xml.types.TimeseriesAcquisitionType;
import org.gridobservatory.greencomputing.xml.types.TimeseriesType;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementCreatorFactory;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

public abstract class TimeseriesDao<T extends TimeseriesType> extends DaoSupport {
	
	private ExecutorService executor = Executors.newCachedThreadPool();

	public BigInteger insert(T timeseriesType) {
		KeyHolder keyHolder = new GeneratedKeyHolder();

		PreparedStatementCreatorFactory preparedStatementCreatorFactory = new PreparedStatementCreatorFactory(
				"insert into time_series (constant_value,start_date,end_date,acquisition_count ) "
						+ "values (?, ?, ?, ?)", new int[] { Types.VARCHAR,
						Types.TIMESTAMP, Types.TIMESTAMP, Types.BIGINT });

		PreparedStatementCreator newPreparedStatementCreator = preparedStatementCreatorFactory
				.newPreparedStatementCreator(
				new Object[] 
				{
						timeseriesType.getConstantValue() != null ? timeseriesType.getConstantValue().getValue() : "",
						new Date(timeseriesType.getStartDate().longValue() * 1000),
						new Date(timeseriesType.getEndDate().longValue() * 1000),
						timeseriesType.getAcquisitionCount() 
				});

		preparedStatementCreatorFactory.setReturnGeneratedKeys(true);
		this.getJdbcTemplate().update(newPreparedStatementCreator, keyHolder);
		BigInteger timeSeriesId = BigInteger.valueOf(keyHolder.getKey().longValue());
		
		insertTimeSeriesAcquisitions(timeSeriesId, timeseriesType.getA());
		
		return timeSeriesId;
	}
	
	public List<BigInteger> insert(Iterable<T> timeseries) {
		List<BigInteger> ids = new ArrayList<>();
		for (T timeseriesType : timeseries) {
			ids.add(this.insert(timeseriesType));
		}
		return ids;
	}
	
	protected void insertTimeSeriesAcquisitions(final BigInteger timeSeriesId, final List<TimeseriesAcquisitionType> acquisitions) {
		executor.submit(new Runnable() {
			@Override
			public void run() {
				if (acquisitions != null) {
					getJdbcTemplate().batchUpdate("insert into time_series_acquisition (time_series_id, ts, value) values (?,?,?)",
									new BatchPreparedStatementSetter() {
						
										@Override
										public void setValues(PreparedStatement ps, int i)throws SQLException {
											ps.setLong(1, timeSeriesId.longValue());
											ps.setBigDecimal(2, new BigDecimal(acquisitions.get(i).getTs()));
											ps.setString(3, acquisitions.get(i).getV());
										}

										@Override
										public int getBatchSize() {
											return acquisitions.size();
										}
									});
				}
			}
		});
	}
}