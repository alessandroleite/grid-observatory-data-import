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

import java.math.BigInteger;
import java.util.Date;

import org.gridobservatory.greencomputing.xml.types.TimeseriesType;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

public abstract class TimeseriesDao<T extends TimeseriesType> extends DaoSupport {

	public BigInteger insert(T timeseriesType) {
		KeyHolder keyHolder = new GeneratedKeyHolder();
		this.getJdbcTemplate()
				.update("insert into time_series (constant_value,start_date,end_date,acquisition_count ) values (?,?,?,?,?)",
						timeseriesType.getConstantValue().getValue(),
						new Date(
								timeseriesType.getStartDate().longValue() * 1000),
						new Date(timeseriesType.getEndDate().longValue() * 1000),
						timeseriesType.getAcquisitionCount());
		return BigInteger.valueOf(keyHolder.getKey().longValue());
	}

	public void insert(Iterable<T> timeseries) {
		for (T timeseriesType : timeseries) {
			this.insert(timeseriesType);
		}
	}
}