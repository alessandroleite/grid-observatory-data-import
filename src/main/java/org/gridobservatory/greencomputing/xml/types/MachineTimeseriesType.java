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
 * <p>Java class for machineTimeseriesType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="machineTimeseriesType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.grid-observatory.org}timeseriesType">
 *       &lt;attribute name="machineID" use="required" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *       &lt;attribute name="sensorID" use="required" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "machineTimeseriesType")
public class MachineTimeseriesType
    extends TimeseriesType
{

    @XmlAttribute(required = true)
    protected BigInteger machineID;
    @XmlAttribute(required = true)
    protected BigInteger sensorID;

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
}