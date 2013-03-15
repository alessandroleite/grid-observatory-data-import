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
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.commons.lang.builder.CompareToBuilder;
import org.gridobservatory.greencomputing.xml.types.PropertiesListType;
import org.gridobservatory.greencomputing.xml.types.RoomSensorsListType;
import org.gridobservatory.greencomputing.xml.types.RoomTimeseriesType;
import org.gridobservatory.greencomputing.xml.types.RoomType;
import org.gridobservatory.greencomputing.xml.types.SensorType;
import org.joda.time.DateTime;

public final class Room implements Comparable<Room> {

	protected final RoomType roomType;

	private final Map<BigInteger, SensorType> sensorsMap = new HashMap<>();

	private final List<RoomTimeseriesType> timeSeries = new ArrayList<>();

	private final Map<BigInteger, Machine> machines = new ConcurrentHashMap<>();

	public Room() {
		this(new RoomType());
	}

	public Room(RoomType roomType) {

		if (Objects.requireNonNull(roomType).getSensorsList() != null) {
			for (SensorType sensor : roomType.getSensorsList().getSensor()) {
				sensorsMap.put(sensor.getSensorID(), sensor);
			}
		}

		this.roomType = roomType;
	}

	public void addSensorType(SensorType sensor) {
		if (sensor != null) {
			synchronized (this.roomType) {
				if (roomType.getSensorsList() == null) {
					roomType.setSensorsList(new RoomSensorsListType());
				}
				this.sensorsMap.put(sensor.getSensorID(), sensor);
				this.roomType.getSensorsList().getSensor().add(sensor);
			}
		}
	}

	public void addRoomTimeseriesType(RoomTimeseriesType timeseries) {
		if (timeseries != null) {

			if (timeseries.getRoomID() == null) {
				timeseries.setRoomID(this.getRoomID());
			} else if (!timeseries.getRoomID().equals(this.getRoomID())) {
				throw new IllegalArgumentException(
						String.format(
								"Timeseries' getRoomID is different of this getRoomID (%s, %s)",
								timeseries.getRoomID(), this.getRoomID()));
			}

			if (this.sensorsMap.get(timeseries.getSensorID()) == null) {
				throw new IllegalArgumentException(String.format(
						"SensorID (%s) does not found",
						timeseries.getSensorID()));
			}
			this.timeSeries.add(timeseries);
		}
	}

	public Machine addMachine(Machine machine) {
		return this.machines.put(
				Objects.requireNonNull(machine.getMachineID()), machine);
	}

	public Machine removeMachine(Machine machine) {
		return this.removeMachine(machine.getMachineID());
	}

	public Machine removeMachine(BigInteger machineID) {
		return this.machines.remove(machineID);
	}

	public Machine getMachineByID(BigInteger machineID) {
		return this.machines.get(machineID);
	}

	public SensorType getSensorTypeByID(BigInteger sensorID) {
		return this.sensorsMap.get(sensorID);
	}

	public BigInteger getRoomID() {
		return roomType.getRoomID();
	}

	public void setRoomID(BigInteger roomID) {
		this.roomType.setRoomID(roomID);
	}

	public DateTime getDateCreated() {
		return new DateTime(roomType.getDateCreated().longValue() * 1000l);
	}

	public void setDateCreated(DateTime dateCreated) {
		this.roomType
				.setDateCreated(BigInteger.valueOf(dateCreated.getMillis() / 1000l));
	}

	public Collection<SensorType> getSensors() {
		return Collections.unmodifiableCollection(this.sensorsMap.values());
	}

	public Collection<Machine> getMachines() {
		return Collections.unmodifiableCollection(machines.values());
	}

	public PropertiesListType getProperties() {
		return roomType.getPropertiesList();
	}

	public List<RoomTimeseriesType> getTimeSeries() {
		return Collections.unmodifiableList(timeSeries);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((getRoomID() == null) ? 0 : getRoomID().hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Room other = (Room) obj;
		if (getRoomID() == null) {
			if (other.getRoomID() != null) {
				return false;
			}
		} else if (!getRoomID().equals(other.getRoomID())) {
			return false;
		}
		return true;
	}

	@Override
	public int compareTo(Room other) {
		return CompareToBuilder.reflectionCompare(this.getRoomID(),
				other.getRoomID());
	}
}