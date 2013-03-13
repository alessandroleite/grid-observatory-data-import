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

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public final class RepositoryFactory {

	private final ApplicationContext context;
	
	private static final RepositoryFactory INSTANCE = new RepositoryFactory();

	private RepositoryFactory() {
		context = new ClassPathXmlApplicationContext(
				new String[] { "/config/spring/application.xml" });
	}

	public static MachineRepository getMachineRepository() {
		return INSTANCE.context.getBean(MachineRepository.class);
	}

	public static MachineTimeseriesRepository getMachineTimeseriesRepository() {
		return INSTANCE.context.getBean(MachineTimeseriesRepository.class);
	}

	public static MiddlewareRepository getMiddlewareRepository() {
		return INSTANCE.context.getBean(MiddlewareRepository.class);
	}

	public static MotherboardRepository getMotherboardRepository() {
		return INSTANCE.context.getBean(MotherboardRepository.class);
	}

	public static RoomRepository getRoomRepository() {
		return INSTANCE.context.getBean(RoomRepository.class);
	}

	public static RoomTimeseriesRepository getRoomTimeseriesRepository() {
		return INSTANCE.context.getBean(RoomTimeseriesRepository.class);
	}

	public static SensorRepository getSensorRepository() {
		return INSTANCE.context.getBean(SensorRepository.class);
	}
}