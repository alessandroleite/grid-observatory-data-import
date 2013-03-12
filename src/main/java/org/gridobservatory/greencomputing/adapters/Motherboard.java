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
package org.gridobservatory.greencomputing.adapters;

import java.math.BigInteger;

import org.apache.commons.lang.builder.CompareToBuilder;
import org.gridobservatory.greencomputing.xml.types.MotherboardType;
import org.gridobservatory.greencomputing.xml.types.PropertiesListType;
import org.joda.time.DateTime;

public class Motherboard implements Comparable<Motherboard> {

	protected final MotherboardType motherboardTypeAdapter;

	public Motherboard() {
		this(new MotherboardType());
	}

	public Motherboard(MotherboardType motherboardType) {
		this.motherboardTypeAdapter = motherboardType;
	}
	
	public PropertiesListType getPropertiesList() {
		return motherboardTypeAdapter.getPropertiesList();
	}

	public void setPropertiesList(PropertiesListType value) {
		this.motherboardTypeAdapter.setPropertiesList(value);
	}

	public BigInteger getMotherboardID() {
		return this.motherboardTypeAdapter.getMotherboardID();
	}

	public void setMotherboardID(BigInteger value) {
		this.motherboardTypeAdapter.setMotherboardID(value);
	}

	public String getProductManufacturer() {
		return motherboardTypeAdapter.getProductManufacturer();
	}

	public void setProductManufacturer(String value) {
		this.motherboardTypeAdapter.setProductManufacturer(value);
	}

	public String getProductName() {
		return this.motherboardTypeAdapter.getProductName();
	}

	public void setProductName(String value) {
		this.motherboardTypeAdapter.setProductName(value);
	}

	public String getPartNumber() {
		return this.motherboardTypeAdapter.getPartNumber();
	}

	public void setPartNumber(String value) {
		this.motherboardTypeAdapter.setPartNumber(value);
	}

	public String getBoardSerial() {
		return this.motherboardTypeAdapter.getBoardSerial();
	}

	public void setBoardSerial(String value) {
		this.motherboardTypeAdapter.setBoardSerial(value);
	}

	public String getBoardManufacturing() {
		return this.motherboardTypeAdapter.getBoardManufacturing();
	}

	public void setBoardManufacturing(String value) {
		this.motherboardTypeAdapter.setBoardManufacturing(value);
	}

	public String getBoardProduct() {
		return this.motherboardTypeAdapter.getBoardProduct();
	}

	public void setBoardProduct(String value) {
		this.motherboardTypeAdapter.setBoardProduct(value);
	}

	public String getManufacturingDate() {
		return this.motherboardTypeAdapter.getManufacturingDate();
	}

	public void setManufacturingDate(String value) {
		this.motherboardTypeAdapter.setManufacturingDate(value);
	}

	public DateTime getDateFrom() {
		return new DateTime(this.motherboardTypeAdapter.getDateFrom().longValue() * 1000l);
	}

	public void setDateFrom(BigInteger value) {
		this.motherboardTypeAdapter.setDateFrom(value);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime
				* result
				+ ((this.getMotherboardID() == null) ? 0 : this
						.getMotherboardID().hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}

		Motherboard other = (Motherboard) obj;
		if (this.getMotherboardID() == null) {
			if (other.getMotherboardID() != null) {
				return false;
			}
		} else if (!getMotherboardID().equals(other.getMotherboardID())) {
			return false;
		}
		return true;
	}
	
	@Override
	public int compareTo(Motherboard other) {
		return CompareToBuilder.reflectionCompare(this.getMotherboardID(),
				other.getMotherboardID());
	}
}