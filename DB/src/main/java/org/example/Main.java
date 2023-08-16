package org.example;

import Models.Producto;

import java.sql.*;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        try(Connection conn = ConnectionBD.getInstance()){
            Repository<Producto> repository = new
                    ProductRepositoryImpl();
            listProducts(repository);
            getProductById(repository);
//addProduct(repository);
//updateProduct(repository);
            deleteProduct(repository);
        }catch (SQLException e) {
            e.printStackTrace();
        }

        String url = "jdbc:mysql://localhost:3306/test";
        String user = "root";
        String password = "admin";
        try (Connection conn = DriverManager.getConnection(url, user,
                password);
             Statement statement = conn.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM
                     productos");
             ) {
            while (resultSet.next()) {
                System.out.print(resultSet.getInt("id"));
                System.out.print("|");
                System.out.print(resultSet.getString("nombre"));
                System.out.print("|");
                System.out.print(resultSet.getDouble("precio"));
                System.out.print("|");
                System.out.print(resultSet.getDate("fecha_registro"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        }
    }
}
