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

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for acquisitionToolType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="acquisitionToolType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="IPMI"/>
 *     &lt;enumeration value="Ganglia"/>
 *     &lt;enumeration value="PDU"/>
 *     &lt;enumeration value="other"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "acquisitionToolType")
@XmlEnum
public enum AcquisitionToolType {

    IPMI("IPMI"),
    @XmlEnumValue("Ganglia")
    GANGLIA("Ganglia"),
    PDU("PDU"),
    @XmlEnumValue("other")
    OTHER("other");
    private final String value;

    AcquisitionToolType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AcquisitionToolType fromValue(String v) {
        for (AcquisitionToolType c: AcquisitionToolType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }
}