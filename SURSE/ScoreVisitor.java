package Tema;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ScoreVisitor implements Visitor{

    public void visit(Assistant assistant) {
        List<Course> courses=Catalog.getInstance().getList();
        for(int i=0; i<courses.size(); i++) {
            Assistant[] assis = courses.get(i).getAssistants().toArray(new Assistant[courses.get(i).getAssistants().size()]);
            for (int j = 0; j < courses.get(i).getAssistants().size(); j++) {
                if (assistant == assis[j]) {
                    List<Tuple> tps = partialScore.get(assistant);
                    for (Tuple<Student, String, Double> tp : tps) {
                        Grade gr = courses.get(i).getGrade(tp.student);
                        gr.setPartialScore(tp.getNota());
                        gr.setStudent(tp.student);
                        if(tp.student.getFather() != null)
                            Catalog.getInstance().notifyObservers(gr);
                        if(tp.student.getMother() != null)
                            Catalog.getInstance().notifyObservers(gr);
                    }
                }
            }
        }
    }
    public void visit(Teacher teacher) {
        List<Course> courses=Catalog.getInstance().getList();
        for(int i=0; i<courses.size(); i++)
            if(teacher == courses.get(i).getProfesor()){
                List<Tuple> tps=examScore.get(teacher);
                for(Tuple<Student,String,Double> tp:tps){
                    Grade gr=new Grade();
                    gr.setExamScore(tp.getNota());
                    gr.setStudent(tp.student);
                    gr.setCourse(tp.numeCurs);
                    courses.get(i).addGrade(gr);
                    if(tp.student.getFather() != null)
                        Catalog.getInstance().notifyObservers(gr);
                    if(tp.student.getMother() != null)
                        Catalog.getInstance().notifyObservers(gr);
                }
        }
    }

    static class Tuple<Stud, NumeCurs, Nota>{
        private Stud student;
        private NumeCurs numeCurs;
        private Nota nota;

        public Tuple(Stud stud, NumeCurs nc, Nota n){
            this.student=stud;
            this.numeCurs=nc;
            this.nota=n;
        }

        public Stud getStudent() {
            return student;
        }

        public NumeCurs getNumeCurs() {
            return numeCurs;
        }

        public Nota getNota() {
            return nota;
        }

        public String toString(){
            return "Student: " + student + "Cursul: " + numeCurs + "Nota: " + nota + "\n";
        }
    }
    HashMap<Teacher, List<Tuple>> examScore= new HashMap<Teacher, List<Tuple>>();
    HashMap<Assistant, List<Tuple>> partialScore= new HashMap<Assistant, List<Tuple>>();

    public ScoreVisitor(HashMap<Teacher, List<Tuple>> examScore, HashMap<Assistant, List<Tuple>> partialScore) {
        this.examScore = examScore;
        this.partialScore = partialScore;
    }

}
