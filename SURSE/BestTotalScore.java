package Tema;

public class BestTotalScore implements Strategy{
    public Student doOperation(Course c) {
        Grade gr;
        Student stud=null;
        Double maxim= Double.valueOf(0);
        for(int i=0; i<c.g.size(); i++){
            gr=c.g.get(i);
            if(gr.getTotal() >= maxim) {
                maxim = gr.getTotal();
                stud=gr.getStudent();
            }
        }

        return stud;
    }
}
