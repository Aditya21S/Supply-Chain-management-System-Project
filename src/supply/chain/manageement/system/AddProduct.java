/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package supply.chain.manageement.system;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author ADITYA
 */
public class AddProduct {
    private JFrame mainFrame;
    private JLabel headerLabel;
    private JPanel controlPanel;
    private JLabel id,name,price,quantity,qt;
    
    private static int count=0;
    GridLayout experimentLayout =new GridLayout(0,2);
    ResultSet rs;
    AddProduct(){
        prepareGUI();
    }     
    
          
    public static void main(String[] args) {
        AddProduct swingControlDemo=new AddProduct();
        swingControlDemo.showButtonDemo();
        
    }
    
    private void prepareGUI(){
        mainFrame = new JFrame("Add Product details");
        mainFrame.setSize(700,500);
        mainFrame.setLayout(new GridLayout(3,1));
        
        mainFrame.getContentPane().setBackground(Color.green);
        
        mainFrame.addWindowListener(new WindowAdapter(){
        @Override
        public void windowClosing(WindowEvent windowEvent){
            mainFrame.setVisible(false);
        }
        });
        
        headerLabel=new JLabel("",JLabel.CENTER);
            controlPanel = new JPanel();
      controlPanel.setLayout(new FlowLayout());

      mainFrame.add(headerLabel);
      mainFrame.add(controlPanel);
      mainFrame.setVisible(true);
        
    }
    public void showButtonDemo(){
        headerLabel.setText("Supply chain");
        headerLabel.setFont(new Font(null,Font.BOLD,27));
        
        name =new JLabel("Enter Product name");
        JTextField tf2= new JTextField();
//        tf2.setSize(100,40);
        tf2.setPreferredSize(new Dimension(200, 25));
        
        price = new JLabel("Enter Product price");
        JTextField tf3=new JTextField();
//        tf3.setSize(100,40);
        tf3.setPreferredSize(new Dimension(200, 25));

        quantity = new JLabel("Enter Quantity");
        JTextField tf4=new JTextField();
//        tf4.setSize(100,40);
        tf4.setPreferredSize(new Dimension(200, 25));
        
//        qt = new JLabel("Enter Price");
//        JTextField tf5=new JTextField();
//        tf4.setSize(100,40);
        
        JButton okButton = new  JButton("Add");
        okButton.setPreferredSize(new Dimension(300,25));
        JButton cancelButton=new JButton("Cancel");
        cancelButton.setPreferredSize(new Dimension(200,35));
        
        JButton exitButton=new JButton("Exit");
        exitButton.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
            System.exit(0);
        }
        });
        cancelButton.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
            tf2.setText("");
                    tf3.setText("");
                    tf4.setText("");
        }
        });
        okButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                PreparedStatement pst;
                DBConnection con= new DBConnection();
                try {
                    pst=con.mkDataBase().prepareStatement("insert into product(product_name,price,quantity)value(?,?,?)");
                    pst.setString(1,tf2.getText());
                    pst.setDouble(2, Double.parseDouble(tf3.getText()));
                    pst.setInt(3,Integer.parseInt(tf4.getText()));
                    pst.execute();
                    JOptionPane.showMessageDialog(null, "Product Added!" + tf2.getText());
                    mainFrame.setVisible(true);
                    //clear fields after input
                    tf2.setText("");
                    tf3.setText("");
                    tf4.setText("");

                   
                } catch (Exception ex) {
                System.out.println(ex);
                System.out.println("EEEE");
                JOptionPane.showMessageDialog(null, "Error");
                } finally {
                    
                }
            }
        });
        
        
            JPanel jp = new JPanel(null);
      jp.add(name );
      jp.add(tf2);
      jp.add(price);
      jp.add(tf3);
      jp.add(quantity);
      jp.add(tf4);
      
     

      jp.setSize(700,700);
      jp.setLayout(experimentLayout);
      controlPanel.add(jp);
      jp.add(okButton);
	 jp.add(cancelButton);
         jp.add(exitButton);

	  mainFrame.setLocationRelativeTo(null);
      mainFrame.setVisible(true);
    }
}
