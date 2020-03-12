package edu.utcn.gpsm.position;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

/**
 * @author Radu Miron
 * @since 15.10.2019
 */
@Entity
@Data
public class Position {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(hidden = true)
    private Integer id;

    @Column(nullable = false, updatable = false)
    @CreationTimestamp
    @ApiModelProperty(hidden = true)
    private Date creationTime;

    private String terminalId;
    private String latitude;
    private String longitude;
    public Position(Date creationTime, String terminalId, String latitude, String longitude)
    {
        this.creationTime=creationTime;
        this.terminalId=terminalId;
        this.latitude=latitude;
        this.longitude=longitude;
    }
    public Position()
    {}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Date creationTime) {
        this.creationTime = creationTime;
    }

    public String getTerminalId() {
        return terminalId;
    }

    public void setTerminalId(String terminalId) {
        this.terminalId = terminalId;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }
}
