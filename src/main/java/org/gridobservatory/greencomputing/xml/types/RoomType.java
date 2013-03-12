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
package org.gridobservatory.greencomputing.xml.types;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for roomType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="roomType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="sensorsList" type="{http://www.grid-observatory.org}roomSensorsListType" minOccurs="0"/>
 *         &lt;element name="propertiesList" type="{http://www.grid-observatory.org}propertiesListType" minOccurs="0"/>
 *       &lt;/all>
 *       &lt;attribute name="roomID" use="required" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *       &lt;attribute name="dateCreated" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "roomType", propOrder = {

})
public class RoomType {

    protected RoomSensorsListType sensorsList;
    protected PropertiesListType propertiesList;
    @XmlAttribute(required = true)
    protected BigInteger roomID;
    @XmlAttribute
    protected BigInteger dateCreated;

    /**
     * Gets the value of the sensorsList property.
     * 
     * @return
     *     possible object is
     *     {@link RoomSensorsListType }
     *     
     */
    public RoomSensorsListType getSensorsList() {
        return sensorsList;
    }

    /**
     * Sets the value of the sensorsList property.
     * 
     * @param value
     *     allowed object is
     *     {@link RoomSensorsListType }
     *     
     */
    public void setSensorsList(RoomSensorsListType value) {
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

}
