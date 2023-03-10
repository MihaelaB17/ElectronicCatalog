package Tema;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class TeacherPage extends JFrame {
    public TeacherPage(Teacher profesor) {

        JFrame f = new JFrame();
        ImageIcon im = new ImageIcon("imag2.jpg");
        f.setIconImage(im.getImage());
        f.setTitle("Teacher Page");
        f.setSize(700, 700);
        f.setLocation(20, 20);

        JPanel panou = new JPanel();
        panou.setBounds(200, 200, 100, 100);
        panou.setLayout(null);
        panou.setBackground(new Color(42, 199, 144, 119));
        JLabel l1 = new JLabel(profesor.getFirstName() + " " + profesor.getLastName(), JLabel.LEFT);
        l1.setForeground(new Color(25, 82, 62, 255));
        l1.setFont(new Font("Verdana", Font.BOLD, 20));
        l1.setBounds(305, 150, 250, 100);
        panou.add(l1);

        JLabel l2=new JLabel("Profesor:");
        l2.setForeground(new Color(0, 0, 0));
        l2.setFont(new Font("Verdana",Font.BOLD, 20));
        l2.setBounds(200,150,200,100);
        panou.add(l2);

        JLabel l4=new JLabel("Cursuri:");
        l4.setForeground(new Color(0, 0, 0));
        l4.setFont(new Font("Verdana",Font.BOLD, 20));
        l4.setBounds(300,190,200,100);
        panou.add(l4);

        List<Course> courses=Catalog.getInstance().getList();

        for(int i=0; i<courses.size(); i++){
            if(courses.get(i).getProfesor() == profesor){
                JLabel l5=new JLabel(courses.get(i).nume);
                l5.setForeground(new Color(25, 82, 62, 255));
                l5.setFont(new Font("Verdana",Font.BOLD, 14));
                l5.setBounds(200,250,300,50);
                panou.add(l5);
            }

            JButton b=new JButton("Validation");
            b.setBounds(170,500,350,50);
            b.setFont(new Font("Verdana", Font.BOLD, 15));
            b.setBackground(new Color(31, 154, 23));
            b.setForeground(new Color(0, 0,0));
            b.setFocusable(false);
            int ind = i;
            b.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    b.setEnabled(false);
                    ScoreVisitor sc=new ScoreVisitor(Test.examScore, Test.partialScore);
                    profesor.accept(sc);

                    JFrame f1 = new JFrame();
                    ImageIcon im=new ImageIcon("imag2.jpg");
                    f1.setIconImage(im.getImage());
                    f1.setSize(550,250);
                    f1.setLocation(200,200);
                    f1.setTitle(courses.get(ind).nume);

                    JPanel panou2 = new JPanel();
                    panou2.setBackground(new Color(94, 199, 181));
                    panou2.setLayout(null);
                    panou2.setBounds(50, 300, 500, 50);
                    panou2.setLayout(new GridLayout());

                    JLabel l6=new JLabel("Note:");
                    l6.setForeground(new Color(0,0,0));
                    l6.setFont(new Font("Verdana",Font.BOLD, 14));
                    l6.setBounds(0,300,300,50);
                    panou2.add(l6);

                    for(Grade nota:courses.get(ind).g) {
                        JLabel l7=new JLabel(String.valueOf(nota.getExamScore()));
                        l7.setForeground(new Color(13, 49, 41, 255));
                        l7.setFont(new Font("Verdana",Font.BOLD, 14));
                        panou2.add(l7);
                    }
                    f1.add(panou2);
                    f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    f1.setVisible(true);

                }
            });
            panou.add(b);
        }

        f.add(panou);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);

    }

}
