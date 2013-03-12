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
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

import org.apache.commons.lang.builder.CompareToBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.gridobservatory.greencomputing.xml.types.MachineSensorsListType;
import org.gridobservatory.greencomputing.xml.types.MachineTimeseriesType;
import org.gridobservatory.greencomputing.xml.types.MachineType;
import org.gridobservatory.greencomputing.xml.types.PropertiesListType;
import org.gridobservatory.greencomputing.xml.types.SensorType;
import org.joda.time.DateTime;

public class Machine implements Comparable<Machine> {

	private final MachineType machineType;

	private Room room;

	private Motherboard motherboard;

	private Middleware middleware;

	private final List<MachineTimeseriesType> timeSeries = new CopyOnWriteArrayList<>();

	private final Map<BigInteger, SensorType> sensorsMap = new ConcurrentHashMap<>();

	public Machine() {
		this(new MachineType());
	}

	public Machine(MachineType machineType) {
		this.machineType = machineType;

		if (machineType.getSensorsList() != null) {
			for (SensorType sensor : machineType.getSensorsList().getSensor()) {
				this.sensorsMap.put(sensor.getSensorID(), sensor);
			}
		}
	}

	public void addMachineTimeseriesType(MachineTimeseriesType timeseries) {
		if (timeseries != null) {

			if (timeseries.getMachineID() == null) {
				timeseries.setMachineID(this.getMachineID());
			} else if (!timeseries.getMachineID().equals(this.getMachineID())) {
				throw new IllegalArgumentException(
						String.format("Timeseries' machineID is different of this machineID (%s, %s)",
								timeseries.getMachineID(), this.getMachineID()));
			}
			
			if (this.sensorsMap.get(timeseries.getSensorID()) == null) {
				throw new IllegalArgumentException(
						String.format("SensorID (%s) does not found", timeseries.getSensorID()));
			}
			
			this.timeSeries.add(timeseries);
		}
	}

	public void addSensorType(SensorType sensor) {
		if (sensor != null) {
			synchronized (this.machineType) {
				if (machineType.getSensorsList() == null) {
					machineType.setSensorsList(new MachineSensorsListType());
				}
				this.sensorsMap.put(sensor.getSensorID(), sensor);
				this.machineType.getSensorsList().getSensor().add(sensor);
			}
		}
	}
	
	public SensorType getSensorTypeById(BigInteger sensorID) {
		return this.sensorsMap.get(sensorID);
	}

	public BigInteger getMachineID() {
		return machineType.getMachineID();
	}

	public void setMachineID(BigInteger machineID) {
		this.machineType.setMachineID(machineID);
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		
		if (room == null) {
			throw new NullPointerException("Room must not be null!");
		}
		
		room.addMachine(this);
		this.room = room;
	}

	public Motherboard getMotherboard() {
		return motherboard;
	}

	public void setMotherboard(Motherboard motherboard) {
		this.motherboard = motherboard;
	}

	public Middleware getMiddleware() {
		return middleware;
	}

	public void setMiddleware(Middleware middleware) {
		this.middleware = middleware;
	}
	
	public void setDateCreated(BigInteger value) {
		this.machineType.setDateCreated(value.divide(BigInteger.valueOf(1000L)));
	}

	public DateTime getDateCreated() {
		return new DateTime(machineType.getDateCreated().longValue() * 1000l);
	}

	public DateTime getDateRetired() {
		return new DateTime(machineType.getDateRetired().longValue() * 1000l);
	}

	public Collection<SensorType> getSensors() {
		return Collections.unmodifiableCollection(this.sensorsMap.values());
	}

	public PropertiesListType getProperties() {
		return machineType.getPropertiesList();
	}

	public List<MachineTimeseriesType> getTimeSeries() {
		return Collections.unmodifiableList(timeSeries);
	}

	@Override
	public int compareTo(Machine other) {
		return CompareToBuilder.reflectionCompare(this.getMachineID(),
				other.getMachineID());
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime
				* result
				+ ((this.getMachineID() == null) ? 0 : this.getMachineID()
						.hashCode());
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
		Machine other = (Machine) obj;
		if (this.getMachineID() == null) {
			if (other.getMachineID() != null) {
				return false;
			}
		} else if (!this.getMachineID().equals(other.getMachineID())) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this,
				ToStringStyle.SHORT_PREFIX_STYLE);
	}


}