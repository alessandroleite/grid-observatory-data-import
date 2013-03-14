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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;

import org.gridobservatory.greencomputing.adapters.Machine;
import org.gridobservatory.greencomputing.adapters.Middleware;
import org.gridobservatory.greencomputing.adapters.Motherboard;
import org.gridobservatory.greencomputing.adapters.Room;
import org.gridobservatory.greencomputing.repository.MachineRepository;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class MachineDao extends DaoSupport implements MachineRepository {

	@Override
	public Machine findById(BigInteger id) {
		return this
				.getJdbcTemplate()
				.queryForObject(
						"select machine_id, room_id, motherboard_id, middleware_id, date_created, date_retired from machine where machine_id = ?",
						new Object[] { id }, new RowMapper<Machine>() {
							@Override
							public Machine mapRow(ResultSet rs, int rowNum)
									throws SQLException {
								int i = 1;
								Machine machine = new Machine();
								machine.setMachineID(rs.getBigDecimal(i++)
										.toBigIntegerExact());

								machine.setRoom(new Room());
								machine.getRoom().setRoomID(
										rs.getBigDecimal(i++)
												.toBigIntegerExact());

								machine.setMotherboard(new Motherboard());
								machine.getMotherboard().setMotherboardID(
										rs.getBigDecimal(i++)
												.toBigIntegerExact());

								machine.setMiddleware(new Middleware());
								machine.getMiddleware().setMiddlewareID(
										rs.getBigDecimal(i++)
												.toBigIntegerExact());

								machine.setDateCreated(BigInteger.valueOf(rs
										.getTimestamp(i++).getTime()));

								return machine;
							}
						});
	}

	@Override
	public void insert(Machine machine) {
		this.insert(Collections.singleton(machine));
	}

	@Override
	public void insert(Iterable<Machine> machines) {
		for (Machine machine : machines) {
			this.getJdbcTemplate()
					.update("insert into machine (machine_id, room_id, motherboard_id, middleware_id, date_created, date_retired) values (?,?,?,?,?,?)",
							machine.getMachineID(),
							machine.getRoom().getRoomID(),
							machine.getMotherboard().getMotherboardID(),
							machine.getMiddleware().getMiddlewareID(),
							machine.getDateCreated().toDate(),
							machine.getDateRetired() != null ? machine
									.getDateRetired().toDate() : null);
		}
	}
}