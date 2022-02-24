package Loggbok;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Date;

public class LoggEntry  implements Serializable {
    private Date createdAt;
    private Date updatedAt;
    private String name;
    private String message;
    private ArrayList<LoggEntry> updateHistory = new ArrayList<>();

    public LoggEntry(String name, String message) {
        this.createdAt = new Date();
        this.updatedAt = new Date();
        this.name = name;
        this.message = message;
        /*ArrayList<Date> dateHistory = new ArrayList<>();
        dateHistory.add(new Date());
        ArrayList<String> messageHistory = new ArrayList<>();
        messageHistory.add(message);
        this.updateHistory.add(dateHistory);
        this.updateHistory.add(messageHistory);*/
        //updateHistory.add(logg);
    }

    public LoggEntry(LoggEntry logg) {
        this.createdAt = logg.createdAt;
        this.updatedAt = logg.updatedAt;
        this.name = logg.name;
        this.message = logg.message;
    }

    public void editMessage(String newMessage, LoggEntry logg) {
        updateHistory.add(logg);
        this.message = newMessage;
        this.updatedAt = new Date();
    }

    public String getUpdateHistory() {
        String result = "";
        for (int i = 0; i < this.updateHistory.size(); i++) {
            result += "Date: " + this.updateHistory.get(i).updatedAt +
                      " Message: " + this.updateHistory.get(i).message + "\n";
            /*System.out.println("Date: " + this.updateHistory.get(i).updatedAt +
                    " Message: " + this.updateHistory.get(i).message);*/
        }

        return result;
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
