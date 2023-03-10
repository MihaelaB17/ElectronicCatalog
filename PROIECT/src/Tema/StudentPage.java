package Tema;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.List;

public class StudentPage extends JFrame {
    public StudentPage(Student student) {

        JFrame f = new JFrame();
        ImageIcon im=new ImageIcon("imag2.jpg");
        f.setIconImage(im.getImage());
        f.setTitle("Student Page");
        f.setSize(700,700);
        f.setLocation(20,20);

        JPanel panou=new JPanel();
        panou.setBounds(200,200,100,100);
        panou.setLayout(null);
        panou.setBackground(new Color(42,199, 144, 119));
        JLabel l1=new JLabel(student.getFirstName()+" "+student.getLastName(), JLabel.LEFT);
        l1.setForeground(new Color(25, 82, 62, 255));
        l1.setFont(new Font("Verdana",Font.BOLD, 20));
        l1.setBounds(305,150,250,100);
        panou.add(l1);
        JLabel l2=new JLabel("Student:");
        l2.setForeground(new Color(0, 0, 0));
        l2.setFont(new Font("Verdana",Font.BOLD, 20));
        l2.setBounds(200,150,200,100);
        panou.add(l2);

        JLabel l4=new JLabel("Cursuri:");
        l4.setForeground(new Color(0, 0, 0));
        l4.setFont(new Font("Verdana",Font.BOLD, 20));
        l4.setBounds(300,190,200,100);
        panou.add(l4);

        int var1=270;
        List<Course> courses=Catalog.getInstance().getList();

        for(int i=0; i<courses.size(); i++){
            List<Student> studs;
            studs=courses.get(i).getAllStudents();
            if(studs.contains(student)){
                JButton b=new JButton(courses.get(i).nume);
                b.setBounds(170,var1,350,50);
                b.setFont(new Font("Verdana", Font.BOLD, 15));
                b.setBackground(new Color(76, 128, 187));
                b.setBorder(BorderFactory.createRaisedBevelBorder());
                b.setForeground(new Color(25, 82, 62, 255));
                b.setFocusable(false);
                var1=var1+55;
                int ind = i;
                b.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        b.setEnabled(false);
                        JFrame f1 = new JFrame();
                        ImageIcon im=new ImageIcon("imag2.jpg");
                        f1.setIconImage(im.getImage());
                        f1.setSize(400,400);
                        f1.setLocation(200,200);
                        f1.setTitle(courses.get(ind).nume);

                        JPanel panou2=new JPanel();
                        panou2.setLayout(null);
                        panou2.setBackground(new Color(42,199, 144, 207));

                        JLabel l4=new JLabel("Profesor titular:");
                        l4.setForeground(new Color(0, 0, 0));
                        l4.setFont(new Font("Verdana",Font.BOLD, 14));
                        l4.setBounds(0,0,150,50);
                        panou2.add((l4));

                        JLabel l5=new JLabel(courses.get(ind).getProfesor().getFirstName() + " " + courses.get(ind).getProfesor().getLastName());
                        l5.setForeground(new Color(25, 82, 62, 255));
                        l5.setFont(new Font("Verdana",Font.BOLD, 14));
                        l5.setBounds(150,0,120,50);
                        panou2.add(l5);

                        JLabel l6=new JLabel("Asistenti:");
                        l6.setForeground(new Color(0, 0, 0));
                        l6.setFont(new Font("Verdana",Font.BOLD, 14));
                        l6.setBounds(0,25,150,50);
                        panou2.add((l6));

                        Assistant[] assis = courses.get(ind).getAssistants().toArray(new Assistant[courses.get(ind).getAssistants().size()]);
                        for(int j=0; j<courses.get(ind).getAssistants().size(); j++) {
                            JLabel l7=new JLabel(assis[j].getLastName()+" "+assis[j].getFirstName());
                            l7.setForeground(new Color(25, 82, 62, 255));
                            l7.setFont(new Font("Verdana",Font.BOLD, 14));
                            l7.setBounds(150,25*(j+1),170,50);
                            panou2.add(l7);
                        }
                        JLabel l8=new JLabel("Asistentul studentului:");
                        l8.setFont(new Font("Verdana",Font.BOLD, 14));
                        l8.setForeground(new Color(0, 0, 0));
                        l8.setBounds(0,70,185,50);
                        panou2.add((l8));

                        for(Group group: courses.get(ind).dictionar.values()) {
                            if (group.getStudents().contains(student)) {
                                JLabel l9 = new JLabel(group.assistant.getLastName() + " " + group.assistant.getFirstName());
                                l9.setForeground(new Color(25, 82, 62, 255));
                                l9.setFont(new Font("Verdana", Font.BOLD, 14));
                                l9.setBounds(190, 70, 170, 50);
                                panou2.add(l9);
                            }
                        }

                        JLabel l10=new JLabel("Nota Partial:");
                        l10.setFont(new Font("Verdana",Font.BOLD, 14));
                        l10.setForeground(new Color(0, 0, 0));
                        l10.setBounds(0,100,185,50);
                        panou2.add(l10);

                        for(Grade nota:courses.get(ind).g)
                            if(nota.getStudent() == student){
                                JLabel l11=new JLabel(String.valueOf(nota.getPartialScore()));
                                l11.setFont(new Font("Verdana",Font.BOLD, 14));
                                l11.setForeground(new Color(25, 82, 62, 255));
                                l11.setBounds(120,100,185,50);
                                panou2.add(l11);
                            }

                        JLabel l12=new JLabel("Nota Examen:");
                        l12.setFont(new Font("Verdana",Font.BOLD, 14));
                        l12.setForeground(new Color(0, 0, 0));
                        l12.setBounds(0,130,185,50);
                        panou2.add(l12);

                        for(Grade nota:courses.get(ind).g)
                            if(nota.getStudent() == student){
                                JLabel l13=new JLabel(String.valueOf(nota.getExamScore()));
                                l13.setFont(new Font("Verdana",Font.BOLD, 14));
                                l13.setForeground(new Color(25, 82, 62, 255));
                                l13.setBounds(125,130,185,50);
                                panou2.add(l13);
                            }

                        f1.add(panou2);
                        f1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                        f1.setVisible(true);
                    }
                });

                panou.add(b);
            }
        }

        f.add(panou);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);

    }
}
