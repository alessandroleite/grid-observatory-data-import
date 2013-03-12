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

import java.io.File;
import java.math.BigInteger;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.xml.bind.JAXBException;

import lshw.parser.xml.jaxb.JaxbXmlParser;

import org.gridobservatory.greencomputing.xml.types.GCOReport;
import org.gridobservatory.greencomputing.xml.types.MachineType;
import org.gridobservatory.greencomputing.xml.types.MachinesListType;
import org.gridobservatory.greencomputing.xml.types.MiddlewareListType;
import org.gridobservatory.greencomputing.xml.types.MiddlewareType;
import org.gridobservatory.greencomputing.xml.types.MotherboardType;
import org.gridobservatory.greencomputing.xml.types.MotherboardsListType;
import org.gridobservatory.greencomputing.xml.types.RoomType;
import org.gridobservatory.greencomputing.xml.types.RoomsListType;
import org.xml.sax.SAXException;

/**
 * This class is used to load the data available in the machines.xml file, such
 * as machine, middleware, motherboard and room.
 * 
 * @author alessandro
 */
public final class MachinesData {

	public MachinesData(GCOReport report) {
		
		loadMiddlewares(report.getMiddlewareList());
		loadMotherboards(report.getMotherboardsList());
		loadRooms(report.getRoomsList());
		
		loadMachines(report.getMachinesList());
	}

	public static MachinesData newMachines(JaxbXmlParser<GCOReport> parser,
			File xml) throws JAXBException, SAXException {
		return new MachinesData(parser.unmarshal(xml));
	}

	public static MachinesData newMachines(File xml) {
		try {
			return newMachines(new JaxbXmlParser<GCOReport>(GCOReport.class),
					xml);
		} catch (JAXBException | SAXException exception) {
			throw new RuntimeException(exception.getMessage(), exception);
		}
	}

	public static MachinesData newMachines(String xmlFilePath) {
		return newMachines(new File(xmlFilePath));
	}

	/**
	 * Returns a {@link Machine} that has a given ID or <code>null</code> if
	 * there isn't a machine with the given ID.
	 * 
	 * @param machineID
	 *            The ID of the {@link Machine} to be returned.
	 * @return A {@link Machine} that has a given ID or <code>null</code> if
	 *         there isn't a machine with the given ID.
	 */
	public Machine getMachineByID(BigInteger machineID) {
		return MACHINES.get(machineID);
	}

	/**
	 * Returns a {@link Room} that has a given ID or <code>null</code> if there
	 * isn't a room with the given ID.
	 * 
	 * @param roomID
	 *            The ID of the {@link Room} to be returned.
	 * @return A {@link Room} that has a given ID or <code>null</code> if there
	 *         isn't a {@link Room} with the given ID.
	 */
	public Room getRoomByID(BigInteger roomID) {
		return ROOMS.get(roomID);
	}

	/**
	 * Returns a {@link Motherboard} that has a given ID or <code>null</code> if
	 * it is unknown.
	 * 
	 * @param motherboardID
	 *            The ID of the {@link Motherboard} to be returned.
	 * @return A {@link Motherboard} that has a given ID or <code>null</code> if
	 *         it is unknown.
	 */
	public Motherboard getMotherboardByID(BigInteger motherboardID) {
		return MOTHERBOARDS.get(motherboardID);
	}

	/**
	 * 
	 * @param middlewareID
	 * @return
	 */
	public Middleware getMiddlewareByID(BigInteger middlewareID) {
		return MIDDLEWARES.get(middlewareID);
	}

	private final Map<BigInteger, Machine> MACHINES = new ConcurrentHashMap<>();

	private void loadMachines(MachinesListType machines) {
		for (MachineType machineType : machines.getMachine()) {
			Machine machine = new Machine(machineType);

			machine.setMiddleware(getMiddlewareByID(machineType
					.getMiddlewareID()));
			machine.setMotherboard(getMotherboardByID(machineType
					.getMotherboardID()));
			machine.setRoom(getRoomByID(machineType.getRoomID()));

			MACHINES.put(machineType.getMachineID(), machine);
		}
	}

	final Map<BigInteger, Room> ROOMS = new ConcurrentHashMap<>();

	protected void loadRooms(RoomsListType roomsList) {
		for (RoomType roomType : roomsList.getRoom()) {
			ROOMS.put(roomType.getRoomID(), new Room(roomType));
		}
	}

	final Map<BigInteger, Motherboard> MOTHERBOARDS = new ConcurrentHashMap<>();

	private void loadMotherboards(MotherboardsListType motherboardsList) {

		for (MotherboardType motherboardType : motherboardsList
				.getMotherboard()) {
			MOTHERBOARDS.put(motherboardType.getMotherboardID(),
					new Motherboard(motherboardType));
		}
	}

	final Map<BigInteger, Middleware> MIDDLEWARES = new ConcurrentHashMap<>();

	private void loadMiddlewares(MiddlewareListType middlewareList) {
		for (MiddlewareType middlewareType : middlewareList.getMiddleware()) {
			MIDDLEWARES.put(middlewareType.getMiddlewareID(), new Middleware(
					middlewareType));
		}
	}

	public Collection<Machine> machines() {
		return MACHINES.values();
	}

	public Collection<Middleware> middlewares() {
		return MIDDLEWARES.values();
	}

	public Collection<Motherboard> motherboards() {
		return MOTHERBOARDS.values();
	}

	public Rooms rooms() {
		return Rooms.newRooms(ROOMS.values());
	}
}