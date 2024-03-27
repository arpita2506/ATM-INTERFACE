package com.bankmanagement;
import java.sql.*;

public class Conn {

    Connection c;
    Statement s;

    public Conn()
    {
        try{

            c=DriverManager.getConnection("jdbc:mysql:///bankmanagementsystem","root","nisi5206");
            s=c.createStatement();

        } catch (Exception e){
            System.out.println(e);

        }
    }




}
