package si.brodar.app.satellite;

import jakarta.persistence.*;

import java.time.LocalDateTime;


@Entity
@Table(name = "satellite_orbits", schema = "starlink")
public class Satellite {
    @Id
    @Column(name = "NORAD_CAT_ID")
    private int noradCatId;
    @Column(name = "OBJECT_NAME")
    private String objectName;
    @Column(name = "OBJECT_ID")
    private String objectId;
    @Column(name = "EPOCH")
    private LocalDateTime epoch;
    @Column(name = "MEAN_MOTION")
    private double meanMotion;
    @Column(name = "ECCENTRICITY")
    private double eccentricity;
    @Column(name = "INCLINATION")
    private double inclination;
    @Column(name = "RA_OF_ASC_NODE")
    private double raOfAscNode;
    @Column(name = "ARG_OF_PERICENTER")
    private double argOfPericenter;
    @Column(name = "MEAN_ANOMALY")
    private double meanAnomaly;
    @Column(name = "EPHEMERIS_TYPE")
    private int ephemerisType;
    @Column(name = "CLASSIFICATION_TYPE")
    private String classificationType;
    @Column(name = "ELEMENT_SET_NO")
    private int elementSetNo;
    @Column(name = "REV_AT_EPOCH")
    private int revAtEpoch;
    @Column(name = "BSTAR")
    private double bStar;
    @Column(name = "MEAN_MOTION_DOT")
    private double meanMotionDot;
    @Column(name = "MEANT_MOTION_DDOT")
    private double meanMotionDdot;

    public void setNoradCatId(Integer noradCatId) {
        this.noradCatId = noradCatId;
    }

    public Integer getId() {
        return noradCatId;
    }

}
