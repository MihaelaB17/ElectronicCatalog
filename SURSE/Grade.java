package Tema;

public class Grade implements Comparable<Grade>, Cloneable {
    private Double partialScore, examScore;
    private Student student;
    private String course;

    public Double getPartialScore() {
        return partialScore;
    }
    public Double getExamScore() {
        return examScore;
    }

    public Student getStudent() {
        return student;
    }

    public String getCourse() {
        return course;
    }

    public void setPartialScore(Double partialScore) {
        this.partialScore = partialScore;
    }

    public void setExamScore(Double examScore) {
        this.examScore = examScore;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public Double getTotal(){
        return partialScore+examScore;
    }

    public int compareTo(Grade g) {
        return this.getTotal().compareTo(g.getTotal());
    }

    public String toString(){
        return "Curs: " + course + "Student:" + student + ", Nota partial: " + partialScore + ", Nota examen:" + examScore + "\n";
    }
}
