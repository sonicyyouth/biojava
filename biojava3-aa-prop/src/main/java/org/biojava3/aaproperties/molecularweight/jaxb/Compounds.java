//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2011.06.09 at 10:02:06 AM SGT 
//


package org.biojava3.aaproperties.molecularweight.jaxb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{}elements"/>
 *         &lt;element ref="{}amino_acids"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "elements",
    "aminoAcids"
})
@XmlRootElement(name = "compounds")
public class Compounds {

    @XmlElement(required = true)
    protected Elements elements;
    @XmlElement(name = "amino_acids", required = true)
    protected AminoAcids aminoAcids;

    /**
     * Gets the value of the elements property.
     * 
     * @return
     *     possible object is
     *     {@link Elements }
     *     
     */
    public Elements getElements() {
        return elements;
    }

    /**
     * Sets the value of the elements property.
     * 
     * @param value
     *     allowed object is
     *     {@link Elements }
     *     
     */
    public void setElements(Elements value) {
        this.elements = value;
    }

    /**
     * Gets the value of the aminoAcids property.
     * 
     * @return
     *     possible object is
     *     {@link AminoAcids }
     *     
     */
    public AminoAcids getAminoAcids() {
        return aminoAcids;
    }

    /**
     * Sets the value of the aminoAcids property.
     * 
     * @param value
     *     allowed object is
     *     {@link AminoAcids }
     *     
     */
    public void setAminoAcids(AminoAcids value) {
        this.aminoAcids = value;
    }

}