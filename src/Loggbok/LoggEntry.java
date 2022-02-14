package Loggbok;

import java.util.Date;

public class LoggEntry {
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
}
