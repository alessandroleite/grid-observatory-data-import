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
 * <p>Java class for sensorType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="sensorType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence minOccurs="0">
 *         &lt;element name="propertiesList" type="{http://www.grid-observatory.org}propertiesListType"/>
 *       &lt;/sequence>
 *       &lt;attribute name="sensorID" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *       &lt;attribute name="sensorName" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="acquisitionTool" type="{http://www.grid-observatory.org}acquisitionToolType" />
 *       &lt;attribute name="unit" type="{http://www.grid-observatory.org}gcoUnitType" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "sensorType", propOrder = {
    "propertiesList"
})
public class SensorType {

    protected PropertiesListType propertiesList;
    @XmlAttribute
    protected BigInteger sensorID;
    @XmlAttribute
    protected String sensorName;
    @XmlAttribute
    protected AcquisitionToolType acquisitionTool;
    @XmlAttribute
    protected String unit;

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
     * Gets the value of the sensorID property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getSensorID() {
        return sensorID;
    }

    /**
     * Sets the value of the sensorID property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setSensorID(BigInteger value) {
        this.sensorID = value;
    }

    /**
     * Gets the value of the sensorName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSensorName() {
        return sensorName;
    }

    /**
     * Sets the value of the sensorName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSensorName(String value) {
        this.sensorName = value;
    }

    /**
     * Gets the value of the acquisitionTool property.
     * 
     * @return
     *     possible object is
     *     {@link AcquisitionToolType }
     *     
     */
    public AcquisitionToolType getAcquisitionTool() {
        return acquisitionTool;
    }

    /**
     * Sets the value of the acquisitionTool property.
     * 
     * @param value
     *     allowed object is
     *     {@link AcquisitionToolType }
     *     
     */
    public void setAcquisitionTool(AcquisitionToolType value) {
        this.acquisitionTool = value;
    }

    /**
     * Gets the value of the unit property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUnit() {
        return unit;
    }

    /**
     * Sets the value of the unit property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUnit(String value) {
        this.unit = value;
    }

}
