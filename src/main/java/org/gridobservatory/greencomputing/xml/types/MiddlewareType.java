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
 * <p>Java class for middlewareType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="middlewareType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence minOccurs="0">
 *         &lt;element name="propertiesList" type="{http://www.grid-observatory.org}propertiesListType"/>
 *       &lt;/sequence>
 *       &lt;attribute name="middlewareID" use="required" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *       &lt;attribute name="middlewareType" type="{http://www.grid-observatory.org}middlewareTypeType" />
 *       &lt;attribute name="productName" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="productVersion" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="kernelName" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="kernelVersion" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="arch" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "middlewareType", propOrder = {
    "propertiesList"
})
public class MiddlewareType implements Serializable {

	private static final long serialVersionUID = -3697567457209183589L;
	
	protected PropertiesListType propertiesList;
    @XmlAttribute(required = true)
    protected BigInteger middlewareID;
    @XmlAttribute
    protected MiddlewareTypeType middlewareType;
    @XmlAttribute
    protected String productName;
    @XmlAttribute
    protected String productVersion;
    @XmlAttribute
    protected String kernelName;
    @XmlAttribute
    protected String kernelVersion;
    @XmlAttribute
    protected String arch;

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
     * Gets the value of the middlewareType property.
     * 
     * @return
     *     possible object is
     *     {@link MiddlewareTypeType }
     *     
     */
    public MiddlewareTypeType getMiddlewareType() {
        return middlewareType;
    }

    /**
     * Sets the value of the middlewareType property.
     * 
     * @param value
     *     allowed object is
     *     {@link MiddlewareTypeType }
     *     
     */
    public void setMiddlewareType(MiddlewareTypeType value) {
        this.middlewareType = value;
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
     * Gets the value of the productVersion property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProductVersion() {
        return productVersion;
    }

    /**
     * Sets the value of the productVersion property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProductVersion(String value) {
        this.productVersion = value;
    }

    /**
     * Gets the value of the kernelName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getKernelName() {
        return kernelName;
    }

    /**
     * Sets the value of the kernelName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setKernelName(String value) {
        this.kernelName = value;
    }

    /**
     * Gets the value of the kernelVersion property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getKernelVersion() {
        return kernelVersion;
    }

    /**
     * Sets the value of the kernelVersion property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setKernelVersion(String value) {
        this.kernelVersion = value;
    }

    /**
     * Gets the value of the arch property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getArch() {
        return arch;
    }

    /**
     * Sets the value of the arch property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setArch(String value) {
        this.arch = value;
    }

}
