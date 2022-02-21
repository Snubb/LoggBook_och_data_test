package Loggbok;

import java.io.Serializable;
import java.util.Date;

public class LoggEntry  implements Serializable {
    private Date createdAt;
    private Date updatedAt;
    private String name;
    private String message;

    public LoggEntry(String name, String message) {
        this.createdAt = new Date();
        this.updatedAt = new Date();
        this.name = name;
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public String getName() {
        return this.name;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    @Override
    public String toString() {
        return "LoggEntry{" +
                "createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", name='" + name + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
