package com.bankmanagement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Date;







public class FastCash extends JFrame implements ActionListener {

    JButton deposit,withdrawl,ministatement,pinchange,fastcash,balanceenquiry,exit;
    String pinnumber;


    FastCash( String pinnumber){
        setLayout(null);
        this.pinnumber=pinnumber;
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);

        JLabel text=new JLabel("SELECT WITHDRAWL AMOUNT");
        text.setBounds(210,300,700,35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD,16));
        image.add(text);

        deposit=new JButton("Rs. 100");
        deposit.setBounds(154,394,100,25);
        deposit.addActionListener(this);
        image.add(deposit);

        withdrawl=new JButton("Rs. 500");
        withdrawl.setBounds(330,390,130,30);
        withdrawl.addActionListener(this);
        image.add(withdrawl);


        fastcash=new JButton("Rs. 1000");
        fastcash.setBounds(160,430,130,25);
        fastcash.addActionListener(this);
        image.add(fastcash);

        ministatement=new JButton("Rs. 2000");
        ministatement.setBounds(340,430,140,25);
        ministatement.addActionListener(this);
        image.add(ministatement);

        pinchange=new JButton("Rs. 5000");
        pinchange.setBounds(145,465,130,25);
        pinchange.addActionListener(this);
        image.add(pinchange);


        balanceenquiry=new JButton("Rs. 10000");
        balanceenquiry.setBounds(320,460,140,25);
        balanceenquiry.addActionListener(this);
        image.add(balanceenquiry);

        exit=new JButton("BACK");
        exit.setBounds(340,500,140,25);
        exit.addActionListener(this);
        image.add(exit);







        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        // setUndecorated(true);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==exit){
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        } else {
            String amount = ((JButton)ae.getSource()).getText().substring(3).trim();
            Conn c= new Conn();
            try {
                ResultSet rs = c.s.executeQuery("select * from bank where pinnumber = '" + pinnumber + "'");
                int balance = 0;
                while (rs.next()) {
                    if (rs.getString("type").equals("Deposit")) {
                        balance += Integer.parseInt(rs.getString("amount"));
                    } else {

                        balance -= Integer.parseInt(rs.getString("amount"));
                    }

                }
                if (ae.getSource() != exit && balance < Integer.parseInt(amount)) {
                    JOptionPane.showMessageDialog(null, "Insufficient Balance");
                    return;
                }
                Date date = new Date();
                String query = "insert into bank values('" + pinnumber + "','" + date + "','Withdrawl','" + amount + "')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Rs" + amount + "Debited Sucessfully");
                setVisible(false);
                new Transactions(pinnumber).setVisible(true);





            } catch(Exception e){
                System.out.println(e);
            }

        }



    }
    public static void main(String args[])
    {
        new FastCash("");
    }
}


