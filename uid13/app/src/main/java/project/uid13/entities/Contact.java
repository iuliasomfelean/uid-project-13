package project.uid13.entities;

import java.io.Serializable;

/**
 * Created by Razvan on 1/17/2018.
 */

public class Contact implements Serializable{

    private String contactName;
    public int imageId;

    public Contact() {
    }

    public Contact(String contactName, int imageId) {
        this.contactName = contactName;
        this.imageId = imageId;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "contactName='" + contactName + '\'' +
                ", imageId=" + imageId +
                '}';
    }
}
