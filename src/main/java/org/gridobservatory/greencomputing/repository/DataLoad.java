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

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.gridobservatory.greencomputing.adapters.Machine;
import org.gridobservatory.greencomputing.adapters.Machines;
import org.gridobservatory.greencomputing.adapters.MachinesData;
import org.gridobservatory.greencomputing.adapters.Rooms;
import org.gridobservatory.greencomputing.xml.types.SensorType;

public class DataLoad {

	public static void main(String[] args) throws InterruptedException {
		MachinesData data = MachinesData.newMachines(new File(
				"/home/alessandro/workspace/grid-observatory-power-analysis/"
						+ "data/2012-03-05_2012-03-11/machines.xml"));

		final Machines machines = data.machines();
		final Rooms rooms = data.rooms();
		
		final SensorRepository sensorRepository = RepositoryFactory.getSensorRepository();

		new Thread(new Runnable() {
			@Override
			public void run() {
				ExecutorService executor = Executors.newFixedThreadPool(100);

				Collection<SensorType> sensors = new ArrayList<>(machines.sensors());
				sensors.addAll(rooms.sensors());

				Collection<Callable<Void>> callables = new ArrayList<>();

				for (final SensorType sensor : sensors) {
					callables.add(new Callable<Void>() {
						@Override
						public Void call() throws Exception {
							sensorRepository.insert(sensor);
							return null;
						}
					});
				}

				try {
					executor.invokeAll(callables);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}).start();

//		RepositoryFactory.getRoomRepository().insert(rooms);
//		RepositoryFactory.getMiddlewareRepository().insert(data.middlewares());
//		RepositoryFactory.getMotherboardRepository().insert(data.motherboards());
		
		new Thread(new Runnable() {
			@Override
			public void run() {
				Collection<Callable<Void>> machineCallables = new ArrayList<>();
				
				final MachineRepository machineRepository = RepositoryFactory.getMachineRepository();
				for(final Machine machine: machines) {
					machineCallables.add(new Callable<Void>() {
						@Override
						public Void call() throws Exception {
							machineRepository.insert(machine);
							return null;
						}
					});
				}
				try {
					Executors.newFixedThreadPool(100).invokeAll(machineCallables);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}).start();
	}
}