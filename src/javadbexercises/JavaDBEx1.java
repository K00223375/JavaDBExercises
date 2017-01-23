/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javadbexercises;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.YES_NO_OPTION;

/**
 *
 * @author K00223375
 */
public class JavaDBEx1 extends javax.swing.JFrame {

    ResultSet resultSet;
    /**
     * Creates new form JavaDBEx1
     */
    
    public int trackNum = 1;
    public int buttonPressed=1;
    
    public JavaDBEx1() {
        initComponents();
        
        try {

              //create the connection object
              //ATTN: username and password must be changed depending on the settings on your database server
              Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/books", "sduser", "pass");

              //create a statement object.
	      //We will use this object to carry our query to the database
	      Statement statement = connection.createStatement();

              //exexute our query, which will lead to the return of a resultset
	      resultSet = statement.executeQuery("SELECT * FROM authors");
              
              if (resultSet.next()) 
              {
                loadRecord();
              } //end if
      
              else {
                JOptionPane.showMessageDialog(null, "There are no records in the database");
              } //end else
        
        }
        
        catch(SQLException sqlex) {
            JOptionPane.showMessageDialog(null, sqlex.toString());
            System.exit(0);
	}
    }
    
    public void loadRecord() {
        
        try  {
            String authorsID = resultSet.getObject(1).toString();
            String authorsFirstName = resultSet.getObject(2).toString();
            String authorsSecondName = resultSet.getObject(3).toString();

            authorIDTextField.setText(authorsID);
            firstNameTextArea.setText(authorsFirstName);
            lastNameTextField.setText(authorsSecondName);    
        }
        catch(Exception ex) {
            JOptionPane.showMessageDialog(null, "ERROR " + ex);
        }
}

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        authorID = new javax.swing.JLabel();
        firstName = new javax.swing.JLabel();
        lastName = new javax.swing.JLabel();
        firstButton = new javax.swing.JButton();
        nextButton = new javax.swing.JButton();
        previousButton = new javax.swing.JButton();
        lastButton = new javax.swing.JButton();
        exitButton = new javax.swing.JButton();
        lastNameTextField = new javax.swing.JTextField();
        authorIDTextField = new javax.swing.JTextField();
        updateButton = new javax.swing.JButton();
        insertButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        firstNameTextArea = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        authorID.setText("Author ID");

        firstName.setText("First Name");

        lastName.setText("Last Name");

