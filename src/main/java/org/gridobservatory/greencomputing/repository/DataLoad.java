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

import org.gridobservatory.greencomputing.adapters.MachinesData;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DataLoad {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				new String[] { "/config/spring/application.xml" });

		MachinesData data = MachinesData.newMachines(new File(
				"/home/alessandro/workspace/grid-observatory-power-analysis/"
						+ "data/2012-03-05_2012-03-11/machines.xml"));

//		context.getBean(SensorRepository.class);
//
//		context.getBean(RoomRepository.class).insert(data.rooms());
//
//		context.getBean(MiddlewareRepository.class).insert(data.middlewares());

		context.getBean(MotherboardRepository.class).insert(data.motherboards());

	}
}