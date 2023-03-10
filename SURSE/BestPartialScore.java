package Tema;

public class BestPartialScore implements  Strategy {

    public Student doOperation(Course c) {
        Grade gr;
        Student stud = null;
        Double maxim= Double.valueOf(0);
        for(int i=0; i<c.g.size(); i++){
            gr=c.g.get(i);
            if(gr.getPartialScore() >= maxim) {
                maxim = gr.getPartialScore();
                stud=gr.getStudent();
            }
        }

        return stud;
    }
}
