/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package supply.chain.manageement.system;

/**
 *
 * @author ADITYA
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SearchProduct {
   
   private JFrame mainFrame;
   private JLabel headerLabel;
   private JLabel statusLabel;
   private JPanel controlPanel;
   private JLabel id,pid;
   private static int count = 0;
   GridLayout experimentLayout = new GridLayout(0,2);
    ResultSet rs;

   SearchProduct(){
      prepareGUI();
   }

   public static void main(String[] args){
      SearchProduct  swingControlDemo = new SearchProduct();
      swingControlDemo.showButtonDemo();
   }  
        private void prepareGUI(){
      mainFrame = new JFrame("Search Product");
      mainFrame.setSize(700,400);
      mainFrame.setLayout(new GridLayout(3, 1));
	  mainFrame.getContentPane().setBackground(Color.green);
      mainFrame.addWindowListener(new WindowAdapter() {
         public void windowClosing(WindowEvent windowEvent){
            mainFrame.setVisible(false);
         }
      });
      headerLabel = new JLabel("", JLabel.CENTER);
      statusLabel = new JLabel("",JLabel.CENTER);

      statusLabel.setSize(350,400);

      controlPanel = new JPanel();
      controlPanel.setLayout(new FlowLayout());

      mainFrame.add(headerLabel);
      mainFrame.add(controlPanel);
      mainFrame.add(statusLabel);
      mainFrame.setVisible(true);
   }


   public void showButtonDemo(){

      headerLabel.setText("Supply Chain Management System");
	  headerLabel.setFont(new Font(null, Font.BOLD, 27));
	  headerLabel.setForeground(Color.black);
	
        pid = new JLabel("Enter Product Id");
        JTextField tf2=new JTextField();
        tf2.setSize(100,30);
        

        JButton okButton = new JButton("Search Product");


      okButton.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            PreparedStatement pst;
            DBConnection con = new DBConnection();
            try{
                pst = con.mkDataBase().prepareStatement("select * from product where product_id=?");
                pst.setInt(1, Integer.parseInt(tf2.getText()));
                 ResultSet rs=pst.executeQuery();
                 if(rs.next()){
                     String name=rs.getString("product_name");
                     double price=rs.getDouble("price");
                     int quantity=rs.getInt("quantity");
                     
                     String message ="Product Name: " + name +
                                 "\nPrice: " + price +
                                 "\nQuantity: " + quantity;
                  
                          JOptionPane.showMessageDialog(null, message, "Product Found", JOptionPane.INFORMATION_MESSAGE);
                 }
                pst.execute();
                
                JOptionPane.showMessageDialog(null, "Product Details Available Quantiy: Price:" + tf2.getText());
                mainFrame.setVisible(true);
                
            }catch(Exception ex){
                System.out.println(ex);
                System.out.println("Error");
                JOptionPane.showMessageDialog(null, "Error");
            }finally{
                
            }
         }
      });
      
      JPanel jp = new JPanel();
      jp.add(pid);
      jp.add(tf2);

      jp.setSize(200,200);
      jp.setLayout(experimentLayout);
      controlPanel.add(jp);
      jp.add(okButton);


      
      mainFrame.setVisible(true);
	  
	  mainFrame.setLocationRelativeTo(null);
      
   }      
}
