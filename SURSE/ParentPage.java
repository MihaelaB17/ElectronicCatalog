package Tema;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ParentPage extends JFrame {
    public ParentPage(Parent parinte){
        List<Course> courses=Catalog.getInstance().getList();
        JFrame f = new JFrame();
        ImageIcon im = new ImageIcon("imag2.jpg");
        f.setIconImage(im.getImage());
        f.setTitle("ParentPage");
        f.setSize(700, 700);
        f.setLocation(20, 20);

        JPanel panou = new JPanel();
        panou.setBounds(200, 200, 100, 100);
        panou.setLayout(null);
        panou.setBackground(new Color(42, 199, 144, 119));

        JLabel l1 = new JLabel( parinte.getFirstName()+" "+ parinte.getLastName());
        l1.setForeground(new Color(25, 82, 62, 255));
        l1.setFont(new Font("Verdana", Font.BOLD, 20));
        l1.setBounds(200, 150, 250, 100);
        panou.add(l1);

        int var=230;
        for(int i=0; i<parinte.getNotif().size(); i++){
            JLabel l2 = new JLabel(String.valueOf(parinte.getNotif().get(i)));
            l2.setForeground(new Color(25, 82, 62, 255));
            l2.setFont(new Font("Verdana", Font.BOLD, 11));
            l2.setBounds(50, var, 600, 100);
            var=var+20;
            panou.add(l2);
        }


        f.add(panou);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }
}
