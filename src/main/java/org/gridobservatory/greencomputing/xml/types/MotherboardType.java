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
 * <p>Java class for motherboardType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="motherboardType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence minOccurs="0">
 *         &lt;element name="propertiesList" type="{http://www.grid-observatory.org}propertiesListType"/>
 *       &lt;/sequence>
 *       &lt;attribute name="motherboardID" use="required" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *       &lt;attribute name="productManufacturer" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="productName" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="partNumber" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="boardSerial" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="boardManufacturing" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="boardProduct" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="manufacturingDate" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="dateFrom" use="required" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "motherboardType", propOrder = {
    "propertiesList"
})
public class MotherboardType implements Serializable {

	private static final long serialVersionUID = 555614463981956030L;
	
	protected PropertiesListType propertiesList;
    @XmlAttribute(required = true)
    protected BigInteger motherboardID;
    @XmlAttribute
    protected String productManufacturer;
    @XmlAttribute
    protected String productName;
    @XmlAttribute
    protected String partNumber;
    @XmlAttribute
    protected String boardSerial;
    @XmlAttribute
    protected String boardManufacturing;
    @XmlAttribute
    protected String boardProduct;
    @XmlAttribute
    protected String manufacturingDate;
    @XmlAttribute(required = true)
    protected BigInteger dateFrom;

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
     * Gets the value of the productManufacturer property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProductManufacturer() {
        return productManufacturer;
    }

    /**
     * Sets the value of the productManufacturer property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProductManufacturer(String value) {
        this.productManufacturer = value;
    }

    /**
     * Gets the value of the productName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProductName() {
        return productName;
    }

    /**
     * Sets the value of the productName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProductName(String value) {
        this.productName = value;
    }

    /**
     * Gets the value of the partNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPartNumber() {
        return partNumber;
    }

    /**
     * Sets the value of the partNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPartNumber(String value) {
        this.partNumber = value;
    }

    /**
     * Gets the value of the boardSerial property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBoardSerial() {
        return boardSerial;
    }

    /**
     * Sets the value of the boardSerial property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBoardSerial(String value) {
        this.boardSerial = value;
    }

    /**
     * Gets the value of the boardManufacturing property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBoardManufacturing() {
        return boardManufacturing;
    }

    /**
     * Sets the value of the boardManufacturing property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBoardManufacturing(String value) {
        this.boardManufacturing = value;
    }

    /**
     * Gets the value of the boardProduct property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBoardProduct() {
        return boardProduct;
    }

    /**
     * Sets the value of the boardProduct property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBoardProduct(String value) {
        this.boardProduct = value;
    }

    /**
     * Gets the value of the manufacturingDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getManufacturingDate() {
        return manufacturingDate;
    }

    /**
     * Sets the value of the manufacturingDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setManufacturingDate(String value) {
        this.manufacturingDate = value;
    }

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

}
