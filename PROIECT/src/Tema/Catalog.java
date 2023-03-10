package Tema;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Catalog implements Subject {
    private static Catalog obj=null;
    private ArrayList<Course> list= new ArrayList<Course>();
    private List<Observer> obs=new ArrayList<>();
    private  Catalog(){
    }

    public ArrayList<Course> getList() {
        return list;
    }

    public static Catalog getInstance(){
        if(obj == null)
            obj= new Catalog();
        return obj;
    }

    public String toString(){
        return list.toString();
    }

    public List<Observer> getObs() {
        return obs;
    }

    public void addCourse(Course course){
        list.add(course);
    }

    public void removeCourse(Course course){
        list.remove(course);
    }

    public void addObserver(Observer observer) {
        obs.add(observer);
    }

    public void removeObserver(Observer observer) {
        obs.remove(observer);
    }

    public void notifyObservers(Grade grade) {
        Notification notif=new Notification(grade);
        for(int i=0; i<obs.size(); i++){
            if(grade.getStudent().getMother() != null)
                if(grade.getStudent().getMother().equals(obs.get(i)))
                    obs.get(i).update(notif);
            if(grade.getStudent().getFather() != null)
                if(grade.getStudent().getFather().equals(obs.get(i)) )
                    obs.get(i).update(notif);
        }
    }
}
