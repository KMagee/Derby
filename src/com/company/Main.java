//IDEA - have the connection as a different class and call it in the main method
// have the sql statements in another class and call them
//write an object to the database, if all the attributes are complete...then call the insert;

package com.company;

import java.sql.*;

public class Main {

    public static void main(String[] args) {

        DBConnect.getDBConnection();

        try
        {
            Statement s = DBConnect.conn.createStatement();

            s.execute("CREATE TABLE thirdtable (ID INT PRIMARY KEY, NAME VARCHAR(14))");
            s.execute("INSERT INTO thirdtable VALUES (100,'ONE HUNDRED'),(200,'TWO HUNDRED'),(300,'THREE HUNDRED')");


            ResultSet rs = s.executeQuery("Select * from thirdtable");
            while (rs.next())
            {
                System.out.println(rs.getInt("ID") + "\t" + rs.getString("Name"));
            }

            s.execute("DROP TABLE thirdtable");

        }
        catch(SQLException sqle){
            System.err.println(sqle);
        }
    }
}
