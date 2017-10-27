package com.company;

import java.sql.*;

public class DBConnect {
    private static DBConnect ourInstance = new DBConnect();

    static Connection conn = null;
    static String DBName = "FirstDB";
    static String protocol ="jdbc:derby://localhost:1527/";



    public static DBConnect getDBConnection(){
        try
        {
            // Step 2: Establish the connection to the database
            String url = protocol + DBName +";create=true;";
            conn = DriverManager.getConnection(url);
            if (conn!=null)
            {
                System.out.println("Connected to: " + DBName );
                System.out.println(conn);
            }

        } catch (SQLException sqle) {
            System.err.println(sqle);
        }
            return ourInstance;
    }

    private DBConnect(){

    }

}
