package com.alysonn.crudapi.model;

import java.util.Date;

public class Status {
    private final Integer statusId;
    private final String name;
    private final Date creationDate;
    private final Date updateDate;

    public Status(Integer statusId, String name, Date creationDate, Date updateDate) {
        this.statusId = statusId;
        this.name = name;
        this.updateDate = updateDate;
        this.creationDate = creationDate;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public String getName() {
        return name;
    }

    public Integer getStatusId() {
        return statusId;
    }

    public Date getUpdateDate() {
        return updateDate;
    }
}