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
package org.gridobservatory.greencomputing.repository;

import org.gridobservatory.greencomputing.xml.types.SensorType;
import org.springframework.stereotype.Repository;

@Repository("sensorRepository")
public class SensorRepository extends RepositorySupport {



	public void insert(SensorType sensor) {
		this.getJdbcTemplate()
				.update("insert into sensor (sensor_id, sensor_name, acquisition_tool_type, unit) values (?,?,?,?)",
						sensor.getSensorID(), sensor.getSensorName(),
						sensor.getAcquisitionTool().name(), sensor.getUnit());
	}
}
