/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package thogakade.controller;

import java.sql.*;
import thogakade.db.DBConnection;
import thogakade.model.Customer;

/**
 *
 * @author nirot
 */
public class CustomerController {
    public static boolean addCustomer(Customer customer) throws ClassNotFoundException, SQLException{
        Connection connection=DBConnection.getInstance().getConnection();
        PreparedStatement stm = connection.prepareStatement("Insert into Customer Values(?,?,?,?)");
        stm.setObject(1, customer.getId());
        stm.setObject(2, customer.getName());
        stm.setObject(3, customer.getAddress());
        stm.setObject(4, customer.getSalary());
        int res=stm.executeUpdate();
        return res>0;
    }
    public static Customer searchCustomer(String id) throws ClassNotFoundException, SQLException{
        Connection connection = DBConnection.getInstance().getConnection();
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery("Select * From Customer where id='"+id+"'");
        if(rst.next()){
            return new Customer(rst.getString("id"), rst.getString("name"), rst.getString("address"), rst.getDouble("salary"));
        }
        return null;
    }
}
