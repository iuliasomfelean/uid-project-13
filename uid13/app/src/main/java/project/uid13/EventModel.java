package project.uid13;

/**
 * Created by cosmi on 1/16/2018.
 */

public class EventModel {

    String eventTitle;
    String eventDescription;
    EventPrivacy eventPrivacy;
    int eventImage;
    boolean join;

    public EventModel(String eventTitle, String eventDescription, EventPrivacy eventPrivacy, int eventImage){
        this.eventTitle = eventTitle;
        this.eventDescription = eventDescription;
        this.eventPrivacy = eventPrivacy;
        this.eventImage = eventImage;
    }

    public String getEventTitle() {
        return eventTitle;
    }

    public void setEventTitle(String eventTitle) {
        this.eventTitle = eventTitle;
    }

    public String getEventDescription() {
        return eventDescription;
    }

    public void setEventDescription(String eventDescription) {
        this.eventDescription = eventDescription;
    }

    public EventPrivacy getEventPrivacy() {
        return eventPrivacy;
    }

    public void setEventPrivacy(EventPrivacy eventPrivacy) {
        this.eventPrivacy = eventPrivacy;
    }

    public int getEventImage() {
        return eventImage;
    }

    public void setEventImage(int eventImage) {
        this.eventImage = eventImage;
    }

    public boolean isJoin() {
        return join;
    }

    public void setJoin(boolean join) {
        this.join = join;
    }
}
