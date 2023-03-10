package Tema;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class PartialCourse extends Course{
    String nume;
    Teacher profesor;
    HashSet<Assistant> assistants = new HashSet<Assistant>();
    List<Grade> g = new ArrayList<Grade>();
    HashMap<String, Group> dictionar= new HashMap<String, Group>();
    int nrCredite;
    Context strategy;

    public PartialCourse(CourseBuilder builder){
        super(builder);
    }

    public String promovat(Grade grade){
        if(grade.getTotal() >= 5)
            return "promovat";
        else
            return "nepromovat";
    }

    public static class PartialCourseBuilder extends Course.CourseBuilder{
        private String name;
        private  Teacher profesor;
        private HashSet<Assistant> assistants = new HashSet<Assistant>();
        private List<Grade> g = new ArrayList<Grade>();
        private HashMap<String, Group> dictionar= new HashMap<String, Group>();
        private int nrCredite;
        private Context strategy;
        public PartialCourseBuilder(String name){
            super(name);
        }
        public PartialCourseBuilder teacher(Teacher profesor){
            super.teacher(profesor);
            return this;
        }

        public PartialCourseBuilder assis(HashSet<Assistant> assistants){
            super.assis(assistants);
            return this;
        }

        public PartialCourseBuilder grades(List<Grade> g){
            super.grades(g);
            return this;
        }

        public PartialCourseBuilder dictionar(HashMap<String, Group> dictionar){
            super.dictionar(dictionar);
            return this;
        }

        public PartialCourseBuilder credite(int nrCredite){
            super.credite(nrCredite);
            return this;
        }

        public PartialCourseBuilder strategy(Context strategy){
            super.strategy(strategy);
            return this;
        }

        public PartialCourse build(){
            return new PartialCourse(this);
        }
    }
}
