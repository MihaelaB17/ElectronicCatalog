package Tema;

import java.lang.reflect.Field;

public class BestExamScore implements  Strategy {

    public Student doOperation(Course c) {
        Grade gr;
        Student stud=null;
        Double maxim= Double.valueOf(0);
        for(int i=0; i<c.g.size(); i++){
            gr=c.g.get(i);
            if(gr.getExamScore() >= maxim) {
                maxim = gr.getExamScore();
                stud=gr.getStudent();
            }
        }

        return stud;
    }
}
