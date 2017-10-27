//IDEA - have the connection as a different class and call it in the main method
// have the sql statements in another class and call them
//write an object to the database, if all the attributes are complete...then call the insert;

package com.company;

import java.sql.*;

public class Main {



    public static void main(String[] args) {

        Connection conn = DBConnect.getDBConnection();

        try
        {
            Statement s =  conn.createStatement();
            s.execute("DROP TABLE SECONDTABLE");
            s.execute("CREATE TABLE SECONDTABLE (ID INT PRIMARY KEY, NAME VARCHAR(14))");
            s.execute("INSERT INTO SECONDTABLE VALUES (100,'ONE HUNDRED'),(200,'TWO HUNDRED'),(300,'THREE HUNDRED')");

            ResultSet rs = s.executeQuery("Select * from SECONDTABLE");
            while (rs.next())
            {
                System.out.println(rs.getInt("ID") + "\t" + rs.getString("Name"));
            }
        }
        catch(SQLException sqle){
            System.err.println(sqle);
        }
    }
}
