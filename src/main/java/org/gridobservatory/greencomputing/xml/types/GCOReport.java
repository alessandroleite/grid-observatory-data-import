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

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="roomsList" type="{http://www.grid-observatory.org}roomsListType" minOccurs="0"/>
 *         &lt;element name="machinesList" type="{http://www.grid-observatory.org}machinesListType" minOccurs="0"/>
 *         &lt;element name="motherboardsList" type="{http://www.grid-observatory.org}motherboardsListType" minOccurs="0"/>
 *         &lt;element name="middlewareList" type="{http://www.grid-observatory.org}middlewareListType" minOccurs="0"/>
 *         &lt;element name="timeseriesList" type="{http://www.grid-observatory.org}timeseriesListType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "roomsList",
    "machinesList",
    "motherboardsList",
    "middlewareList",
    "timeseriesList"
})
@XmlRootElement(name = "GCO-report")
public class GCOReport  implements Serializable {

	private static final long serialVersionUID = 3714722582293091898L;
	
	protected RoomsListType roomsList;
    protected MachinesListType machinesList;
    protected MotherboardsListType motherboardsList;
    protected MiddlewareListType middlewareList;
    protected TimeseriesListType timeseriesList;

    /**
     * Gets the value of the roomsList property.
     * 
     * @return
     *     possible object is
     *     {@link RoomsListType }
     *     
     */
    public RoomsListType getRoomsList() {
        return roomsList;
    }

    /**
     * Sets the value of the roomsList property.
     * 
     * @param value
     *     allowed object is
     *     {@link RoomsListType }
     *     
     */
    public void setRoomsList(RoomsListType value) {
        this.roomsList = value;
    }

    /**
     * Gets the value of the machinesList property.
     * 
     * @return
     *     possible object is
     *     {@link MachinesListType }
     *     
     */
    public MachinesListType getMachinesList() {
        return machinesList;
    }

    /**
     * Sets the value of the machinesList property.
     * 
     * @param value
     *     allowed object is
     *     {@link MachinesListType }
     *     
     */
    public void setMachinesList(MachinesListType value) {
        this.machinesList = value;
    }

    /**
     * Gets the value of the motherboardsList property.
     * 
     * @return
     *     possible object is
     *     {@link MotherboardsListType }
     *     
     */
    public MotherboardsListType getMotherboardsList() {
        return motherboardsList;
    }

    /**
     * Sets the value of the motherboardsList property.
     * 
     * @param value
     *     allowed object is
     *     {@link MotherboardsListType }
     *     
     */
    public void setMotherboardsList(MotherboardsListType value) {
        this.motherboardsList = value;
    }

    /**
     * Gets the value of the middlewareList property.
     * 
     * @return
     *     possible object is
     *     {@link MiddlewareListType }
     *     
     */
    public MiddlewareListType getMiddlewareList() {
        return middlewareList;
    }

    /**
     * Sets the value of the middlewareList property.
     * 
     * @param value
     *     allowed object is
     *     {@link MiddlewareListType }
     *     
     */
    public void setMiddlewareList(MiddlewareListType value) {
        this.middlewareList = value;
    }

    /**
     * Gets the value of the timeseriesList property.
     * 
     * @return
     *     possible object is
     *     {@link TimeseriesListType }
     *     
     */
    public TimeseriesListType getTimeseriesList() {
        return timeseriesList;
    }

    /**
     * Sets the value of the timeseriesList property.
     * 
     * @param value
     *     allowed object is
     *     {@link TimeseriesListType }
     *     
     */
    public void setTimeseriesList(TimeseriesListType value) {
        this.timeseriesList = value;
    }

}
