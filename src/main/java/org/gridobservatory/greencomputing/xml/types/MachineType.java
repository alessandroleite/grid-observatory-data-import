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
package org.gridobservatory.greencomputing.xml.types;

import java.io.Serializable;
import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for machineType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="machineType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence minOccurs="0">
 *         &lt;element name="sensorsList" type="{http://www.grid-observatory.org}machineSensorsListType" minOccurs="0"/>
 *         &lt;element name="propertiesList" type="{http://www.grid-observatory.org}propertiesListType" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="machineID" use="required" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *       &lt;attribute name="roomID" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *       &lt;attribute name="motherboardID" use="required" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *       &lt;attribute name="middlewareID" use="required" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *       &lt;attribute name="dateCreated" use="required" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *       &lt;attribute name="dateRetired" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "machineType", propOrder = {
    "sensorsList",
    "propertiesList"
})
public class MachineType implements Serializable {

	private static final long serialVersionUID = 7498202714439556714L;
	
	protected MachineSensorsListType sensorsList;
    protected PropertiesListType propertiesList;
    @XmlAttribute(required = true)
    protected BigInteger machineID;
    @XmlAttribute
    protected BigInteger roomID;
    @XmlAttribute(required = true)
    protected BigInteger motherboardID;
    @XmlAttribute(required = true)
    protected BigInteger middlewareID;
    @XmlAttribute(required = true)
    protected BigInteger dateCreated;
    @XmlAttribute
    protected BigInteger dateRetired;

    /**
     * Gets the value of the sensorsList property.
     * 
     * @return
     *     possible object is
     *     {@link MachineSensorsListType }
     *     
     */
    public MachineSensorsListType getSensorsList() {
        return sensorsList;
    }

    /**
     * Sets the value of the sensorsList property.
     * 
     * @param value
     *     allowed object is
     *     {@link MachineSensorsListType }
     *     
     */
    public void setSensorsList(MachineSensorsListType value) {
        this.sensorsList = value;
    }

    /**
     * Gets the value of the propertiesList property.
     * 
     * @return
     *     possible object is
     *     {@link PropertiesListType }
     *     
     */
    public PropertiesListType getPropertiesList() {
        return propertiesList;
    }

    /**
     * Sets the value of the propertiesList property.
     * 
     * @param value
     *     allowed object is
     *     {@link PropertiesListType }
     *     
     */
    public void setPropertiesList(PropertiesListType value) {
        this.propertiesList = value;
    }

    /**
     * Gets the value of the machineID property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getMachineID() {
        return machineID;
    }

    /**
     * Sets the value of the machineID property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setMachineID(BigInteger value) {
        this.machineID = value;
    }

    /**
     * Gets the value of the roomID property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getRoomID() {
        return roomID;
    }

    /**
     * Sets the value of the roomID property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setRoomID(BigInteger value) {
        this.roomID = value;
    }

    /**
     * Gets the value of the motherboardID property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getMotherboardID() {
        return motherboardID;
    }

    /**
     * Sets the value of the motherboardID property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setMotherboardID(BigInteger value) {
        this.motherboardID = value;
    }

    /**
     * Gets the value of the middlewareID property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getMiddlewareID() {
        return middlewareID;
    }

    /**
     * Sets the value of the middlewareID property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setMiddlewareID(BigInteger value) {
        this.middlewareID = value;
    }

    /**
     * Gets the value of the dateCreated property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getDateCreated() {
        return dateCreated;
    }

    /**
     * Sets the value of the dateCreated property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setDateCreated(BigInteger value) {
        this.dateCreated = value;
    }

    /**
     * Gets the value of the dateRetired property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getDateRetired() {
        return dateRetired;
    }

    /**
     * Sets the value of the dateRetired property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setDateRetired(BigInteger value) {
        this.dateRetired = value;
    }

}