        firstButton.setText("First");
        firstButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                firstButtonActionPerformed(evt);
            }
        });

        nextButton.setText("Next>>");
        nextButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextButtonActionPerformed(evt);
            }
        });

        previousButton.setText("<<Previous");
        previousButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                previousButtonActionPerformed(evt);
            }
        });

        lastButton.setText("Last");
        lastButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lastButtonActionPerformed(evt);
            }
        });

        exitButton.setText("Exit");
        exitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitButtonActionPerformed(evt);
            }
        });

        lastNameTextField.setEditable(false);
        lastNameTextField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lastNameTextFieldMouseClicked(evt);
            }
        });

        authorIDTextField.setEditable(false);
        authorIDTextField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                authorIDTextFieldMouseClicked(evt);
            }
        });

        updateButton.setText("Update");
        updateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButtonActionPerformed(evt);
            }
        });

        insertButton.setText("Insert");
        insertButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertButtonActionPerformed(evt);
            }
        });

        deleteButton.setText("Delete");
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });

        firstNameTextArea.setEditable(false);
        firstNameTextArea.setColumns(20);
        firstNameTextArea.setRows(5);
        firstNameTextArea.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                firstNameTextAreaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(firstNameTextArea);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(authorID, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(110, 110, 110)
                        .addComponent(authorIDTextField))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lastName, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(110, 110, 110)
                        .addComponent(lastNameTextField))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(firstButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nextButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(previousButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lastButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(updateButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(insertButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(deleteButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(exitButton)
                        .addGap(0, 11, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(firstName, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(110, 110, 110)
                        .addComponent(jScrollPane1)))
                .addGap(24, 24, 24))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(authorID)
                    .addComponent(authorIDTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(firstName)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lastName)
                        .addGap(75, 75, 75)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(firstButton)
                            .addComponent(nextButton)
                            .addComponent(previousButton)
                            .addComponent(lastButton)
                            .addComponent(exitButton)
                            .addComponent(updateButton)
                            .addComponent(insertButton)
                            .addComponent(deleteButton)))
                    .addComponent(lastNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void firstButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_firstButtonActionPerformed
        // TODO add your handling code here:
        
       try {
            resultSet.first();
            loadRecord();
        } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null, "ERROR" + ex);
        }
        
    }//GEN-LAST:event_firstButtonActionPerformed

    private void nextButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextButtonActionPerformed
        // TODO add your handling code here:
        try  {
            if (resultSet.next()) {
                loadRecord();
            }
            else {
                JOptionPane.showMessageDialog(null, "You have reached the end of the list");
                resultSet.last();
            }
        }//end try
        catch(SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.toString());
        }//end catch
        
    }//GEN-LAST:event_nextButtonActionPerformed

    private void exitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitButtonActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_exitButtonActionPerformed

    private void lastButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lastButtonActionPerformed
        // TODO add your handling code here:
        try {
            resultSet.last();
            loadRecord();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR" + ex);
        }
    }//GEN-LAST:event_lastButtonActionPerformed

    private void previousButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_previousButtonActionPerformed
        // TODO add your handling code here:
        try  {
            if (resultSet.previous()) {
                loadRecord();
            }
            else {
                JOptionPane.showMessageDialog(null, "You have reached the start of the list");
                resultSet.first();
            }
        }//end try
        catch(SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.toString());
        }//end catch
    }//GEN-LAST:event_previousButtonActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        // TODO add your handling code here:
        int dialogButton = JOptionPane.YES_NO_OPTION;
        int dialogResult = JOptionPane.showConfirmDialog (null, "Are you sure, you would like to delete this row?","Warning",dialogButton);
        
        /*try
        {
            
        }
        catch(SQLException sqlex) {
            JOptionPane.showMessageDialog(null, sqlex.toString());
            System.exit(0);
        }*/
        
        
    }//GEN-LAST:event_deleteButtonActionPerformed

    private void authorIDTextFieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_authorIDTextFieldMouseClicked
        // TODO add your handling code here:
        authorIDTextField.setEditable(true);
    }//GEN-LAST:event_authorIDTextFieldMouseClicked

    private void lastNameTextFieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lastNameTextFieldMouseClicked
        // TODO add your handling code here:
        lastNameTextField.setEditable(true);
    }//GEN-LAST:event_lastNameTextFieldMouseClicked

    private void updateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButtonActionPerformed
        // TODO add your handling code here:        
        String fName = firstNameTextArea.getText();
        String lName = lastNameTextField.getText();
        String aID= authorIDTextField.getText();
        try{
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/books", "sduser", "pass");

	    //create a statement object.
	    //We will use this object to carry our query to the database
	    Statement statement = connection.createStatement();

            String updatetSQL = "UPDATE authors SET FirstName = '"+fName+"', LastName = '"+lName+"' WHERE AuthorID = '"+ aID+"'";

            int rowCount = statement.executeUpdate(updatetSQL);
            
            statement.close();
            connection.close();
            
            }//end try
        catch(Exception ex) {
            JOptionPane.showMessageDialog(null, ex.toString());
        }//end catch
        
    }//GEN-LAST:event_updateButtonActionPerformed

    private void insertButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insertButtonActionPerformed
        // TODO add your handling code here:
         try
        {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/books", "sduser", "pass");

	     
	    //We will use this object to carry our query to the database
	    Statement statement = connection.createStatement();
            
            String input = JOptionPane.showInputDialog("Input Author ID: ");
            int aID= Integer.parseInt(input);
              
            String fName = JOptionPane.showInputDialog("Input Author First Name: ");
            String lName = JOptionPane.showInputDialog("Input Author Last Name: ");
            
            input  = JOptionPane.showInputDialog("Input Author Year Born: ");
            int aYB=Integer.parseInt(input);
            
            String insertSQL = "INSERT INTO authors(AuthorID, FirstName, LastName, YearBorn)VALUES ('"+aID+"','"+fName+"' , '"+lName+"', '"+aYB+"')";
            int rowCount = statement.executeUpdate(insertSQL);
            
            JOptionPane.showMessageDialog(rootPane, aID +" "+ fName +" "+ lName +" "+ aYB + " Have been added to the Database!");
            
            loadRecord();
            
            statement.close();
            connection.close();
            
        }
        catch(SQLException sqlex) {
            JOptionPane.showMessageDialog(null, sqlex.toString());
            System.exit(0);
        }
        
        
    }//GEN-LAST:event_insertButtonActionPerformed

    private void firstNameTextAreaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_firstNameTextAreaMouseClicked
        // TODO add your handling code here:
        firstNameTextArea.setEditable(true);
    }//GEN-LAST:event_firstNameTextAreaMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JavaDBEx1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JavaDBEx1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JavaDBEx1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JavaDBEx1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JavaDBEx1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel authorID;
    private javax.swing.JTextField authorIDTextField;
    private javax.swing.JButton deleteButton;
    private javax.swing.JButton exitButton;
    private javax.swing.JButton firstButton;
    private javax.swing.JLabel firstName;
    private javax.swing.JTextArea firstNameTextArea;
    private javax.swing.JButton insertButton;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton lastButton;
    private javax.swing.JLabel lastName;
    private javax.swing.JTextField lastNameTextField;
    private javax.swing.JButton nextButton;
    private javax.swing.JButton previousButton;
    private javax.swing.JButton updateButton;
    // End of variables declaration//GEN-END:variables
}
