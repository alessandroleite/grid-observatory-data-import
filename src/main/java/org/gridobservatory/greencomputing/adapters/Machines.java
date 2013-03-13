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

public class Machines implements Iterable<Machine> {

	private final Map<BigInteger, Machine> machines = new ConcurrentHashMap<>();

	public Collection<Machine> values() {
		return Collections.unmodifiableCollection(this.machines.values());
	}

	public Machines(Machine... machines) {
		this(machines != null ? Arrays.asList(machines) : Collections
				.<Machine> emptyList());
	}

	public Machines(Collection<Machine> machines) {
		for (Machine machine : machines) {
			this.machines.put(Objects.requireNonNull(machine.getMachineID()),
					machine);
		}
	}

	public Machines(Map<BigInteger, Machine> machines) {
		this(machines.values());
	}

	public Collection<SensorType> sensors() {
		Map<BigInteger, SensorType> sensors = new HashMap<>();

		for (Machine machine : machines.values()) {
			for (SensorType sensor : machine.getSensors()) {
				sensors.put(sensor.getSensorID(), sensor);
			}
		}

		return Collections.unmodifiableCollection(sensors.values());
	}

	@Override
	public Iterator<Machine> iterator() {
		return this.values().iterator();
	}

	public static Machines newMachines(Collection<Machine> machines) {
		return new Machines(machines);
	}

}