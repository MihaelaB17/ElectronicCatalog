package Tema;

import java.util.*;

public class Test {
    //Catalog catalog;
    static HashMap<Assistant, List<ScoreVisitor.Tuple>> partialScore= new HashMap<Assistant, List<ScoreVisitor.Tuple>>();
    static HashMap<Teacher, List<ScoreVisitor.Tuple>> examScore= new HashMap<Teacher, List<ScoreVisitor.Tuple>>();
    public static void main(String args[]) throws Exception{

        int nrc1=1, nrc2=1, nrc3=1, nrc4=1;

        Catalog catalog=Catalog.getInstance();

        HashMap<String, Group> dictionar1= new HashMap<String, Group>();
        HashSet<Assistant> assistants1 = new HashSet<Assistant>();
        List<Grade> grades1 = new ArrayList<Grade>();
        Context strategy1=new  Context(new BestExamScore());
        List<Observer> obs=new ArrayList<>();

        User t1=UserFactory.getUser("Teacher","Ion", "Mihalache");

        User a1= UserFactory.getUser("Assistant","Alexandra", "Maria");
        User a2= UserFactory.getUser("Assistant","Andrei", "Georgescu");

        FullCourse curs1=new FullCourse.FullCourseBuilder("Programare orientata pe obiecte").teacher((Teacher) t1).assis(assistants1).grades(grades1).dictionar(dictionar1).credite(nrc1).strategy(strategy1).build();

        Group grupa1= new Group("312CC",(Assistant)a2);
        Group grupa2= new Group("314CC",(Assistant)a1);

        curs1.addGroup(grupa1);
        curs1.addGroup(grupa2);
        curs1.addAssistant("312CC", (Assistant) a2);
        curs1.addAssistant("314CC", (Assistant) a1);

        User stud1= UserFactory.getUser("Student","Gigel", "Frone");
        User stud2= UserFactory.getUser("Student","Cosmin", "Andrei");
        User stud3= UserFactory.getUser("Student","Ionel", "Dragomir");
        User stud4= UserFactory.getUser("Student","Florin", "Florea");
        User stud5= UserFactory.getUser("Student","Costel", "Busuioc");

        User p1= UserFactory.getUser("Parent","Maria", "Frone");
        User p2= UserFactory.getUser("Parent","Daniel", "Frone");
        User p3= UserFactory.getUser("Parent","Vasile", "Andrei");
        User p4= UserFactory.getUser("Parent","Letitia", "Dragomir");
        User p5= UserFactory.getUser("Parent","Ariana", "Florea");
        User p6= UserFactory.getUser("Parent","Catalin", "Florea");
        User p7= UserFactory.getUser("Parent","Carmen", "Busuioc");
        User p8= UserFactory.getUser("Parent","Nelu", "Busuioc");

        ((Student)stud1).setMother((Parent) p1);
        ((Student)stud1).setFather((Parent) p2);
        ((Student)stud2).setFather((Parent) p3);
        ((Student)stud3).setMother((Parent) p4);
        ((Student)stud4).setMother((Parent) p5);
        ((Student)stud4).setFather((Parent) p6);
        ((Student)stud5).setMother((Parent) p7);
        ((Student)stud5).setFather((Parent) p8);
        catalog.addObserver((Observer) p1);
        catalog.addObserver((Observer) p2);
        catalog.addObserver((Observer) p3);
        catalog.addObserver((Observer) p4);
        catalog.addObserver((Observer) p5);
        catalog.addObserver((Observer) p6);
        catalog.addObserver((Observer) p7);
        catalog.addObserver((Observer) p8);

        curs1.addStudent("312CC", (Student) stud1);
        curs1.addStudent("312CC", (Student) stud2);
        curs1.addStudent("312CC", (Student) stud3);
        curs1.addStudent("312CC", (Student) stud4);
        curs1.addStudent("312CC", (Student) stud5);

        User stud6= UserFactory.getUser("Student","Sebastian", "Moisescu");
        User stud7= UserFactory.getUser("Student","Larisa", "Oana");
        User stud8= UserFactory.getUser("Student","Georgiana", "Calin");
        User stud9= UserFactory.getUser("Student","Dragos", "Barbu");
        User stud10= UserFactory.getUser("Student","Alberto", "Ciobanu");

        User p9= UserFactory.getUser("Parent","Viorela", "Moisescu");
        User p10= UserFactory.getUser("Parent","Ionut", "Moisescu");
        User p11= UserFactory.getUser("Parent","Alecu", "Oana");
        User p12= UserFactory.getUser("Parent","Lidia", "Calin");
        User p13= UserFactory.getUser("Parent","Anastasia", "Barbu");
        User p14= UserFactory.getUser("Parent","Lucian", "Barbu");
        User p15= UserFactory.getUser("Parent","Mihaela", "Ciobanu");
        User p16= UserFactory.getUser("Parent","Emil", "Ciobanu");

        ((Student)stud6).setMother((Parent) p9);
        ((Student)stud6).setFather((Parent) p10);
        ((Student)stud7).setFather((Parent) p11);
        ((Student)stud8).setMother((Parent) p12);
        ((Student)stud9).setMother((Parent) p13);
        ((Student)stud9).setFather((Parent) p14);
        ((Student)stud10).setMother((Parent) p15);
        ((Student)stud10).setFather((Parent) p16);
        catalog.addObserver((Observer) p9);
        catalog.addObserver((Observer) p10);
        catalog.addObserver((Observer) p11);
        catalog.addObserver((Observer) p12);
        catalog.addObserver((Observer) p13);
        catalog.addObserver((Observer) p14);
        catalog.addObserver((Observer) p15);
        catalog.addObserver((Observer) p16);

        curs1.addStudent("314CC", (Student) stud6);
        curs1.addStudent("314CC", (Student) stud7);
        curs1.addStudent("314CC", (Student) stud8);
        curs1.addStudent("314CC", (Student) stud9);
        curs1.addStudent("314CC", (Student) stud10);

        catalog.addCourse(curs1);

        HashMap<String, Group> dictionar2= new HashMap<String, Group>();
        HashSet<Assistant> assistants2 = new HashSet<Assistant>();
        List<Grade> grades2 = new ArrayList<Grade>();

        User t2=UserFactory.getUser("Teacher","Sonia", "Lupu");

        User a3= UserFactory.getUser("Assistant","Florentina", "Bratosin");
        User a4= UserFactory.getUser("Assistant","Horia", "Ghita");
        Context strategy2=new  Context(new BestExamScore());

        FullCourse curs2=new FullCourse.FullCourseBuilder("Paradigme de programare").teacher((Teacher) t2).assis(assistants2).grades(grades2).dictionar(dictionar2).credite(nrc2).strategy(strategy2).build();

        grupa1= new Group("312CC",(Assistant)a3);
        grupa2=new Group("314CC", (Assistant) a4);
        curs2.addGroup(grupa1);
        curs2.addGroup(grupa2);
        curs2.addAssistant("312CC", (Assistant) a3);
        curs2.addAssistant("314CC", (Assistant) a4);

        curs2.addStudent("312CC", (Student) stud1);
        curs2.addStudent("312CC", (Student) stud2);
        curs2.addStudent("312CC", (Student) stud3);
        curs2.addStudent("312CC", (Student) stud4);
        curs2.addStudent("312CC", (Student) stud5);

        curs2.addStudent("314CC", (Student) stud6);
        curs2.addStudent("314CC", (Student) stud7);
        curs2.addStudent("314CC", (Student) stud8);
        curs2.addStudent("314CC", (Student) stud9);
        curs2.addStudent("314CC", (Student) stud10);

        catalog.addCourse(curs2);

        HashMap<String, Group> dictionar3= new HashMap<String, Group>();
        HashSet<Assistant> assistants3 = new HashSet<Assistant>();
        List<Grade> grades3 = new ArrayList<Grade>();

        User t3=UserFactory.getUser("Teacher","George", "Dinu");

        User a5= UserFactory.getUser("Assistant","Emilian", "Voinea");
        User a6= UserFactory.getUser("Assistant","Andrian", "Sava");
        Context strategy3=new  Context(new BestTotalScore());

        PartialCourse curs3=new PartialCourse.PartialCourseBuilder("Electronica digitala").teacher((Teacher) t3).assis(assistants3).grades(grades3).dictionar(dictionar3).credite(nrc3).strategy(strategy3).build();

        Group grupa3= new Group("311CC",(Assistant)a6);
        Group grupa4= new Group("313CC",(Assistant)a5);

        curs3.addGroup(grupa3);
        curs3.addGroup(grupa4);
        curs3.addAssistant("311CC", (Assistant) a6);
        curs3.addAssistant("313CC", (Assistant) a5);

        User stud11= UserFactory.getUser("Student","Livia", "Ursu");
        User stud12= UserFactory.getUser("Student","Alfred", "Pop");
        User stud13= UserFactory.getUser("Student","Iulian", "Iancu");
        User stud14= UserFactory.getUser("Student","Sofia", "Negoita");
        User stud15= UserFactory.getUser("Student","Alma", "Dobrica");

        User p17= UserFactory.getUser("Parent","Albert", "Pop");
        User p18= UserFactory.getUser("Parent","Elena", "Iancu");
        User p19= UserFactory.getUser("Parent","Ana", "Negoita");
        User p20= UserFactory.getUser("Parent","Marius", "Negoita");
        User p21= UserFactory.getUser("Parent","Corina", "Dobrica");
        User p22= UserFactory.getUser("Parent","Cristi", "Dobrica");

        ((Student)stud12).setFather((Parent) p17);
        ((Student)stud13).setMother((Parent) p18);
        ((Student)stud14).setMother((Parent) p19);
        ((Student)stud14).setFather((Parent) p20);
        ((Student)stud15).setMother((Parent) p21);
        ((Student)stud15).setFather((Parent) p22);
        catalog.addObserver((Observer) p17);
        catalog.addObserver((Observer) p18);
        catalog.addObserver((Observer) p19);
        catalog.addObserver((Observer) p20);
        catalog.addObserver((Observer) p21);
        catalog.addObserver((Observer) p22);

        curs3.addStudent("311CC", (Student) stud11);
        curs3.addStudent("311CC", (Student) stud12);
        curs3.addStudent("311CC", (Student) stud13);
        curs3.addStudent("311CC", (Student) stud14);
        curs3.addStudent("311CC", (Student) stud15);

        User stud16= UserFactory.getUser("Student","Cristian", "Manole");
        User stud17= UserFactory.getUser("Student","Denisa", "Pavel");
        User stud18= UserFactory.getUser("Student","Alex", "Petrescu");
        User stud19= UserFactory.getUser("Student","Cosmin", "Tomulescu");
        User stud20= UserFactory.getUser("Student","Camelia", "Tunaru");

        User p23= UserFactory.getUser("Parent","Victoria", "Manole");
        User p24= UserFactory.getUser("Parent","Andrei", "Manole");
        User p25= UserFactory.getUser("Parent","Bogdan", "Pavel");
        User p26= UserFactory.getUser("Parent","Monica", "Petrecu");
        User p27= UserFactory.getUser("Parent","Petra", "Tunaru");
        User p28= UserFactory.getUser("Parent","Cristian", "Tunaru");

        ((Student)stud16).setMother((Parent) p23);
        ((Student)stud16).setFather((Parent) p24);
        ((Student)stud17).setFather((Parent) p25);
        ((Student)stud18).setMother((Parent) p26);
        ((Student)stud20).setMother((Parent) p27);
        ((Student)stud20).setFather((Parent) p28);
        catalog.addObserver((Observer) p23);
        catalog.addObserver((Observer) p24);
        catalog.addObserver((Observer) p25);
        catalog.addObserver((Observer) p26);
        catalog.addObserver((Observer) p27);
        catalog.addObserver((Observer) p28);

        curs3.addStudent("313CC", (Student) stud16);
        curs3.addStudent("313CC", (Student) stud17);
        curs3.addStudent("313CC", (Student) stud18);
        curs3.addStudent("313CC", (Student) stud19);
        curs3.addStudent("313CC", (Student) stud20);

        catalog.addCourse(curs3);

        HashMap<String, Group> dictionar4= new HashMap<String, Group>();
        HashSet<Assistant> assistants4 = new HashSet<Assistant>();
        List<Grade> grades4 = new ArrayList<Grade>();

        User t4=UserFactory.getUser("Teacher","Razvan", "Calinescu");

        User a7= UserFactory.getUser("Assistant","Alma", "Toma");
        User a8= UserFactory.getUser("Assistant","Cornel", "Cosma");
        Context strategy4=new  Context(new BestPartialScore());

        FullCourse curs4=new FullCourse.FullCourseBuilder("Sisteme de operare").teacher((Teacher) t4).assis(assistants4).grades(grades4).dictionar(dictionar4).credite(nrc4).strategy(strategy4).build();

        grupa3=new Group("311CC", (Assistant) a7);
        grupa4=new Group("313CC", (Assistant) a8);
        curs4.addGroup(grupa3);
        curs4.addGroup(grupa4);
        curs4.addAssistant("311CC", (Assistant) a7);
        curs4.addAssistant("313CC", (Assistant) a8);

        curs4.addStudent("311CC", (Student) stud11);
        curs4.addStudent("311CC", (Student) stud12);
        curs4.addStudent("311CC", (Student) stud13);
        curs4.addStudent("311CC", (Student) stud14);
        curs4.addStudent("311CC", (Student) stud15);

        curs4.addStudent("313CC", (Student) stud16);
        curs4.addStudent("313CC", (Student) stud17);
        curs4.addStudent("313CC", (Student) stud18);
        curs4.addStudent("313CC", (Student) stud19);
        curs4.addStudent("313CC", (Student) stud20);

        catalog.addCourse(curs4);

        List<ScoreVisitor.Tuple> tuples1 = new ArrayList<ScoreVisitor.Tuple>();
        List<ScoreVisitor.Tuple> tuples2 = new ArrayList<ScoreVisitor.Tuple>();
        List<ScoreVisitor.Tuple> tuples3 = new ArrayList<ScoreVisitor.Tuple>();
        List<ScoreVisitor.Tuple> tuples4 = new ArrayList<ScoreVisitor.Tuple>();

        ScoreVisitor.Tuple<Student,String,Double>Tuple1 = new ScoreVisitor.Tuple(stud3, "Programare orientata pe obiecte", 2.35);
        ScoreVisitor.Tuple<Student,String,Double> Tuple2 = new ScoreVisitor.Tuple(stud1, "Programare orientata pe obiecte", 1.2);
        ScoreVisitor.Tuple<Student,String,Double> Tuple3 = new ScoreVisitor.Tuple(stud5, "Programare orientata pe obiecte", 1.6);
        ScoreVisitor.Tuple<Student,String,Double> Tuple4 = new ScoreVisitor.Tuple(stud4, "Programare orientata pe obiecte", 4.1);
        ScoreVisitor.Tuple<Student,String,Double> Tuple5 = new ScoreVisitor.Tuple(stud2, "Programare orientata pe obiecte", 2.35);
        ScoreVisitor.Tuple<Student,String,Double> Tuple6 = new ScoreVisitor.Tuple(stud6, "Programare orientata pe obiecte", 0.85);
        ScoreVisitor.Tuple<Student,String,Double> Tuple7 = new ScoreVisitor.Tuple(stud7, "Programare orientata pe obiecte", 1.5);
        ScoreVisitor.Tuple<Student,String,Double> Tuple8 = new ScoreVisitor.Tuple(stud8, "Programare orientata pe obiecte", 3.75);
        ScoreVisitor.Tuple<Student,String,Double> Tuple9 = new ScoreVisitor.Tuple(stud9, "Programare orientata pe obiecte", 5.0);
        ScoreVisitor.Tuple<Student,String,Double> Tuple10 = new ScoreVisitor.Tuple(stud10, "Programare orientata pe obiecte", 3.25);
        ScoreVisitor.Tuple<Student,String,Double> Tuple11 = new ScoreVisitor.Tuple(stud3, "Paradigme de programare", 1.15);
        ScoreVisitor.Tuple<Student,String,Double> Tuple12 = new ScoreVisitor.Tuple(stud1, "Paradigme de programare", 3.7);
        ScoreVisitor.Tuple<Student,String,Double> Tuple13 = new ScoreVisitor.Tuple(stud5, "Paradigme de programare", 4.0);
        ScoreVisitor.Tuple<Student,String,Double> Tuple14 = new ScoreVisitor.Tuple(stud4, "Paradigme de programare", 2.35);
        ScoreVisitor.Tuple<Student,String,Double> Tuple15 = new ScoreVisitor.Tuple(stud2, "Paradigme de programare", 2.9);
        ScoreVisitor.Tuple<Student,String,Double> Tuple16 = new ScoreVisitor.Tuple(stud6, "Paradigme de programare", 1.75);
        ScoreVisitor.Tuple<Student,String,Double> Tuple17 = new ScoreVisitor.Tuple(stud7, "Paradigme de programare", 2.25);
        ScoreVisitor.Tuple<Student,String,Double> Tuple18 = new ScoreVisitor.Tuple(stud8, "Paradigme de programare", 4.2);
        ScoreVisitor.Tuple<Student,String,Double> Tuple19= new ScoreVisitor.Tuple(stud9, "Paradigme de programare", 3.6);
        ScoreVisitor.Tuple<Student,String,Double> Tuple20 = new ScoreVisitor.Tuple(stud10, "Paradigme de programare", 1.95);
        ScoreVisitor.Tuple<Student,String,Double> Tuple21 = new ScoreVisitor.Tuple(stud11, "Electronica digitala", 3.45);
        ScoreVisitor.Tuple<Student,String,Double> Tuple22 = new ScoreVisitor.Tuple(stud12, "Electronica digitala", 1.75);
        ScoreVisitor.Tuple<Student,String,Double> Tuple23 = new ScoreVisitor.Tuple(stud13, "Electronica digitala", 2.5);
        ScoreVisitor.Tuple<Student,String,Double> Tuple24 = new ScoreVisitor.Tuple(stud14, "Electronica digitala", 0.6);
        ScoreVisitor.Tuple<Student,String,Double> Tuple25 = new ScoreVisitor.Tuple(stud15, "Electronica digitala", 3.95);
        ScoreVisitor.Tuple<Student,String,Double> Tuple26 = new ScoreVisitor.Tuple(stud16, "Electronica digitala", 5.0);
        ScoreVisitor.Tuple<Student,String,Double> Tuple27 = new ScoreVisitor.Tuple(stud17, "Electronica digitala", 3.55);
        ScoreVisitor.Tuple<Student,String,Double> Tuple28 = new ScoreVisitor.Tuple(stud18, "Electronica digitala", 2.15);
        ScoreVisitor.Tuple<Student,String,Double> Tuple29 = new ScoreVisitor.Tuple(stud19, "Electronica digitala", 1.0);
        ScoreVisitor.Tuple<Student,String,Double> Tuple30 = new ScoreVisitor.Tuple(stud20, "Electronica digitala", 2.2);
        ScoreVisitor.Tuple<Student,String,Double> Tuple31 = new ScoreVisitor.Tuple(stud11, "Sisteme de operare", 1.65);
        ScoreVisitor.Tuple<Student,String,Double> Tuple32 = new ScoreVisitor.Tuple(stud12, "Sisteme de operare", 3.35);
        ScoreVisitor.Tuple<Student,String,Double> Tuple33 = new ScoreVisitor.Tuple(stud13, "Sisteme de operare", 2.8);
        ScoreVisitor.Tuple<Student,String,Double> Tuple34 = new ScoreVisitor.Tuple(stud14, "Sisteme de operare", 4.15);
        ScoreVisitor.Tuple<Student,String,Double> Tuple35 = new ScoreVisitor.Tuple(stud15, "Sisteme de operare", 0.55);
        ScoreVisitor.Tuple<Student,String,Double> Tuple36 = new ScoreVisitor.Tuple(stud16, "Sisteme de operare", 3.65);
        ScoreVisitor.Tuple<Student,String,Double> Tuple37 = new ScoreVisitor.Tuple(stud17, "Sisteme de operare", 2.1);
        ScoreVisitor.Tuple<Student,String,Double> Tuple38 = new ScoreVisitor.Tuple(stud18, "Sisteme de operare", 3.1);
        ScoreVisitor.Tuple<Student,String,Double> Tuple39 = new ScoreVisitor.Tuple(stud19, "Sisteme de operare", 3.3);
        ScoreVisitor.Tuple<Student,String,Double> Tuple40 = new ScoreVisitor.Tuple(stud20, "Sisteme de operare", 1.45);

        tuples1.add(Tuple1);
        tuples1.add(Tuple2);
        tuples1.add(Tuple3);
        tuples1.add(Tuple4);
        tuples1.add(Tuple5);
        tuples1.add(Tuple6);
        tuples1.add(Tuple7);
        tuples1.add(Tuple8);
        tuples1.add(Tuple9);
        tuples1.add(Tuple10);
        tuples2.add(Tuple11);
        tuples2.add(Tuple12);
        tuples2.add(Tuple13);
        tuples2.add(Tuple14);
        tuples2.add(Tuple15);
        tuples2.add(Tuple16);
        tuples2.add(Tuple17);
        tuples2.add(Tuple18);
        tuples2.add(Tuple19);
        tuples2.add(Tuple20);
        tuples3.add(Tuple21);
        tuples3.add(Tuple22);
        tuples3.add(Tuple23);
        tuples3.add(Tuple24);
        tuples3.add(Tuple25);
        tuples3.add(Tuple26);
        tuples3.add(Tuple27);
        tuples3.add(Tuple28);
        tuples3.add(Tuple29);
        tuples3.add(Tuple30);
        tuples4.add(Tuple31);
        tuples4.add(Tuple32);
        tuples4.add(Tuple33);
        tuples4.add(Tuple34);
        tuples4.add(Tuple35);
        tuples4.add(Tuple36);
        tuples4.add(Tuple37);
        tuples4.add(Tuple38);
        tuples4.add(Tuple39);
        tuples4.add(Tuple40);
        examScore.put((Teacher) t1,tuples1);
        examScore.put((Teacher) t2,tuples2);
        examScore.put((Teacher) t3,tuples3);
        examScore.put((Teacher) t4,tuples4);

        List<ScoreVisitor.Tuple> tuples5 = new ArrayList<ScoreVisitor.Tuple>();
        List<ScoreVisitor.Tuple> tuples6 = new ArrayList<ScoreVisitor.Tuple>();
        List<ScoreVisitor.Tuple> tuples7 = new ArrayList<ScoreVisitor.Tuple>();
        List<ScoreVisitor.Tuple> tuples8 = new ArrayList<ScoreVisitor.Tuple>();
        List<ScoreVisitor.Tuple> tuples9 = new ArrayList<ScoreVisitor.Tuple>();
        List<ScoreVisitor.Tuple> tuples10 = new ArrayList<ScoreVisitor.Tuple>();
        List<ScoreVisitor.Tuple> tuples11 = new ArrayList<ScoreVisitor.Tuple>();
        List<ScoreVisitor.Tuple> tuples12 = new ArrayList<ScoreVisitor.Tuple>();

        ScoreVisitor.Tuple<Student,String,Double> Tuple41 = new ScoreVisitor.Tuple(stud3, "Programare orientata pe obiecte", 3.4);
        ScoreVisitor.Tuple<Student,String,Double> Tuple42 = new ScoreVisitor.Tuple(stud1, "Programare orientata pe obiecte", 2.75);
        ScoreVisitor.Tuple<Student,String,Double> Tuple43 = new ScoreVisitor.Tuple(stud5, "Programare orientata pe obiecte", 3.5);
        ScoreVisitor.Tuple<Student,String,Double> Tuple44 = new ScoreVisitor.Tuple(stud4, "Programare orientata pe obiecte", 4.85);
        ScoreVisitor.Tuple<Student,String,Double> Tuple45 = new ScoreVisitor.Tuple(stud2, "Programare orientata pe obiecte", 2.35);
        ScoreVisitor.Tuple<Student,String,Double> Tuple46 = new ScoreVisitor.Tuple(stud6, "Programare orientata pe obiecte", 2.15);
        ScoreVisitor.Tuple<Student,String,Double> Tuple47 = new ScoreVisitor.Tuple(stud7, "Programare orientata pe obiecte", 0.4);
        ScoreVisitor.Tuple<Student,String,Double> Tuple48 = new ScoreVisitor.Tuple(stud8, "Programare orientata pe obiecte", 3.65);
        ScoreVisitor.Tuple<Student,String,Double> Tuple49 = new ScoreVisitor.Tuple(stud9, "Programare orientata pe obiecte", 4.9);
        ScoreVisitor.Tuple<Student,String,Double> Tuple50 = new ScoreVisitor.Tuple(stud10, "Programare orientata pe obiecte", 2.1);
        ScoreVisitor.Tuple<Student,String,Double> Tuple51 = new ScoreVisitor.Tuple(stud3, "Paradigme de programare", 4.35);
        ScoreVisitor.Tuple<Student,String,Double> Tuple52 = new ScoreVisitor.Tuple(stud1, "Paradigme de programare", 1.25);
        ScoreVisitor.Tuple<Student,String,Double> Tuple53 = new ScoreVisitor.Tuple(stud5, "Paradigme de programare", 4.65);
        ScoreVisitor.Tuple<Student,String,Double> Tuple54 = new ScoreVisitor.Tuple(stud4, "Paradigme de programare", 2.1);
        ScoreVisitor.Tuple<Student,String,Double> Tuple55 = new ScoreVisitor.Tuple(stud2, "Paradigme de programare", 3.4);
        ScoreVisitor.Tuple<Student,String,Double> Tuple56 = new ScoreVisitor.Tuple(stud6, "Paradigme de programare", 0.7);
        ScoreVisitor.Tuple<Student,String,Double> Tuple57 = new ScoreVisitor.Tuple(stud7, "Paradigme de programare", 3.25);
        ScoreVisitor.Tuple<Student,String,Double> Tuple58 = new ScoreVisitor.Tuple(stud8, "Paradigme de programare", 2.45);
        ScoreVisitor.Tuple<Student,String,Double> Tuple59= new ScoreVisitor.Tuple(stud9, "Paradigme de programare", 4.25);
        ScoreVisitor.Tuple<Student,String,Double> Tuple60 = new ScoreVisitor.Tuple(stud10, "Paradigme de programare", 1.3);
        ScoreVisitor.Tuple<Student,String,Double> Tuple61 = new ScoreVisitor.Tuple(stud11, "Electronica digitala", 2.05);
        ScoreVisitor.Tuple<Student,String,Double> Tuple62 = new ScoreVisitor.Tuple(stud12, "Electronica digitala", 4.15);
        ScoreVisitor.Tuple<Student,String,Double> Tuple63 = new ScoreVisitor.Tuple(stud13, "Electronica digitala", 1.75);
        ScoreVisitor.Tuple<Student,String,Double> Tuple64 = new ScoreVisitor.Tuple(stud14, "Electronica digitala", 0.85);
        ScoreVisitor.Tuple<Student,String,Double> Tuple65 = new ScoreVisitor.Tuple(stud15, "Electronica digitala", 1.15);
        ScoreVisitor.Tuple<Student,String,Double> Tuple66 = new ScoreVisitor.Tuple(stud16, "Electronica digitala", 3.85);
        ScoreVisitor.Tuple<Student,String,Double> Tuple67 = new ScoreVisitor.Tuple(stud17, "Electronica digitala", 3.35);
        ScoreVisitor.Tuple<Student,String,Double> Tuple68 = new ScoreVisitor.Tuple(stud18, "Electronica digitala", 1.6);
        ScoreVisitor.Tuple<Student,String,Double> Tuple69 = new ScoreVisitor.Tuple(stud19, "Electronica digitala", 3.95);
        ScoreVisitor.Tuple<Student,String,Double> Tuple70 = new ScoreVisitor.Tuple(stud20, "Electronica digitala", 2.35);
        ScoreVisitor.Tuple<Student,String,Double> Tuple71 = new ScoreVisitor.Tuple(stud11, "Sisteme de operare", 3.45);
        ScoreVisitor.Tuple<Student,String,Double>Tuple72 = new ScoreVisitor.Tuple(stud12, "Sisteme de operare", 2.7);
        ScoreVisitor.Tuple<Student,String,Double> Tuple73 = new ScoreVisitor.Tuple(stud13, "Sisteme de operare", 3.4);
        ScoreVisitor.Tuple<Student,String,Double> Tuple74 = new ScoreVisitor.Tuple(stud14, "Sisteme de operare", 2.3);
        ScoreVisitor.Tuple<Student,String,Double> Tuple75 = new ScoreVisitor.Tuple(stud15, "Sisteme de operare", 3.15);
        ScoreVisitor.Tuple<Student,String,Double> Tuple76 = new ScoreVisitor.Tuple(stud16, "Sisteme de operare", 2.4);
        ScoreVisitor.Tuple<Student,String,Double> Tuple77 = new ScoreVisitor.Tuple(stud17, "Sisteme de operare", 3.0);
        ScoreVisitor.Tuple<Student,String,Double> Tuple78 = new ScoreVisitor.Tuple(stud18, "Sisteme de operare", 0.8);
        ScoreVisitor.Tuple<Student,String,Double> Tuple79 = new ScoreVisitor.Tuple(stud19, "Sisteme de operare", 1.9);
        ScoreVisitor.Tuple<Student,String,Double> Tuple80 = new ScoreVisitor.Tuple(stud20, "Sisteme de operare", 4.65);

        tuples5.add(Tuple41);
        tuples5.add(Tuple42);
        tuples5.add(Tuple43);
        tuples5.add(Tuple44);
        tuples5.add(Tuple45);
        tuples6.add(Tuple46);
        tuples6.add(Tuple47);
        tuples6.add(Tuple48);
        tuples6.add(Tuple49);
        tuples6.add(Tuple50);
        tuples7.add(Tuple51);
        tuples7.add(Tuple52);
        tuples7.add(Tuple53);
        tuples7.add(Tuple54);
        tuples7.add(Tuple55);
        tuples8.add(Tuple56);
        tuples8.add(Tuple57);
        tuples8.add(Tuple58);
        tuples8.add(Tuple59);
        tuples8.add(Tuple60);
        tuples9.add(Tuple61);
        tuples9.add(Tuple62);
        tuples9.add(Tuple63);
        tuples9.add(Tuple64);
        tuples9.add(Tuple65);
        tuples10.add(Tuple66);
        tuples10.add(Tuple67);
        tuples10.add(Tuple68);
        tuples10.add(Tuple69);
        tuples10.add(Tuple70);
        tuples11.add(Tuple71);
        tuples11.add(Tuple72);
        tuples11.add(Tuple73);
        tuples11.add(Tuple74);
        tuples11.add(Tuple75);
        tuples12.add(Tuple76);
        tuples12.add(Tuple77);
        tuples12.add(Tuple78);
        tuples12.add(Tuple79);
        tuples12.add(Tuple80);
        partialScore.put((Assistant) a2,tuples5);
        partialScore.put((Assistant) a1,tuples6);
        partialScore.put((Assistant) a3,tuples7);
        partialScore.put((Assistant) a4,tuples8);
        partialScore.put((Assistant) a5,tuples9);
        partialScore.put((Assistant) a6,tuples10);
        partialScore.put((Assistant) a7,tuples11);
        partialScore.put((Assistant) a8,tuples12);

        ScoreVisitor sc=new ScoreVisitor(examScore, partialScore);
        ((Teacher) t1).accept(sc);
        ((Teacher) t2).accept(sc);
        ((Teacher) t3).accept(sc);
        ((Teacher) t4).accept(sc);

        ((Assistant) a1).accept(sc);
        ((Assistant) a2).accept(sc);
        ((Assistant) a3).accept(sc);
        ((Assistant) a4).accept(sc);
        ((Assistant) a5).accept(sc);
        ((Assistant) a6).accept(sc);
        ((Assistant) a7).accept(sc);
        ((Assistant) a8).accept(sc);

        System.out.println("Catalog:");
        System.out.println(catalog);
        List<Course> courses=Catalog.getInstance().getList();
        for(int i=0; i<courses.size(); i++) {
            System.out.println("Studenti:");
            System.out.println(courses.get(i).getAllStudents());
            System.out.println("Asisteti:");
            System.out.println(courses.get(i).getAssistants());
            System.out.println("Note:");
            System.out.println(courses.get(i).gettAllStudentGrades());
            System.out.println("Cel mai bun student:");
            System.out.println(courses.get(i).getBestStudent());
            System.out.println("\n");
        }

        //StudentPage s = new StudentPage((Student) stud20);

        //Autentification aut=new Autentification(t3,"abc123");
        //ParentPage p=new ParentPage((Parent)p1);

        //PENTRU A RULA TEACHERPAGE SI ASISSTENTPAGE SE COMENTEAZA LIILE 459-472 PENTRU A ADAUGA LA MOMENTUL FIECARUI PROFESOR/ASISTENT
        //TeacherPage t=new TeacherPage((Teacher) t1);
        //AssistantPage a=new AssistantPage((Assistant) a2);

    }
}
