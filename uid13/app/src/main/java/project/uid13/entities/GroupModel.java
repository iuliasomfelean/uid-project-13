package project.uid13.entities;

import java.io.Serializable;

/**
 * Created by Razvan on 1/8/2018.
 */

public class GroupModel implements Serializable {

     public String title;
     public String user;
     public String textContent;
     public int imageId;


    public GroupModel(String title, String user, String textContent,int imageId) {
        this.title = title;
        this.user = user;
        this.textContent = textContent;
        this.imageId = imageId;
    }

    public GroupModel() {

    }

    @Override
    public String toString() {
        return "GroupModel{" +
                "title='" + title + '\'' +
                ", user='" + user + '\'' +
                ", textContent='" + textContent + '\'' +
                ", imageId=" + imageId +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GroupModel that = (GroupModel) o;

        if (imageId != that.imageId) return false;
        if (!title.equals(that.title)) return false;
        if (!user.equals(that.user)) return false;
        return textContent.equals(that.textContent);
    }

    @Override
    public int hashCode() {
        int result = title.hashCode();
        result = 31 * result + user.hashCode();
        result = 31 * result + textContent.hashCode();
        result = 31 * result + imageId;
        return result;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getTextContent() {
        return textContent;
    }

    public void setTextContent(String textContent) {
        this.textContent = textContent;
    }
}
