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
package org.gridobservatory.greencomputing.adapters;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

import org.gridobservatory.greencomputing.xml.types.SensorType;

public class Rooms implements Iterable<Room> {

	private final Map<BigInteger, Room> rooms = new ConcurrentHashMap<>();

	public Rooms(Room... rooms) {
		this(rooms == null ? Collections.<Room> emptyList() : Arrays.asList(rooms));
	}

	public Rooms(Collection<Room> rooms) {
		for (Room room : rooms) {
			this.rooms.put(Objects.requireNonNull(room.getRoomID()), room);
		}
	}

	public Rooms(Map<BigInteger, Room> rooms) {
		this(rooms.values());
	}

	public static Rooms newRooms(Collection<Room> rooms) {
		return new Rooms(rooms);
	}

	public Collection<Room> values() {
		return Collections.unmodifiableCollection(rooms.values());
	}

	public Sensors sensors() {
		Map<BigInteger, SensorType> sensors = new HashMap<>();

		for (Room room : rooms.values()) {
			for (SensorType sensor : room.getSensors()) {
				sensors.put(sensor.getSensorID(), sensor);
			}
		}
		
		return Sensors.newSensors(sensors);
	}
		
	@Override
	public Iterator<Room> iterator() {
		return values().iterator();
	}
}