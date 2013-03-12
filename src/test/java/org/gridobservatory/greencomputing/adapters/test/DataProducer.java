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
package org.gridobservatory.greencomputing.adapters.test;

import java.io.File;
import java.io.FileFilter;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import javax.xml.bind.JAXBException;

import org.gridobservatory.greencomputing.adapters.MachinesData;
import org.xml.sax.SAXException;

public class DataProducer {

	static Map<String, File> files(String directory) {
		Map<String, File> fileMap = new HashMap<>();
		for (File file : new File(directory).listFiles(new FileFilter() {
			@Override
			public boolean accept(File fileFilter) {
				return (fileFilter.isDirectory() || fileFilter.getName()
						.endsWith(".xml"));
			}
		})) {
			fileMap.put(file.getName(), file);
		}
		return fileMap;
	}

	static String XML_DATA_DIRECTORY = "/home/alessandro/workspace/grid-observatory-power-analysis/";

	static final MachinesData MACHINES_DATA = MachinesData
			.newMachines(XML_DATA_DIRECTORY + "machines.xml");

	public static void main(String[] args) throws JAXBException, SAXException, MalformedURLException {
		Map<String, File> data = files(XML_DATA_DIRECTORY);
		data.remove("machines.xml");
		
		
		long start = System.currentTimeMillis();
		DataConsumer[] consumers = new DataConsumer[Runtime.getRuntime().availableProcessors()];
		List<File> files = new ArrayList<>(data.values());
		
		int n = files.size() / consumers.length;
		int m = (files.size() % consumers.length);
		
		for (int i = 0, j = 0, k = n; i < consumers.length; i++, j = k, k += n) {
			consumers[i] = new DataConsumer(MACHINES_DATA);
			
			if (i == consumers.length -1 && m > 0) {
				k += m;
			}
			consumers[i].consume(files.subList(j, k));
		}
		
		long end = System.currentTimeMillis() - start;
		System.out.printf("Time slapsed: %s seconds, %s millis\n",
				TimeUnit.SECONDS.convert(end, TimeUnit.MILLISECONDS), end);
	}
}