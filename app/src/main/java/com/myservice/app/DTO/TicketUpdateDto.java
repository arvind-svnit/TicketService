package com.myservice.app.DTO;

import com.myservice.app.enums.Severity;
import com.myservice.app.enums.Status;

public class TicketUpdateDto {
    private Severity severity;
    private String response;
    private Status status;

    public String getFeedBack() {
        return feedBack;
    }

    public void setFeedBack(String feedBack) {
        this.feedBack = feedBack;
    }

    private String feedBack;

    public Severity getSeverity() {
        return severity;
    }

    public void setSeverity(Severity severity) {
        this.severity = severity;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
