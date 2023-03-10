package Tema;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class Autentification extends JFrame {
    public Autentification(User user, String password){
        List<Course> courses=Catalog.getInstance().getList();
        JFrame f = new JFrame();
        ImageIcon im = new ImageIcon("imag2.jpg");
        f.setIconImage(im.getImage());
        f.setTitle("Autentification");
        f.setSize(700, 700);
        f.setLocation(20, 20);

        JPanel panou = new JPanel();
        panou.setBounds(200, 200, 100, 100);
        panou.setLayout(null);
        panou.setBackground(new Color(42, 199, 144, 119));

        JLabel l1 = new JLabel( "User: ");
        l1.setForeground(new Color(25, 82, 62, 255));
        l1.setFont(new Font("Verdana", Font.BOLD, 20));
        l1.setBounds(126, 150, 250, 100);
        panou.add(l1);

        JTextField txt1=new JTextField();
        txt1.setBounds(200,185,250,30);
        panou.add(txt1);

        JLabel l2 = new JLabel( "Password: ");
        l2.setForeground(new Color(25, 82, 62, 255));
        l2.setFont(new Font("Verdana", Font.BOLD, 20));
        l2.setBounds(70, 200, 250, 100);
        panou.add(l2);

        JTextField txt2=new JTextField();
        txt2.setBounds(200,235,250,30);
        panou.add(txt2);

        JButton b=new JButton("Submit");
        b.setFont(new Font("Verdana", Font.BOLD, 14));
        b.setBounds(250, 300, 100, 50);
        b.setFocusable(false);
        b.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(txt1.getText().equals(user.getFirstName()+" "+user.getLastName()) && txt2.getText().equals(password)){
                    for(int i=0;i<courses.size();i++)
                        if(courses.get(i).getAllStudents().contains( user)){
                            StudentPage s=new StudentPage((Student) user);
                        }
                        else
                            if(courses.get(i).getAssistants().contains( user)) {
                                AssistantPage p = new AssistantPage((Assistant) user);
                            }
                            else
                                if(courses.get(i).profesor ==  user) {
                                    TeacherPage t = new TeacherPage((Teacher) user);
                                }

                }
            }
        });

        panou.add(b);

        f.add(panou);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }
}
