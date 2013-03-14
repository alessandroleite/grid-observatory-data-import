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

import java.io.IOException;

import org.gridobservatory.greencomputing.hadoop.job.GcoReportParserJob;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;

public class Main {

	@Parameter(names = "-in", required = true, description = "The input path with the XML(s) to be processed")
	private String inputPath;

	@Parameter(names = "-out", required = true, description = "The Hadoop' output path")
	private String outputPath;

	public void execute() throws IOException {
		GcoReportParserJob job = new GcoReportParserJob();
		job.runJob(inputPath, outputPath);
	}

	public static void main(String[] args) throws IOException {

		Main m = new Main();

		JCommander jc = new JCommander();
		jc.addObject(m);

		if (args.length < 2) {
			jc.usage();
		} else {
			jc.parse(args);
			m.execute();
		}
	}
}