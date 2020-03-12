package com.example.location2.API;

import java.util.Date;

public class PositionBody {
    private Integer id;
    private Date creationTime;

    private String terminalId;
    private String latitude;
    private String longitude;

    public PositionBody(Integer id,Date creationTime,String terminalId,String latitude,String longitude)
    {
        this.creationTime=creationTime;
        this.id=id;
        this.latitude=latitude;
        this.longitude=longitude;
        this.terminalId=terminalId;
    }

    public Date getCreationTime() {
        return creationTime;
    }

    public Integer getId() {
        return id;
    }

    public String getLatitude() {
        return latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public String getTerminalId() {
        return terminalId;
    }
}
