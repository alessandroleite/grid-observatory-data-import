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
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

import org.gridobservatory.greencomputing.xml.types.SensorType;

public final class Sensors implements Iterable<SensorType> {

	private final Map<BigInteger, SensorType> sensors = new ConcurrentHashMap<>();

	public Collection<SensorType> values() {
		return Collections.unmodifiableCollection(this.sensors.values());
	}

	public Map<BigInteger, SensorType> asMap() {
		return Collections.unmodifiableMap(this.sensors);
	}

	public Sensors(SensorType... sensors) {
		this(sensors != null ? Arrays.asList(sensors) : Collections
				.<SensorType> emptyList());
	}

	public Sensors(Collection<SensorType> sensors) {
		for (SensorType sensor : sensors) {
			this.sensors.put(Objects.requireNonNull(sensor.getSensorID()),
					sensor);
		}
	}

	public Sensors(Map<BigInteger, SensorType> sensors) {
		this(sensors.values());
	}

	public Sensors(Map<BigInteger, SensorType>[] sensorsMap) {
		for (Map<BigInteger, SensorType> map : sensorsMap) {
			addAll(map);
		}
	}
	
	public static Sensors newSensors(Collection<SensorType> sensors) {
		return new Sensors(sensors);
	}

	public static Sensors newSensors(Map<BigInteger, SensorType>[] sensorsMap) {
		return new Sensors(sensorsMap);
	}

	public static Sensors newSensors(Map<BigInteger, SensorType> sensorsMap) {
		return new Sensors(sensorsMap);
	}


	public Sensors addAll(Map<BigInteger, SensorType> sensorsToAdd) {
		for (SensorType sensor : sensorsToAdd.values()) {
			this.sensors.put(Objects.requireNonNull(sensor.getSensorID()),
					sensor);
		}
		return this;
	}

	public Sensors copy(Sensors sensors) {
		this.sensors.putAll(sensors.sensors);
		
		return this;
	}
	
	public int size() {
		return this.sensors.size();
	}
	
	public void removeAll(Iterable<BigInteger> keys) {
		for (BigInteger key : keys) {
			this.sensors.remove(key);
		}
	}
	

	@Override
	public Iterator<SensorType> iterator() {
		return this.values().iterator();
	}

	


	
}