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
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for binaryTimeseriesType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="binaryTimeseriesType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence maxOccurs="unbounded" minOccurs="0">
 *         &lt;element name="transition" type="{http://www.grid-observatory.org}binaryTimeseriesTransitionType"/>
 *       &lt;/sequence>
 *       &lt;attribute name="startDate" use="required" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *       &lt;attribute name="endDate" use="required" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *       &lt;attribute name="transitionCount" use="required" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *       &lt;attribute name="valueAtStart" use="required" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *       &lt;attribute name="valueAtEnd" use="required" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "binaryTimeseriesType", propOrder = {
    "transition"
})
@XmlSeeAlso({
    AcquisitionToolAliveBinaryTimeseriesType.class
})
public class BinaryTimeseriesType implements Serializable {

	private static final long serialVersionUID = 5352325908814056643L;
	
	protected List<BinaryTimeseriesTransitionType> transition;
    @XmlAttribute(required = true)
    protected BigInteger startDate;
    @XmlAttribute(required = true)
    protected BigInteger endDate;
    @XmlAttribute(required = true)
    protected BigInteger transitionCount;
    @XmlAttribute(required = true)
    protected BigInteger valueAtStart;
    @XmlAttribute(required = true)
    protected BigInteger valueAtEnd;

    /**
     * Gets the value of the transition property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the transition property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTransition().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link BinaryTimeseriesTransitionType }
     * 
     * 
     */
    public List<BinaryTimeseriesTransitionType> getTransition() {
        if (transition == null) {
            transition = new ArrayList<BinaryTimeseriesTransitionType>();
        }
        return this.transition;
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
     * Gets the value of the transitionCount property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getTransitionCount() {
        return transitionCount;
    }

    /**
     * Sets the value of the transitionCount property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setTransitionCount(BigInteger value) {
        this.transitionCount = value;
    }

    /**
     * Gets the value of the valueAtStart property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getValueAtStart() {
        return valueAtStart;
    }

    /**
     * Sets the value of the valueAtStart property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setValueAtStart(BigInteger value) {
        this.valueAtStart = value;
    }

    /**
     * Gets the value of the valueAtEnd property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getValueAtEnd() {
        return valueAtEnd;
    }

    /**
     * Sets the value of the valueAtEnd property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setValueAtEnd(BigInteger value) {
        this.valueAtEnd = value;
    }

}
