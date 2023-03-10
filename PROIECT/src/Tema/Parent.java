package Tema;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

public class Parent extends User implements Observer {
    List<Notification> notif=new ArrayList<>();
    public Parent(String firstName, String lastName) {
        super(firstName, lastName);
    }

    public List<Notification> getNotif() {
        return notif;
    }

    public void update(Notification notification) {
        notif.add(notification);
    }
}
