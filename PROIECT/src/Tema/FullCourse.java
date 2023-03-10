package Tema;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class FullCourse extends Course {
    String nume;
    Teacher profesor;
    HashSet<Assistant> assistants = new HashSet<Assistant>();
    List<Grade> g = new ArrayList<Grade>();
    HashMap<String, Group> dictionar= new HashMap<String, Group>();
    int nrCredite;
    Context strategy;
    public FullCourse(CourseBuilder builder){
        super(builder);
    }

    public String promovat(Grade grade){
        if(grade.getPartialScore() >=3 && grade.getExamScore() >=2)
            return "promovat";
        else
            return "nepromovat";
    }

    public static class FullCourseBuilder extends Course.CourseBuilder{
        private String name;
        private  Teacher profesor;
        private HashSet<Assistant> assistants = new HashSet<Assistant>();
        private List<Grade> g = new ArrayList<Grade>();
        private HashMap<String, Group> dictionar= new HashMap<String, Group>();
        private int nrCredite;
        private Context strategy;

        public FullCourseBuilder(String name){
            super(name);
        }

        public FullCourseBuilder teacher(Teacher profesor){
            super.teacher(profesor);
            return this;
        }

        public FullCourseBuilder assis(HashSet<Assistant> assistants){
            super.assis(assistants);
            return this;
        }

        public FullCourseBuilder grades(List<Grade> g){
            super.grades(g);
            return this;
        }

        public FullCourseBuilder dictionar(HashMap<String, Group> dictionar){
            super.dictionar(dictionar);
            return this;
        }

        public FullCourseBuilder credite(int nrCredite){
            super.credite(nrCredite);
            return this;
        }
        public FullCourseBuilder strategy(Context strategy){
            super.strategy(strategy);
            return this;
        }

        public FullCourse build(){
            return new FullCourse(this);
        }

    }
}
