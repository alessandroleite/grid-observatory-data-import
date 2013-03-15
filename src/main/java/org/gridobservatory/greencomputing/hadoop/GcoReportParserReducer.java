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
package org.gridobservatory.greencomputing.hadoop;

import java.io.IOException;
import java.util.List;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.log4j.Logger;
import org.gridobservatory.greencomputing.repository.RepositoryFactory;
import org.gridobservatory.greencomputing.xml.types.AcquisitionToolAliveBinaryTimeseriesType;
import org.gridobservatory.greencomputing.xml.types.GCOReport;
import org.gridobservatory.greencomputing.xml.types.MachineTimeseriesType;
import org.gridobservatory.greencomputing.xml.types.RoomTimeseriesType;
import org.gridobservatory.greencomputing.xml.types.TimeseriesListType;

public class GcoReportParserReducer extends
		Reducer<NullWritable, GCOReport, NullWritable, Text> {
	
	private static final transient Logger log = Logger.getLogger(GcoReportParserReducer.class.getName());

	@Override
	protected void reduce(NullWritable key, Iterable<GCOReport> values,
			Context context) throws IOException, InterruptedException {

		for (GCOReport report : values) {
			process(report);
		}
	}

	private void process(GCOReport report) {
		TimeseriesListType timeseriesList = report.getTimeseriesList();

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
				log.debug("Unknown timeseries type " + obj.getClass());
			}
		}
	}

	private void binaryTimeseriesType(
			AcquisitionToolAliveBinaryTimeseriesType obj) {
		log.debug("Binary timeseries type " + ToStringBuilder.reflectionToString(obj, ToStringStyle.SHORT_PREFIX_STYLE));
	}

	private void machineTimeSeries(MachineTimeseriesType machineTimeseriesType) {
		RepositoryFactory.getMachineTimeseriesRepository().insert(machineTimeseriesType);
	}

	private void roomTimeSeries(RoomTimeseriesType roomTimeseriesType) {
		RepositoryFactory.getRoomTimeseriesRepository().insert(roomTimeseriesType);
	}
}