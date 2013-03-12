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
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for timeseriesType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="timeseriesType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;choice>
 *         &lt;sequence maxOccurs="unbounded" minOccurs="0">
 *           &lt;element name="a" type="{http://www.grid-observatory.org}timeseriesAcquisitionType"/>
 *         &lt;/sequence>
 *         &lt;element name="constantValue" type="{http://www.grid-observatory.org}timeseriesConstantValueType"/>
 *       &lt;/choice>
 *       &lt;attribute name="startDate" use="required" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *       &lt;attribute name="endDate" use="required" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *       &lt;attribute name="acquisitionCount" use="required" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "timeseriesType", propOrder = {
    "a",
    "constantValue"
})
@XmlSeeAlso({
    MachineTimeseriesType.class,
    RoomTimeseriesType.class
})
public class TimeseriesType {

    protected List<TimeseriesAcquisitionType> a;
    protected TimeseriesConstantValueType constantValue;
    @XmlAttribute(required = true)
    protected BigInteger startDate;
    @XmlAttribute(required = true)
    protected BigInteger endDate;
    @XmlAttribute(required = true)
    protected BigInteger acquisitionCount;

    /**
     * Gets the value of the a property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the a property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getA().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TimeseriesAcquisitionType }
     * 
     * 
     */
    public List<TimeseriesAcquisitionType> getA() {
        if (a == null) {
            a = new ArrayList<TimeseriesAcquisitionType>();
        }
        return this.a;
    }

    /**
     * Gets the value of the constantValue property.
     * 
     * @return
     *     possible object is
     *     {@link TimeseriesConstantValueType }
     *     
     */
    public TimeseriesConstantValueType getConstantValue() {
        return constantValue;
    }

    /**
     * Sets the value of the constantValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link TimeseriesConstantValueType }
     *     
     */
    public void setConstantValue(TimeseriesConstantValueType value) {
        this.constantValue = value;
    }

    /**
     * Gets the value of the startDate property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getStartDate() {
        return startDate;
    }

    /**
     * Sets the value of the startDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setStartDate(BigInteger value) {
        this.startDate = value;
    }

    /**
     * Gets the value of the endDate property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getEndDate() {
        return endDate;
    }

    /**
     * Sets the value of the endDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setEndDate(BigInteger value) {
        this.endDate = value;
    }

    /**
     * Gets the value of the acquisitionCount property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getAcquisitionCount() {
        return acquisitionCount;
    }

    /**
     * Sets the value of the acquisitionCount property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setAcquisitionCount(BigInteger value) {
        this.acquisitionCount = value;
    }
}