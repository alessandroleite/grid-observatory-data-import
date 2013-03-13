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

import java.util.Collections;

import org.gridobservatory.greencomputing.adapters.Room;
import org.gridobservatory.greencomputing.repository.RoomRepository;
import org.springframework.stereotype.Repository;

@Repository
public class RoomDao extends DaoSupport implements RoomRepository {

	public void insert(Room room) {
		this.insert(Collections.singleton(room));
	}

	public void insert(Iterable<Room> rooms) {
		for (Room room : rooms) {
			this.getJdbcTemplate().update(
					"insert into room (room_id, date_created) values (?,?)",
					room.getRoomID(), room.getDateCreated().toDate());
		}
	}
}