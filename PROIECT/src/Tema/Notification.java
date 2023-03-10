package Tema;

public class Notification {
    Grade grade;

    public Notification(Grade grade) {
        this.grade = grade;
    }

    public String toString(){
        if(grade.getPartialScore() ==null) {
            return "Elevul " + grade.getStudent() + " a obtinut la cursul " + grade.getCourse() + " a obtinut la examen " + grade.getExamScore() + "\n";
        }
        else
            return "Elevul " + grade.getStudent()+" a obtinut la cursul "+grade.getCourse() +" a obtinut la partial " + grade.getPartialScore()+"\n" ;

    }
}
