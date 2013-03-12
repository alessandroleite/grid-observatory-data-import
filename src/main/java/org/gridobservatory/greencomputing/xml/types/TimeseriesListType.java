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
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for timeseriesListType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="timeseriesListType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;choice maxOccurs="unbounded" minOccurs="0">
 *         &lt;element name="machineTimeseries" type="{http://www.grid-observatory.org}machineTimeseriesType"/>
 *         &lt;element name="roomTimeseries" type="{http://www.grid-observatory.org}roomTimeseriesType"/>
 *         &lt;element name="acquisitionToolAliveTimeseries" type="{http://www.grid-observatory.org}acquisitionToolAliveBinaryTimeseriesType"/>
 *       &lt;/choice>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "timeseriesListType", propOrder = {
    "machineTimeseriesOrRoomTimeseriesOrAcquisitionToolAliveTimeseries"
})
public class TimeseriesListType implements Serializable {

	private static final long serialVersionUID = 6989549174739186655L;
	@XmlElements({
        @XmlElement(name = "roomTimeseries", type = RoomTimeseriesType.class),
        @XmlElement(name = "machineTimeseries", type = MachineTimeseriesType.class),
        @XmlElement(name = "acquisitionToolAliveTimeseries", type = AcquisitionToolAliveBinaryTimeseriesType.class)
    })
    protected List<Object> machineTimeseriesOrRoomTimeseriesOrAcquisitionToolAliveTimeseries;

    /**
     * Gets the value of the machineTimeseriesOrRoomTimeseriesOrAcquisitionToolAliveTimeseries property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the machineTimeseriesOrRoomTimeseriesOrAcquisitionToolAliveTimeseries property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMachineTimeseriesOrRoomTimeseriesOrAcquisitionToolAliveTimeseries().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link RoomTimeseriesType }
     * {@link MachineTimeseriesType }
     * {@link AcquisitionToolAliveBinaryTimeseriesType }
     * 
     * 
     */
    public List<Object> getMachineTimeseriesOrRoomTimeseriesOrAcquisitionToolAliveTimeseries() {
        if (machineTimeseriesOrRoomTimeseriesOrAcquisitionToolAliveTimeseries == null) {
            machineTimeseriesOrRoomTimeseriesOrAcquisitionToolAliveTimeseries = new ArrayList<Object>();
        }
        return this.machineTimeseriesOrRoomTimeseriesOrAcquisitionToolAliveTimeseries;
    }

}
