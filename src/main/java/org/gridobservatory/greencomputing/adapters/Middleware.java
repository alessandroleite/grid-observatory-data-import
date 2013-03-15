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

import java.math.BigInteger;

import org.apache.commons.lang.builder.CompareToBuilder;
import org.gridobservatory.greencomputing.xml.types.MiddlewareType;
import org.gridobservatory.greencomputing.xml.types.MiddlewareTypeType;
import org.gridobservatory.greencomputing.xml.types.PropertiesListType;

public final class Middleware implements Comparable<Middleware> {

	protected final MiddlewareType middlewareType;

	public Middleware() {
		this(new MiddlewareType());
	}

	public Middleware(MiddlewareType middlewareType) {
		this.middlewareType = middlewareType;
	}

	@Override
	public int compareTo(Middleware other) {
		return CompareToBuilder.reflectionCompare(this.getMiddlewareID(),
				other.getMiddlewareID());
	}

	public PropertiesListType getPropertiesList() {
		return middlewareType.getPropertiesList();
	}

	public void setPropertiesList(PropertiesListType propertiesList) {
		this.middlewareType.setPropertiesList(propertiesList);
	}

	public BigInteger getMiddlewareID() {
		return middlewareType.getMiddlewareID();
	}

	public void setMiddlewareID(BigInteger middlewareID) {
		this.middlewareType.setMiddlewareID(middlewareID);
	}

	public MiddlewareTypeType getMiddlewareType() {
		return middlewareType.getMiddlewareType();
	}

	public void setMiddlewareType(MiddlewareTypeType middlewareType_) {
		this.middlewareType.setMiddlewareType(middlewareType_);
	}

	public String getProductName() {
		return middlewareType.getProductName();
	}

	public void setProductName(String productName) {
		this.middlewareType.setProductName(productName);
	}

	public String getProductVersion() {
		return middlewareType.getProductVersion();
	}

	public void setProductVersion(String productVersion) {
		this.middlewareType.setProductVersion(productVersion);
	}

	public String getKernelName() {
		return middlewareType.getKernelName();
	}

	public void setKernelName(String kernelName) {
		this.middlewareType.setKernelName(kernelName);
	}

	public String getKernelVersion() {
		return middlewareType.getKernelVersion();
	}

	public void setKernelVersion(String kernelVersion) {
		this.middlewareType.setKernelVersion(kernelVersion);
	}

	public String getArch() {
		return middlewareType.getArch();
	}

	public void setArch(String arch) {
		this.middlewareType.getArch();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime
				* result
				+ ((getMiddlewareID() == null) ? 0 : getMiddlewareID()
						.hashCode());
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
		Middleware other = (Middleware) obj;
		if (getMiddlewareID() == null) {
			if (other.getMiddlewareID() != null) {
				return false;
			}
		} else if (!getMiddlewareID().equals(other.getMiddlewareID())) {
			return false;
		}
		return true;
	}
}
