/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javadbexercises;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;


/**
 *
 * @author k00223375
 */
public class QuickExercises 
{
   
public static void main(String[] args)
{
    try {

              //create the connection object
              //ATTN: username and password must be changed depending on the settings on your database server
              Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/books", "sduser", "pass");

              //create a statement object.
	      //We will use this object to carry our query to the database
	      Statement statement = connection.createStatement();

              //exexute our query, which will lead to the return of a resultset
	      //ResultSet resultSet = statement.executeQuery("SELECT Title, YearPublished FROM titles WHERE YearPublished < 1998 ORDER BY Title ASC;");
              //ResultSet resultSet = statement.executeQuery("SELECT Title, YearPublished FROM titles WHERE YearPublished>= 1994 && YearPublished<= 1998 ORDER BY Title ASC;");
              //ResultSet resultSet = statement.executeQuery("SELECT COUNT(Title) AS Publisher1Count FROM books.titles WHERE PublisherID = 1;");
              //ResultSet resultSet = statement.executeQuery("SELECT AVG(Price) AS Average_Price FROM books.titles;");
              ResultSet resultSet = statement.executeQuery("SELECT AVG(Price) AS Average_Price FROM books.titles;");
              
              
              String results="";

	     ResultSetMetaData metaData =  resultSet.getMetaData();

	      int numberOfColumns = metaData.getColumnCount();

	      for (int i =1; i <= numberOfColumns; i++) {
				results += metaData.getColumnName(i) + "\t";
	      }

	     results +="\n";

	     while(resultSet.next()) {
		for (int i=1;  i <= numberOfColumns; i++){
                    results +=resultSet.getObject(i) + "\t";
                }//end for

                results+= "\n";
            }//end while

	    statement.close();
            connection.close();
            
            System.out.println(results);
              
              
        }
        
        catch(SQLException sqlex) {
            JOptionPane.showMessageDialog(null, sqlex.toString());
            System.exit(0);
	}
    }
              
}
