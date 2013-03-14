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
import java.util.ArrayList;
import java.util.List;

import org.gridobservatory.greencomputing.repository.RoomTimeseriesRepository;
import org.gridobservatory.greencomputing.xml.types.RoomTimeseriesType;
import org.springframework.stereotype.Repository;

@Repository
public class RoomTimeseriesDao extends TimeseriesDao<RoomTimeseriesType>
		implements RoomTimeseriesRepository {

	@Override
	public BigInteger insert(RoomTimeseriesType roomTimeseriesType) {
		BigInteger id = super.insert(roomTimeseriesType);
		this.getJdbcTemplate()
				.update("insert into room_time_series (time_series_id, room_id, sensor_id) values (?, ?, ?)",
						id, roomTimeseriesType.getRoomID(),
						roomTimeseriesType.getSensorID());
		return id;
	}

	@Override
	public List<BigInteger> insert(Iterable<RoomTimeseriesType> timeseries) {
		List<BigInteger> ids = new ArrayList<>();
		for (RoomTimeseriesType roomTimeseriesType : timeseries) {
			ids.add(this.insert(roomTimeseriesType));
		}
		return ids;
	}
}
