package thogakade;

import java.sql.*;

/**
 *
 * @author nirot
 */
public class ThogaKade {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/ThogaKade", "root", "mysql");

            String SQL = "Select * From Customer";
            Statement stm = connection.createStatement();
            ResultSet rst = stm.executeQuery(SQL);
            while (rst.next()) {
                String id = rst.getString("id");
                String name = rst.getString("name");
                String address = rst.getString(3);
                double salary = rst.getDouble("salary");
                System.out.println(id + "\t" + name + "\t+" + address + "\t" + salary);
            }
        } catch (ClassNotFoundException ex) {
            System.out.println("Driver s/w not found..");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

}
