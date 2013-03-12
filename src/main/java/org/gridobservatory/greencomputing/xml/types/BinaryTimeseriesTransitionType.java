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
 * <p>Java class for binaryTimeseriesTransitionType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="binaryTimeseriesTransitionType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="dateFrom" use="required" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *       &lt;attribute name="dateTo" use="required" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *       &lt;attribute name="newValue" use="required" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "binaryTimeseriesTransitionType")
public class BinaryTimeseriesTransitionType {

    @XmlAttribute(required = true)
    protected BigInteger dateFrom;
    @XmlAttribute(required = true)
    protected BigInteger dateTo;
    @XmlAttribute(required = true)
    protected boolean newValue;

    /**
     * Gets the value of the dateFrom property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getDateFrom() {
        return dateFrom;
    }

    /**
     * Sets the value of the dateFrom property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setDateFrom(BigInteger value) {
        this.dateFrom = value;
    }

    /**
     * Gets the value of the dateTo property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getDateTo() {
        return dateTo;
    }

    /**
     * Sets the value of the dateTo property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setDateTo(BigInteger value) {
        this.dateTo = value;
    }

    /**
     * Gets the value of the newValue property.
     * 
     */
    public boolean isNewValue() {
        return newValue;
    }

    /**
     * Sets the value of the newValue property.
     * 
     */
    public void setNewValue(boolean value) {
        this.newValue = value;
    }

}
