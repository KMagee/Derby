//IDEA - have the connection as a different class and call it in the main method
// have the sql statements in another class and call them
//write an object to the database, if all the attributes are complete...then call the insert;

package com.company;

import java.sql.*;

public class Main {

    public static void main(String[] args) {

        Image newImage = new Image();

        newImage.setCategory("TestCategory6");
        newImage.setDescription("TestDescription6");
        newImage.setFilename("TestFileName6");
        newImage.setPhotographer("TestPhotographer6");


        DBConnect.getDBConnection();

        try
        {
            Statement s = DBConnect.conn.createStatement();

            s.execute("DROP TABLE IMAGES");

           s.execute("CREATE TABLE IMAGES (CATEGORY VARCHAR(50), DESCRIPTION VARCHAR(50), FILENAME VARCHAR(50), PHOTOGRAPHER VARCHAR(50))");


            String insertQuery = "INSERT INTO IMAGES VALUES (?, ?, ?, ?)";
            PreparedStatement pstmt = DBConnect.conn.prepareStatement(insertQuery);

            //data for insert

            pstmt.setString(1,newImage.getCategory());
            pstmt.setString(2, newImage.getDescription());
            pstmt.setString(3, newImage.getFilename());
            pstmt.setString(4, newImage.getPhotographer());

           int rowAffected = pstmt.executeUpdate();
//            System.out.println(String.format("Row affected %d", rowAffected));


            ResultSet rs = s.executeQuery("Select * from IMAGES");
            while (rs.next())
            {
                System.out.println(rs.getString("CATEGORY") + "\t" + rs.getString("DESCRIPTION") + "\t" + rs.getString("FILENAME") + "\t" + rs.getString("PHOTOGRAPHER")  );
            }


        }
        catch(SQLException sqle){
            System.err.println(sqle);
        }
    }
}
