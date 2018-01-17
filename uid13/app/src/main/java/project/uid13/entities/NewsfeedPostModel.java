package project.uid13.entities;

/**
 * Created by Iulia Somfelean on 1/14/2018.
 */

public class NewsfeedPostModel {
    private String userName;
    private int userPictureName;
    private String dateTimeOfPost;
    private String contentOfPost;

    public NewsfeedPostModel(String userName, int userPictureName, String dateTimeOfPost, String contentOfPost) {
        this.userName = userName;
        this.userPictureName = userPictureName;
        this.dateTimeOfPost = dateTimeOfPost;
        this.contentOfPost = contentOfPost;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getUserPictureName() {
        return userPictureName;
    }

    public void setUserPictureName(int userPictureName) {
        this.userPictureName = userPictureName;
    }

    public String getDateTimeOfPost() {
        return dateTimeOfPost;
    }

    public void setDateTimeOfPost(String dateTimeOfPost) {
        this.dateTimeOfPost = dateTimeOfPost;
    }

    public String getContentOfPost() {
        return contentOfPost;
    }

    public void setContentOfPost(String contentOfPost) {
        this.contentOfPost = contentOfPost;
    }
}
