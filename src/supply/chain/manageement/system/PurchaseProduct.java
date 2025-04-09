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

public class PurchaseProduct {
       private JFrame mainFrame;
   private JLabel headerLabel;
   private JLabel statusLabel;
   private JPanel controlPanel;
   private JLabel id,pid,quantity;
   private static int count = 0;
   GridLayout experimentLayout = new GridLayout(0,2);
    ResultSet rs;

    PurchaseProduct(){
      prepareGUI();
   }

   public static void main(String[] args){
      PurchaseProduct swingControlDemo = new PurchaseProduct();
      swingControlDemo.showButtonDemo();
   }

   private void prepareGUI(){
      mainFrame = new JFrame("Purchase Product");
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
        
        quantity = new JLabel("Enter Quantity");
        JTextField tf3=new JTextField();
        tf3.setSize(100,30);
        JButton okButton = new JButton("Place Order");


      okButton.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        DBConnection con = new DBConnection();
        PreparedStatement pst;
        ResultSet rs;
        try {
            int productId = Integer.parseInt(tf2.getText());
            int purchaseQuantity = Integer.parseInt(tf3.getText());

            // Step 1: Fetch price of the product
            pst = con.mkDataBase().prepareStatement("SELECT price, quantity FROM product WHERE product_id = ?");
            pst.setInt(1, productId);
            rs = pst.executeQuery();

            if (rs.next()) {
                double price = rs.getDouble("price");
                int availableQty = rs.getInt("quantity");

                if (availableQty >= purchaseQuantity) {
                    double totalAmount = price * purchaseQuantity;

                    // Step 2: Update the product quantity
                    pst = con.mkDataBase().prepareStatement("UPDATE product SET quantity = quantity - ? WHERE product_id = ?");
                    pst.setInt(1, purchaseQuantity);
                    pst.setInt(2, productId);
                    pst.executeUpdate();

                    // Step 3: Show the total amount
                    JOptionPane.showMessageDialog(null, "Order placed!\nTotal Amount: ₹" + totalAmount);
                } else {
                    JOptionPane.showMessageDialog(null, "Not enough quantity in stock! Available: " + availableQty);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Product ID not found!");
            }

        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error occurred!");
        }
    }
});

      JPanel jp = new JPanel();
      jp.add(pid);
      jp.add(tf2);
      jp.add(quantity);
      jp.add(tf3);

      
      jp.setSize(200,200);
      jp.setLayout(experimentLayout);
      controlPanel.add(jp);
      jp.add(okButton);


      
      mainFrame.setVisible(true);
	  
	  mainFrame.setLocationRelativeTo(null);
   }
}
