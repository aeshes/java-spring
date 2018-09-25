package app.data.model;

import java.util.Date;
import java.util.Objects;

public class Message {
    private final Long id;
    private final String message;
    private final Date time;
    private Double latitude;
    private Double longitude;

    public Message(String message, Date time) {
        this(message, time, null, null);
    }

    public Message(String message, Date time, Double latitude, Double longitude) {
        this.id = null;
        this.message = message;
        this.time = time;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public Long getId() {
        return id;
    }

    public String getMessage() {
        return message;
    }

    public Date getTime() {
        return time;
    }

    public Double getLatitude() {
        return latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Message message1 = (Message) o;
        return Objects.equals(id, message1.id) &&
                Objects.equals(message, message1.message) &&
                Objects.equals(time, message1.time) &&
                Objects.equals(latitude, message1.latitude) &&
                Objects.equals(longitude, message1.longitude);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, message, time, latitude, longitude);
    }
}
