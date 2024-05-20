/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import javax.swing.JOptionPane;
import model.User;
import java.sql.*;
/**
 *
 * @author Abheesh
 */
public class UserDAO {
    public static void save (User user) {
        String query = "insert into user(name,email,phoneNumber,address,password,securityQuestion,answer, status) values ('"+user.getName()+"', '"+user.getEmail()+"', '"+user.getPhoneNumber()+"','"+user.getAddress()+"','"+user.getPassword()+"','"+user.getSecurityQuestion()+"','"+user.getAnswer()+"','false')";
        DbOperations.setDataOrDelete(query, "Registered successfully! wait for admin approval!");
    }
    public static User login(String email,String password){
        User user=null;
        try{
            ResultSet rs = DbOperations.getData("select * from user where email='"+email+"' and password='"+password+"'");
            while(rs.next()){
                user = new User();
                user.setStatus(rs.getString("status"));
            }
        }
        catch(Exception e){
            JOptionPane.showInternalMessageDialog(null, e);
        }
        return user;
    }
}
