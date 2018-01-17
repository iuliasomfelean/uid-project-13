package project.uid13.service;

import java.util.ArrayList;
import java.util.List;

import project.uid13.R;
import project.uid13.entities.GroupModel;

/**
 * Created by Razvan on 1/8/2018.
 */

public class GroupService {

    List<GroupModel> groups=null;

    public List<GroupModel> removeGroup(int id)
    {
        groups.remove(id);
        return groups;
    }

    public List<GroupModel> removeGroupModel(GroupModel offerModel)
    {
        groups.remove(offerModel);

        return groups;
    }

    public List<GroupModel> addModel(GroupModel offerModel)
    {
        groups.add(offerModel);
        return groups;
    }


    public List<GroupModel> getEmptyGroups() {

        groups = new ArrayList<GroupModel>();

        return groups;
    }

    public List<GroupModel> getGroupInfo() {

        groups = new ArrayList<GroupModel>();


        groups.add(new GroupModel("UID-2017","Steve","Very important stuff is going on here", R.drawable.group2));
        groups.add(new GroupModel("DS-2017","Stevie","Not that important stuff is going on here", R.drawable.group1));


        return groups;
    }


}
