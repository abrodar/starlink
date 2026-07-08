package si.brodar.app.satellite;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "satellite_orbits", schema = "starlink")
public class Satellite {
    @Id
    @Column(name = "NORAD_CAT_ID")
    @JsonProperty("NORAD_CAT_ID")
    private Long noradCatId;
    @Column(name = "OBJECT_NAME")
    @JsonProperty("OBJECT_NAME")
    private String objectName;
    @Column(name = "OBJECT_ID")
    @JsonProperty("OBJECT_ID")
    private String objectId;
    @Column(name = "EPOCH")
    @JsonProperty("EPOCH")
    private LocalDateTime epoch;
    @Column(name = "MEAN_MOTION")
    @JsonProperty("MEAN_MOTION")
    private double meanMotion;
    @Column(name = "ECCENTRICITY")
    @JsonProperty("ECCENTRICITY")
    private double eccentricity;
    @Column(name = "INCLINATION")
    @JsonProperty("INCLINATION")
    private double inclination;
    @Column(name = "RA_OF_ASC_NODE")
    @JsonProperty("RA_OF_ASC_NODE")
    private double raOfAscNode;
    @Column(name = "ARG_OF_PERICENTER")
    @JsonProperty("ARG_OF_PERICENTER")
    private double argOfPericenter;
    @Column(name = "MEAN_ANOMALY")
    @JsonProperty("MEAN_ANOMALY")
    private double meanAnomaly;
    @Column(name = "EPHEMERIS_TYPE")
    @JsonProperty("EPHEMERIS_TYPE")
    private Long ephemerisType;
    @Column(name = "CLASSIFICATION_TYPE")
    @JsonProperty("CLASSIFICATION_TYPE")
    private String classificationType;
    @Column(name = "ELEMENT_SET_NO")
    @JsonProperty("ELEMENT_SET_NO")
    private Long elementSetNo;
    @Column(name = "REV_AT_EPOCH")
    @JsonProperty("REV_AT_EPOCH")
    private Long revAtEpoch;
    @Column(name = "BSTAR")
    @JsonProperty("BSTAR")
    private double bStar;
    @Column(name = "MEAN_MOTION_DOT")
    @JsonProperty("MEAN_MOTION_DOT")
    private double meanMotionDot;
    @Column(name = "MEAN_MOTION_DDOT")
    @JsonProperty("MEAN_MOTION_DDOT")
    private double meanMotionDdot;

    public void setNoradCatId(Long noradCatId) {
        this.noradCatId = noradCatId;
    }

    public Long getNoradCatId() {
        return noradCatId;
    }

    public void setObjectName(String objectName) {
        this.objectName = objectName;
    }

    public String getObjectName() {
        return objectName;
    }

    public void setObjectId(String objectId) {
        this.objectId = objectId;
    }

    public String getObjectId() {
        return objectId;
    }

    public void setEpoch(LocalDateTime epoch) {
        this.epoch = epoch;
    }

    public LocalDateTime getEpoch() {
        return epoch;
    }

    public void setMeanMotion(double meanMotion) {
        this.meanMotion = meanMotion;
    }

    public double getMeanMotion() {
        return meanMotion;
    }

    public void setEccentricity(double eccentricity) {
        this.eccentricity = eccentricity;
    }

    public double getEccentricity() {
        return eccentricity;
    }

    public void setInclination(double inclination) {
        this.inclination = inclination;
    }

    public double getInclination() {
        return inclination;
    }

    public void setRaOfAscNode(double raOfAscNode) {
        this.raOfAscNode = raOfAscNode;
    }

    public double getRaOfAscNode() {
        return raOfAscNode;
    }

    public void setArgOfPericenter(double argOfPericenter) {
        this.argOfPericenter = argOfPericenter;
    }

    public double getArgOfPericenter() {
        return argOfPericenter;
    }

    public void setMeanAnomaly(double meanAnomaly) {
        this.meanAnomaly = meanAnomaly;
    }

    public double getMeanAnomaly() {
        return meanAnomaly;
    }

    public void setEphemerisType(Long ephemerisType) {
        this.ephemerisType = ephemerisType;
    }

    public Long getEphemerisType() {
        return ephemerisType;
    }

    public void setClassificationType(String classificationType) {
        this.classificationType = classificationType;
    }

    public String getClassificationType() {
        return classificationType;
    }

    public void setElementSetNo(Long elementSetNo) {
        this.elementSetNo = elementSetNo;
    }

    public Long getElementSetNo() {
        return elementSetNo;
    }

    public void setRevAtEpoch(Long revAtEpoch) {
        this.revAtEpoch = revAtEpoch;
    }

    public Long getRevAtEpoch() {
        return revAtEpoch;
    }

    public void setBStar(double bStar) {
        this.bStar = bStar;
    }

    public double getBStar() {
        return bStar;
    }

    public void setMeanMotionDot(double meanMotionDot) {
        this.meanMotionDot = meanMotionDot;
    }

    public double getMeanMotionDot() {
        return meanMotionDot;
    }

    public void setMeanMotionDdot(double meanMotionDdot) {
        this.meanMotionDdot = meanMotionDdot;
    }

    public double getMeanMotionDdot() {
        return meanMotionDdot;
    }

    @Override
    public String toString() {
        return "Satelite [ id = "+noradCatId+", object-name = "+objectName+" ]";
    }

}
