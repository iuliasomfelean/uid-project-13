package project.uid13.entities;

import java.io.Serializable;

/**
 * Created by Razvan on 1/16/2018.
 */

public class ChatMessage implements Serializable {

    private String user;
    private String message;


    public ChatMessage()
    {

    }
    public ChatMessage(String user, String message) {
        this.user = user;
        this.message = message;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


    @Override
    public String toString() {
        return "ChatMessage{" +
                "user='" + user + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
