package project.uid13.service;

import java.util.ArrayList;
import java.util.List;

import project.uid13.Constants;
import project.uid13.R;
import project.uid13.entities.NewsfeedPostModel;

/**
 * Created by Iulia Somfelean on 1/15/2018.
 */

public class NewsfeedService {
    private List<NewsfeedPostModel> newsfeedPostModelList = new ArrayList<>();
    private List<NewsfeedPostModel> commentsList = new ArrayList<>();
    private List<NewsfeedPostModel> searchedUserNewsfeedPostModelList = new ArrayList<>();

    public List<NewsfeedPostModel> getNewsfeedList() {
        NewsfeedPostModel l1 = new NewsfeedPostModel("Daniel Crisan", R.drawable.daniel_crisan, "1 hour ago", "I found a very interesting article about the future of user interfaces. You should definetely check it out: https://webdesign.tutsplus.com/articles/the-future-of-user-interfaces--webdesign-13246");
        newsfeedPostModelList.add(l1);

        NewsfeedPostModel l2 = new NewsfeedPostModel("Alina Sas", R.drawable.secretara_alina_sas, "5 hours ago", "A new version of the schedule has just been uploaded to: https://ac.utcluj.ro/");
        newsfeedPostModelList.add(l2);

        NewsfeedPostModel l3 = new NewsfeedPostModel("Alexandra Ion", R.drawable.alexandra_ion, "6 hour ago", "Can anybody help me with the UID assignment? I have some questions related to the structure of the presentation we have to deliver.");
        newsfeedPostModelList.add(l3);

        NewsfeedPostModel l4 = new NewsfeedPostModel(Constants.USER_3_NAME, R.drawable.raluca, "20:30 16.01.2018", "I am testing the application. SPOILER: It works.");
        newsfeedPostModelList.add(l4);

        /*newsfeedPostModelList.add(l1);
        newsfeedPostModelList.add(l2);  newsfeedPostModelList.add(l1);
        newsfeedPostModelList.add(l2);  newsfeedPostModelList.add(l1);
        newsfeedPostModelList.add(l2);  newsfeedPostModelList.add(l1);
        newsfeedPostModelList.add(l2);  newsfeedPostModelList.add(l1);
        newsfeedPostModelList.add(l2);  newsfeedPostModelList.add(l1);
        newsfeedPostModelList.add(l2);
*/
        return newsfeedPostModelList;
    }

    public List<NewsfeedPostModel> getCommentList() {
        NewsfeedPostModel l1 = new NewsfeedPostModel("Alexandra Ion", R.drawable.alexandra_ion, "2 hours ago", "Very interesting article!");
        commentsList.add(l1);
        NewsfeedPostModel l2 = new NewsfeedPostModel("Anca Popa", R.drawable.ancaa, "1 hour ago", "Great article!");
        commentsList.add(l2);

        return commentsList;
    }


    public List<NewsfeedPostModel> getSearchedUserNewsfeedList() {
        NewsfeedPostModel l1 = new NewsfeedPostModel(Constants.USER_2_NAME, R.drawable.alexandra_ion, "15:34 03.10.2017", "Do not forget to come and sign the study contracts, tommorow, at 10 AM, in P03.");
        NewsfeedPostModel l2 = new NewsfeedPostModel(Constants.USER_2_NAME, R.drawable.alexandra_ion, "16:51 24.10.2017", "Can anybody help me with the UID assignment? I have some questions related to the structure of the presentation we have to deliver.");
        NewsfeedPostModel l3 = new NewsfeedPostModel(Constants.USER_2_NAME, R.drawable.alexandra_ion, "1 day ago", "I found a very interesting article about the future of user interfaces. You should definetely check it out: https://webdesign.tutsplus.com/articles/the-future-of-user-interfaces--webdesign-13246");
        NewsfeedPostModel l4 = new NewsfeedPostModel(Constants.USER_2_NAME, R.drawable.alexandra_ion, "6 hours ago", "Can anybody help me with the UID assignment? I have some questions related to the structure of the presentation we have to deliver.");

        searchedUserNewsfeedPostModelList.add(l4);
        searchedUserNewsfeedPostModelList.add(l3);
        searchedUserNewsfeedPostModelList.add(l2);
        searchedUserNewsfeedPostModelList.add(l1);

        return searchedUserNewsfeedPostModelList;
    }

    public List<NewsfeedPostModel> getNewsfeedPostModelList() {
        return newsfeedPostModelList;
    }

    public void setNewsfeedPostModelList(List<NewsfeedPostModel> newsfeedPostModelList) {
        this.newsfeedPostModelList = newsfeedPostModelList;
    }

    public List<NewsfeedPostModel> getSearchedUserNewsfeedPostModelList() {
        return searchedUserNewsfeedPostModelList;
    }

    public void setSearchedUserNewsfeedPostModelList(List<NewsfeedPostModel> searchedUserNewsfeedPostModelList) {
        this.searchedUserNewsfeedPostModelList = searchedUserNewsfeedPostModelList;
    }

    public List<NewsfeedPostModel> getCommentsList() {
        return commentsList;
    }

    public void setCommentsList(List<NewsfeedPostModel> commentsList) {
        this.commentsList = commentsList;
    }
}
