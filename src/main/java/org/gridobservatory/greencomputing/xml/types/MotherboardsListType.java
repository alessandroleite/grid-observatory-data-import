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
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for motherboardsListType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="motherboardsListType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence maxOccurs="unbounded" minOccurs="0">
 *         &lt;element name="motherboard" type="{http://www.grid-observatory.org}motherboardType"/>
 *       &lt;/sequence>
 *       &lt;attribute name="validAtDate" use="required" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "motherboardsListType", propOrder = {
    "motherboard"
})
public class MotherboardsListType implements Serializable {

	private static final long serialVersionUID = -5167309732717234499L;
	
	protected List<MotherboardType> motherboard;
    @XmlAttribute(required = true)
    protected BigInteger validAtDate;

    /**
     * Gets the value of the motherboard property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the motherboard property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMotherboard().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link MotherboardType }
     * 
     * 
     */
    public List<MotherboardType> getMotherboard() {
        if (motherboard == null) {
            motherboard = new ArrayList<MotherboardType>();
        }
        return this.motherboard;
    }

    /**
     * Gets the value of the validAtDate property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getValidAtDate() {
        return validAtDate;
    }

    /**
     * Sets the value of the validAtDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setValidAtDate(BigInteger value) {
        this.validAtDate = value;
    }

}
