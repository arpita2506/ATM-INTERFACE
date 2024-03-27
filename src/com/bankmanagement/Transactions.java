package com.bankmanagement;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;



public class Transactions extends JFrame implements ActionListener {

    JButton deposit,withdrawl,ministatement,pinchange,fastcash,balanceenquiry,exit;
    String pinnumber;


    Transactions( String pinnumber){
        setLayout(null);
        this.pinnumber=pinnumber;
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);

        JLabel text=new JLabel("Please select your Transaction");
        text.setBounds(210,300,700,35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD,16));
        image.add(text);

        deposit=new JButton("Deposit");
        deposit.setBounds(154,394,100,25);
        deposit.addActionListener(this);
        image.add(deposit);

        withdrawl=new JButton("Cash Withdrawl");
        withdrawl.setBounds(330,390,130,30);
        withdrawl.addActionListener(this);
        image.add(withdrawl);


        fastcash=new JButton("Fast cash");
        fastcash.setBounds(160,430,130,25);
        fastcash.addActionListener(this);
        image.add(fastcash);

        ministatement=new JButton("Mini Statement");
        ministatement.setBounds(340,430,140,25);
        ministatement.addActionListener(this);
        image.add(ministatement);

        pinchange=new JButton("Pin Change");
        pinchange.setBounds(145,465,130,25);
        pinchange.addActionListener(this);
        image.add(pinchange);


        balanceenquiry=new JButton("Balance Enquiry");
        balanceenquiry.setBounds(320,460,140,25);
        balanceenquiry.addActionListener(this);
        image.add(balanceenquiry);

        exit=new JButton("Exit");
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
            System.exit(0);
        } else if(ae.getSource()==deposit){
            setVisible(false);
            new Deposit(pinnumber).setVisible(true);
        } else if(ae.getSource()==withdrawl){
            setVisible(false);
            new Withdrawl(pinnumber).setVisible(true);
        } else if(ae.getSource()== fastcash){
            setVisible(false);
            new FastCash(pinnumber).setVisible(true);

        } else if(ae.getSource()== pinchange){
            setVisible(false);
            new PinChange(pinnumber).setVisible(true);
        } else if(ae.getSource()== balanceenquiry){
            setVisible(false);
            new BalanceEnquiry(pinnumber).setVisible(true);

        } else if (ae.getSource()== ministatement)
        {

            new MiniStatement(pinnumber).setVisible(true);
        }



    }
    public static void main(String args[])
    {
        new Transactions("");
    }
}
