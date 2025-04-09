/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package supply.chain.manageement.system;

//import java.awt.Color;
//import java.awt.Font;
//import javax.swing.ImageIcon;
//import javax.swing.JButton;
//import javax.swing.JFrame;
//import javax.swing.JLabel;
//import javax.swing.JPasswordField;
//import javax.swing.JTextField;
import java.awt.*;
import javax.swing.*;
import javax.swing.colorchooser.AbstractColorChooserPanel;
import java.awt.event.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;


/**
 *
 * @author ADITYA
 */
public class Login extends JFrame {
    JLabel idLabel;
    JLabel passLabel;
    JLabel background;
    JLabel headerLabel;
    JLabel devInfo;
    JTextField id;
    JPasswordField pass;
    JButton submit;
    JButton cancel;
    
    public Login(){
        setTitle(" Supply Chain Management System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        
        this.background=new JLabel(new ImageIcon(getClass().getResource("login.jpg")));
        //mainFrame.getContentPane().setBackGround(Color.white);
        this.init();
        add(background);
        background.setVisible(true);
        this.pack();
        this.setSize(700,400);
        this.setLocationRelativeTo(null);
        }
    public void init(){
        headerLabel =new JLabel();
        //this.headerLabel.setText("Supply Chain Mangement System");
        this.headerLabel.setBounds(190,1,370,150);
        this.headerLabel.setFont(new Font("Geomanist",Font.BOLD,20));
        headerLabel.setForeground(Color.red);
        add(headerLabel);
        
        idLabel=new JLabel();
        this.idLabel.setText("Username");
        this.idLabel.setBounds(190,110,100,50);
        this.idLabel.setFont(new Font(null,Font.BOLD,20));
        idLabel.setForeground(Color.black);
        add(idLabel);
        
        passLabel=new JLabel("Password");
      //this.passLabel=setText("Password");
        this.passLabel.setBounds(190,165,100,50);
        this.passLabel.setFont(new Font(null,Font.BOLD,20));
        passLabel.setForeground(Color.black);
        add(passLabel);
        
        devInfo = new JLabel();
        this.devInfo.setText("");
	this.devInfo.setBounds(130,300,1000,30);
	this.devInfo.setFont(new Font("Geomanist", Font.PLAIN, 15));
	devInfo.setForeground(Color.white);
	add(devInfo);
        
        id=new JTextField();
        this.id.setBounds(300, 125, 200, 30);
        add(id);
        
        pass=new JPasswordField();
	this.add(pass);
	this.pass.setBounds(300,175,200,30);
	this.id.setVisible(true);
         this.cancel=new JButton("Cancel");
        this.cancel.setBounds(300,230,100,25);
        add(cancel);
        cancel.addActionListener(this::cancelActionPerformed);
        this.submit=new JButton("Login");
        this.submit.setBounds(400,230,100,25);
        add(submit);
        submit.addActionListener(this::submitActionPerformed);
        
        
        
    }
    public void submitActionPerformed(java.awt.event.ActionEvent evt){
        if(id.getText().equals("admin")&& pass.getText().equals("admin")){
        this.dispose();
        Home fn=new Home();
        fn.showButtonDemo();      
        }
        else
        {
            JOptionPane.showMessageDialog(null,"Invalid Password");
        }
    }   
    public void cancelActionPerformed(java.awt.event.ActionEvent evt){
//       this.dispose();
       // Use dispose() to close just one window. Use System.exit(0) only if
       //you want to completely end the application.
       System.exit(0) ;
    }
   
}
class MyGui{
	public static void main(String[] a){
		Login l = new Login();
		l.setVisible(true);
                
        }
}