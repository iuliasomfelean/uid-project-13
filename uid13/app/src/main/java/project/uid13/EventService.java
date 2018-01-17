package project.uid13;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cosmi on 1/16/2018.
 */

public class EventService {

    List<EventModel> events;
    List<EventModel> joinedEvents;

    private static EventService instance = new EventService();

    private EventService(){
        events = new ArrayList<EventModel>();
        events.add(new EventModel("Consiliere in cariera", "Vina sa primesti sfaturi legate de cariera ta!", EventPrivacy.PUBLIC, R.drawable.event1));
        events.add(new EventModel("BattleLab Robotica", "Esti pregatit? Dovedeste ca esti cel mai bun!", EventPrivacy.PUBLIC, R.drawable.event4));
        events.add(new EventModel("Prezentare AROBS", "Vino si tu daca esti interesat de tehnologii embedded si daca" +
                " iti place sa programezi in C. Dan Iancu, project manager la AROBS va sustine o prezentare despre tehnologii embedded. " +
                "Nu rata ocazia!", EventPrivacy.PUBLIC, R.drawable.arobs));

    }

    public static EventService getInstance(){
        return instance;
    }

    public List<EventModel> getEvents(){
        return events;
    }

    public List<EventModel> addEvent(String title, String description, EventPrivacy privacy){
        EventModel event = new EventModel(title, description, privacy, R.drawable.utcn_event);
        events.add(event);

        return events;
    }

    public List<EventModel> removeEvent(int i){
        events.remove(i);

        return events;
    }

    public List<EventModel> setJoin(int i, boolean join){
        events.get(i).setJoin(join);

        return events;
    }
}
