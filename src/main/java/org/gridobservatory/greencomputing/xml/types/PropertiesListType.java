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

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for propertiesListType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="propertiesListType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;choice maxOccurs="unbounded" minOccurs="0">
 *         &lt;element name="textProperty" type="{http://www.grid-observatory.org}textPropertyType"/>
 *         &lt;element name="numericProperty" type="{http://www.grid-observatory.org}numericPropertyType"/>
 *       &lt;/choice>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "propertiesListType", propOrder = {
    "textPropertyOrNumericProperty"
})
public class PropertiesListType {

    @XmlElements({
        @XmlElement(name = "numericProperty", type = NumericPropertyType.class),
        @XmlElement(name = "textProperty", type = TextPropertyType.class)
    })
    protected List<Object> textPropertyOrNumericProperty;

    /**
     * Gets the value of the textPropertyOrNumericProperty property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the textPropertyOrNumericProperty property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTextPropertyOrNumericProperty().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link NumericPropertyType }
     * {@link TextPropertyType }
     * 
     * 
     */
    public List<Object> getTextPropertyOrNumericProperty() {
        if (textPropertyOrNumericProperty == null) {
            textPropertyOrNumericProperty = new ArrayList<Object>();
        }
        return this.textPropertyOrNumericProperty;
    }

}
