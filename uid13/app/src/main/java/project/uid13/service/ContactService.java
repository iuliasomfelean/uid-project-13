package project.uid13.service;

import java.util.ArrayList;
import java.util.List;

import project.uid13.R;
import project.uid13.entities.Contact;
import project.uid13.entities.GroupModel;

import static project.uid13.Constants.USER_3_NAME;

/**
 * Created by Razvan on 1/17/2018.
 */

public class ContactService {
    List<Contact> groups=null;

    public List<Contact> removeGroup(int id)
    {
        groups.remove(id);
        return groups;
    }

    public List<Contact> removeGroupModel(Contact offerModel)
    {
        groups.remove(offerModel);

        return groups;
    }

    public List<Contact> addModel(Contact offerModel)
    {
        groups.add(offerModel);
        return groups;
    }


    public List<Contact> getEmptyGroups() {

        groups = new ArrayList<Contact>();

        return groups;
    }

    public List<Contact> getGroupInfo() {

        groups = new ArrayList<Contact>();


        groups.add(new Contact("Daniel Crisan", R.drawable.pawn));
        groups.add(new Contact("Alexandra Ion", R.drawable.pawn));
        groups.add(new Contact(USER_3_NAME, R.drawable.pawn));

        return groups;
    }
}
