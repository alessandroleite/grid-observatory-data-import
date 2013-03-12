/**
 * Copyright (C) 2013 Alessandro alessandro dot leite at alessandro dot cc
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
package org.gridobservatory.greencomputing.adapters.test;

import java.io.File;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.xml.bind.JAXBException;

import lshw.parser.xml.jaxb.JaxbXmlParser;

import org.gridobservatory.greencomputing.adapters.MachinesData;
import org.gridobservatory.greencomputing.xml.types.AcquisitionToolAliveBinaryTimeseriesType;
import org.gridobservatory.greencomputing.xml.types.GCOReport;
import org.gridobservatory.greencomputing.xml.types.MachineTimeseriesType;
import org.gridobservatory.greencomputing.xml.types.RoomTimeseriesType;
import org.gridobservatory.greencomputing.xml.types.TimeseriesListType;
import org.xml.sax.SAXException;

public class DataConsumer {

	// private BlockingDeque<File> queue = new LinkedBlockingDeque<>();

	private final MachinesData data;
	private final JaxbXmlParser<GCOReport> parser;
	private ExecutorService executor;

	public DataConsumer(MachinesData data) throws JAXBException {
		this.data = data;
		parser = new JaxbXmlParser<>(GCOReport.class);
		this.executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
	}
	
	public void consume(final List<File> files) {
		for (File file : files) {			
			consume(file);
		}
	}

	public void consume(final File file) {
		executor.execute(new Runnable() {
			@Override
			public void run() {
				parser(file);
			}
		});
	}

	private void parser(File file) {
		try {
			TimeseriesListType timeseriesList = parser.unmarshal(file)
					.getTimeseriesList();

			List<Object> machineTimeseriesOrRoomTimeseriesOrAcquisitionToolAliveTimeseries = timeseriesList
					.getMachineTimeseriesOrRoomTimeseriesOrAcquisitionToolAliveTimeseries();

			for (Object obj : machineTimeseriesOrRoomTimeseriesOrAcquisitionToolAliveTimeseries) {

				if (obj instanceof MachineTimeseriesType) {
					machineTimeSeries((MachineTimeseriesType) obj);
				} else if (obj instanceof AcquisitionToolAliveBinaryTimeseriesType) {
					binaryTimeseriesType((AcquisitionToolAliveBinaryTimeseriesType) obj);
				} else if (obj instanceof RoomTimeseriesType) {
					roomTimeSeries((RoomTimeseriesType) obj);
				} else {
					System.out.println(obj.getClass());
				}
			}
		} catch (JAXBException | SAXException e) {
			e.printStackTrace();
		}
		System.out.println(file.getName());
	}

	private void binaryTimeseriesType(
			AcquisitionToolAliveBinaryTimeseriesType obj) {
	}

	private void machineTimeSeries(MachineTimeseriesType machineTimeseriesType) {

		data.getMachineByID(machineTimeseriesType.getMachineID())
				.addMachineTimeseriesType(machineTimeseriesType);
	}

	private void roomTimeSeries(RoomTimeseriesType obj) {
		data.getRoomByID(obj.getRoomID()).addRoomTimeseriesType(obj);
	}
}