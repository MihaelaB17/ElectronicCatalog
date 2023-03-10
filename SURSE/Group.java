package Tema;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;

public class Group extends ArrayList<Student> {
    ArrayList<Student> students=new ArrayList<Student>();
    Assistant assistant;
    String ID;

    public String toString(){
        return " Asistent: " + assistant+", Studenti: "+students.toString()+"\n";
    }

    public void setAssistant(Assistant assistant) {
        this.assistant = assistant;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public Group(String ID, Assistant assistant, Comparator<Student> comp) {
       this.ID=ID;
       this.assistant=assistant;

    }
    public Group(String ID, Assistant assistant) {
        this.ID=ID;
        this.assistant=assistant;
    }
}
