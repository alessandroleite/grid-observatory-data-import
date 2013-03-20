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
package org.gridobservatory.greencomputing.main;

import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.gridobservatory.greencomputing.adapters.Machine;
import org.gridobservatory.greencomputing.adapters.Machines;
import org.gridobservatory.greencomputing.adapters.MachinesData;
import org.gridobservatory.greencomputing.repository.RepositoryFactory;
import org.gridobservatory.greencomputing.xml.types.SensorType;


import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;

public class MainLoadDomainTables {

	@Parameter(names = "-in", required = true, description = "The input path with the machines' XML file.")
	private String inputXmlPath;
	
	public void load() throws InterruptedException {
		final MachinesData data = MachinesData.newMachines(inputXmlPath + "/machines.xml");
		
		final Machines machines = data.machines();
		
		RepositoryFactory.getMiddlewareRepository().insert(data.middlewares());
		RepositoryFactory.getMotherboardRepository().insert(data.motherboards());
		RepositoryFactory.getRoomRepository().insert(data.rooms());
		ExecutorService executor = Executors.newFixedThreadPool(100);
		
		Collection<Callable<Void>> tasks = new ArrayList<>();
		
		Collection<SensorType> sensors = new ArrayList<>(machines.sensors().values());
		sensors.addAll(data.rooms().sensors().values());
		
		
		for(final SensorType sensor: sensors) {
			tasks.add(new Callable<Void>() {

				@Override
				public Void call() throws Exception {
					RepositoryFactory.getSensorRepository().insert(sensor);
					return null;
				}
			});
		}
		
		for (final Machine machine: machines){
			tasks.add(new Callable<Void>() {

				@Override
				public Void call() throws Exception {
					RepositoryFactory.getMachineRepository().insert(machine);
					return null;
				}
			});
		}
		executor.invokeAll(tasks);
		
		executor.shutdown();
		if (executor.isTerminated()){
			System.exit(0);
		}
	}
	

	public static void main(String[] args) throws InterruptedException {

		MainLoadDomainTables m = new MainLoadDomainTables();

		JCommander jc = new JCommander();
		jc.addObject(m);

		if (args.length == 0) {
			jc.usage();
		} else {
			jc.parse(args);
			m.load();
		}
	}
}