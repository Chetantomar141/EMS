package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class main_class extends JFrame {

    main_class(){

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/1234.png"));
        Image i2 = i1.getImage().getScaledInstance(1120,630,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel img = new JLabel(i3);
        img.setBounds(0,0,1120,630);
        add(img);



        JLabel heading = new JLabel("STAFFSPHERE");
        heading.setBounds(350,145,400,40);
        heading.setFont(new Font("Realway",Font.BOLD,25));
        heading.setForeground(Color.LIGHT_GRAY);
       heading.setFont(new Font("serif",Font.BOLD,28));
        img.add(heading);


        JButton add = new JButton("Add Employee");
        add.setBounds(260,320,150,40);
//        add.setForeground(Color.WHITE);
//        add.setBackground(Color.BLACK);
        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AddEmployee();
                setVisible(false);

            }
        });
        img.add(add);

        JButton view = new JButton("View Employee");
        view.setBounds(480,320,150,40);

       view.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               new viewemployee();
               setVisible(false);
           }
       });

        img.add(view);

        JButton rem = new JButton("Remove Employee");
        rem.setBounds(710,320,150,40);
        rem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Removeemployee();

            }
        });
        img.add(rem);


        setLayout(null);
        setSize(1120,630);
        setLocation(250,100);
        setVisible(true);

    }
    public static void main(String[]args){
          new main_class();
    }
}
