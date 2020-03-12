package edu.utcn.gpsm.position;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;


@Data
public class PositionDTO {
@Id
    private Integer id;
    private Date creationTime;

    private String terminalId;
    private String latitude;
    private String longitude;


    public PositionDTO(Position position){
        this.creationTime=position.getCreationTime();
        this.terminalId=position.getTerminalId();
        this.latitude=position.getLatitude();
        this.longitude=position.getLongitude();
        this.id=position.getId();
    }
    public PositionDTO()
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