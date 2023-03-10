package Tema;

import java.util.*;
import java.util.function.BiConsumer;

public abstract class Course {
    String nume;
    Teacher profesor;
    HashSet<Assistant> assistants = new HashSet<Assistant>();
    List<Grade> g = new ArrayList<>();
    HashMap<String, Group> dictionar= new HashMap<String, Group>();
    Context strategy;
    int nrCredite;

    public Course(String nume){
        this.nume=nume;
    }

    public String toString(){
        return "Nume curs: " + nume + ", Profesor: " + profesor + ", Asistenti: " + assistants.toString()+", Grupa:" + dictionar.toString()+ "\n";
        //return g.toString();
    }

    public abstract String promovat(Grade g);
    public Course(CourseBuilder buider ) {
        this.nume = buider.name;
        this.profesor = buider.profesor;
        this.assistants = buider.assistants;
        this.g = buider.g;
        this.dictionar = buider.dictionar;
        this.nrCredite = buider.nrCredite;
        this.strategy=buider.strategy;
    }

    public String getNume() {
        return nume;
    }

    public Teacher getProfesor() {
        return profesor;
    }

    public Context getStrategy() {
        return strategy;
    }

    public HashSet<Assistant> getAssistants() {
        return assistants;
    }

    public List<Grade> getG() {
        return g;
    }

    public HashMap<String, Group> getDictionar() {
        return dictionar;
    }

    public int getNrCredite() {
        return nrCredite;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public void setProfesor(Teacher profesor) {
        this.profesor = profesor;
    }

    public void setAssistants(HashSet<Assistant> assistants) {
        this.assistants = assistants;
    }

    public void setG(List<Grade> g) {
        this.g = g;
    }

    public void setDictionar(HashMap<String, Group> dictionar) {
        this.dictionar = dictionar;
    }

    public void setNrCredite(int nrCredite) {
        this.nrCredite = nrCredite;
    }

    public void addAssistant(String ID, Assistant assistant){
        Group grupa;
        grupa=dictionar.get(ID);
        grupa.assistant=assistant;
        assistants.add(assistant);
    }
    public void addStudent(String ID, Student student){
        Group grupa;
        grupa=dictionar.get(ID);
        grupa.students.add(student);
    }
    public void addGroup(Group group){
        String ID=group.ID;
        dictionar.put(ID,group);
    }
    public void addGroup(String ID, Assistant assistant){
        Group grupa= new Group(ID, assistant);
        dictionar.put(ID, grupa);
    }

    public void addGroup(String ID, Assistant assist, Comparator<Student> comp){
        Group grupa=new Group(ID, assist);
        dictionar.put(ID, grupa);
    }

    public Grade getGrade(Student student){
        for(Grade nota: g) {
            if(nota.getStudent() == student)
                return nota;
        }
        return null;
    }

    public void addGrade(Grade grade){
        g.add(grade);
    }

    public ArrayList<Student> getAllStudents(){
        ArrayList<Student> studs=new ArrayList<>();
        for (Group grupa: dictionar.values())
            for(int i=0; i<grupa.students.size(); i++)
                studs.add(grupa.students.get(i));

         return studs;
    }

    public HashMap<Student, Grade> gettAllStudentGrades(){
        HashMap<Student, Grade> note=new HashMap<>();
        for (Group grupa: dictionar.values())
            for(int i=0; i<grupa.students.size(); i++){
                note.put(grupa.students.get(i), getGrade(grupa.students.get(i)));
            }
        return  note;
    }

    //public abstract ArrayList<Student> getGraduatedStudents(){

    //}

    public  Student getBestStudent(){
        return strategy.executeStrategy(this);
    }

    public static abstract class CourseBuilder{
        private String name;
        private  Teacher profesor;
        private HashSet<Assistant> assistants = new HashSet<Assistant>();
        private List<Grade> g = new ArrayList<Grade>();
        private HashMap<String, Group> dictionar= new HashMap<String, Group>();
        private int nrCredite;
        private Context strategy;

        public CourseBuilder(String name, Teacher profesor, HashSet<Assistant> assistants, List<Grade> g, HashMap<String, Group> dictionar, int nrCredite, Context strategy) {
            this.name = name;
            this.profesor = profesor;
            this.assistants = assistants;
            this.g = g;
            this.dictionar = dictionar;
            this.nrCredite = nrCredite;
            this.strategy=strategy;
        }

        public CourseBuilder(String name){
            this.name=name;
        }

        public CourseBuilder teacher(Teacher profesor){
            this.profesor=profesor;
            return this;
        }

        public CourseBuilder assis(HashSet<Assistant> assistants){
            this.assistants=assistants;
            return this;
        }

        public CourseBuilder grades(List<Grade> g){
            this.g=g;
            return this;
        }

        public CourseBuilder dictionar(HashMap<String, Group> dictionar){
            this.dictionar=dictionar;
            return this;
        }

        public CourseBuilder credite(int nrCredite){
            this.nrCredite=nrCredite;
            return this;
        }

        public CourseBuilder strategy(Context strategy){
            this.strategy=strategy;
            return this;
        }

        public abstract Course build();
    }
}

