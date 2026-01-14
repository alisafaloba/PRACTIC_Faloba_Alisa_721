package org.example.Modell;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TrafficEvent {
    private int id;
    private int vehicleId;
    @JsonProperty("type")
    private EventType eventType;
    private int severity;
    private int timeSlot;
    public TrafficEvent(){}
    public TrafficEvent(int id, int vehicleId, EventType eventType, int severity, int timeSlot) {
        this.id = id;
        this.vehicleId = vehicleId;
        this.eventType = eventType;
        this.severity = severity;
        this.timeSlot = timeSlot;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(int vehicleId) {
        this.vehicleId = vehicleId;
    }

    public EventType getEventType() {
        return eventType;
    }

    public void setEventType(EventType eventType) {
        this.eventType = eventType;
    }

    public int getSeverity() {
        return severity;
    }

    public void setSeverity(int severity) {
        this.severity = severity;
    }

    public int getTimeSlot() {
        return timeSlot;
    }

    public void setTimeSlot(int timeSlot) {
        this.timeSlot = timeSlot;
    }
}
