package com.alysonn.crudapi.model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Task {
    private final UUID taskId;
    private final String name;
    private final String description;
    // private final Status status;
    private final Date finishDate;
    private Date creationDate;

    public Task(@JsonProperty("taskId") UUID taskId, @JsonProperty("name") String name,
            @JsonProperty("description") String description,
            // @JsonProperty("status") Status status,
            @JsonProperty("finishDate") @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss") Date finishDate,
            @JsonProperty("creationDate") @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss") Date creationDate) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm'Z'");
        TimeZone currentTimezone = TimeZone.getTimeZone("America/Sao_Paulo");
        dateFormat.setTimeZone(currentTimezone);
        this.taskId = taskId;
        this.name = name;
        this.description = description;
        // this.status = status;
        this.finishDate = finishDate;
        try {
            if(creationDate != null) {
                this.creationDate = creationDate;
            } else {
                String IsoDate = dateFormat.format(new Date());
                this.creationDate = dateFormat.parse(IsoDate);
            }
        } catch (Exception e) {
            this.creationDate = null;
            e.printStackTrace();
        }
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public String getDescription() {
        return description;
    }

    public Date getFinishDate() {
        return finishDate;
    }

    public String getName() {
        return name;
    }

    // public Status getStatus() {
    // return status;
    // }

    public UUID getTaskId() {
        return taskId;
    }

}