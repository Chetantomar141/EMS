package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;

public class Removeemployee extends JFrame implements ActionListener {

    Choice choiceEMPID;
    JButton delete , back;

    Removeemployee(){

        JLabel label = new JLabel("Employee ID");
        label.setBounds(50,50,100,30);
        label.setFont(new Font("Tahoma",Font.BOLD,15));
        add(label);

        choiceEMPID = new Choice();
        choiceEMPID.setBounds(200,50,150,30);
        add(choiceEMPID);

        try {
            conn c = new conn();
            ResultSet resultSet = c.statement.executeQuery("select * from employee");
            while (resultSet.next()){
                choiceEMPID.add(resultSet.getString("empID"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        JLabel labelname = new JLabel("Name");
        labelname.setBounds(50,100,1510,30);
        labelname.setFont(new Font("Tahoma",Font.BOLD,15));
        add(labelname);

        JLabel textname = new JLabel();
        textname.setBounds(200,100,150,30);
        add(textname);


        JLabel labelphone = new JLabel("Phone");
        labelphone.setBounds(50,150,1510,30);
        labelphone.setFont(new Font("Tohima",Font.BOLD,15));
        add(labelphone);

        JLabel textphone = new JLabel();
        textphone.setBounds(200,150,150,30);
        add(textphone);

        JLabel labelemail = new JLabel("Email");
        labelemail.setBounds(50,200,1510,30);
        labelemail.setFont(new Font("Tohima",Font.BOLD,15));
        add(labelemail);

        JLabel textemail = new JLabel();
        textemail.setBounds(200,200,150,30);
        add(textemail);

        try {
            conn c =new conn();
            ResultSet resultSet= c.statement.executeQuery("select * from employee where empID = '"+choiceEMPID.getSelectedItem()+"'");
            while (resultSet.next()){
                textname.setText((resultSet.getString("name")));
                textphone.setText(resultSet.getString("phone"));
                textemail.setText(resultSet.getString("email"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


        choiceEMPID.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                try {
                    conn c = new conn();
                    ResultSet resultSet= c.statement.executeQuery("select * from employee where empID='"+choiceEMPID.getSelectedItem()+"'");
                    while (resultSet.next()){
                        textname.setText((resultSet.getString("name")));
                        textphone.setText(resultSet.getString("phone"));
                        textemail.setText(resultSet.getString("email"));
                    }
                } catch (Exception E) {
                    E.printStackTrace();
                }
            }
        });

        delete = new JButton("DELETE");
        delete.setBounds(100,280,100,30);
        delete.setBackground(Color.BLACK);
        delete.setForeground(Color.LIGHT_GRAY);
        delete.addActionListener(this);
        add(delete);

        back = new JButton("BACK");
        back.setBounds(300,280,100,30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.LIGHT_GRAY);
        back.addActionListener(this);
        add(back);


        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/1345874.png"));
        Image i2 = i1.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
       ImageIcon i3 = new ImageIcon(i2);
       JLabel img = new JLabel(i3);
       img.setBounds(700,80,200,200);
       add(img);

       ImageIcon i11 = new ImageIcon(ClassLoader.getSystemResource("icon/rback.png"));
       Image i22 = i11.getImage().getScaledInstance(1120,630,Image.SCALE_DEFAULT);
       ImageIcon i33 = new ImageIcon(i22);
       JLabel img2 = new JLabel(i33);
       img2.setBounds(0,0,1120,630);
       add(img2);





        setSize(1000,400);
        setLocation(300,150);
        setLayout(null);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==delete){
            try {
                conn c = new conn();
                String query = " delete from employee where empID='"+choiceEMPID.getSelectedItem()+"'";
                c.statement.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Employee Deleted Succesfully");
                setVisible(false);
                new main_class();



            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }else {
            setVisible(false);
        }
    }

    public static void main(String[] args){
         new Removeemployee();
    }
}
