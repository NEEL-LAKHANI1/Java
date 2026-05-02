package Assignment_9_10_JDBC_CRUD;


import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.sql.*;

public class RestaurantMenuGUI extends Application {

    // Database details
    private static final String URL = "jdbc:mysql://localhost:3306/RestaurantDB";
    private static final String USER = "root";
    private static final String PASSWORD = "your_password";

    TextArea output = new TextArea();

    @Override
    public void start(Stage stage) {

        // ===== Buttons =====
        Button insertRestaurantBtn = new Button("Insert Restaurant");
        Button insertMenuBtn = new Button("Insert Menu Item");
        Button selectBtn = new Button("Select MenuItem Price <= 100");
        Button updateBtn = new Button("Update Price <= 100 to 200");
        Button deleteBtn = new Button("Delete Names Starting with P");
        Button cafeBtn = new Button("Items in Cafe Java");

        // ===== Action for Insert Restaurant =====
        insertRestaurantBtn.setOnAction(e -> {
            try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD)) {

                String sql = "INSERT INTO Restaurant VALUES (11, 'Java House', 'Pune')";
                Statement st = con.createStatement();
                st.executeUpdate(sql);

                output.setText("Restaurant inserted successfully!\n\n" +
                        "Id: 11\nName: Java House\nAddress: Pune");

            } catch (Exception ex) {
                output.setText(ex.getMessage());
            }
        });

        // ===== Action for Insert MenuItem =====
        insertMenuBtn.setOnAction(e -> {
            try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD)) {

                String sql = "INSERT INTO MenuItem VALUES (11, 'Cold Coffee', 150, 11)";
                Statement st = con.createStatement();
                st.executeUpdate(sql);

                output.setText("Menu Item inserted successfully!\n\n" +
                        "Id: 11\nName: Cold Coffee\nPrice: 150\nRestaurant Id: 11");

            } catch (Exception ex) {
                output.setText(ex.getMessage());
            }
        });

        // ===== Select Items where Price <= 100 =====
        selectBtn.setOnAction(e -> {
            try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD)) {

                String sql = "SELECT * FROM MenuItem WHERE Price <= 100";
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery(sql);

                StringBuilder result = new StringBuilder();
                result.append("ID\tNAME\t\tPRICE\tRES_ID\n");
                result.append("--------------------------------------\n");

                while (rs.next()) {
                    result.append(rs.getInt("Id")).append("\t")
                            .append(rs.getString("Name")).append("\t\t")
                            .append(rs.getDouble("Price")).append("\t")
                            .append(rs.getInt("ResId")).append("\n");
                }

                output.setText(result.toString());

            } catch (Exception ex) {
                output.setText(ex.getMessage());
            }
        });

        // ===== Select Items in Cafe Java =====
        cafeBtn.setOnAction(e -> {
            try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD)) {

                String sql = "SELECT m.* FROM MenuItem m " +
                        "JOIN Restaurant r ON m.ResId = r.Id " +
                        "WHERE r.Name = 'Cafe Java'";

                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery(sql);

                StringBuilder result = new StringBuilder();
                result.append("Items in Cafe Java\n\n");
                result.append("ID\tNAME\t\tPRICE\n");
                result.append("-----------------------------\n");

                while (rs.next()) {
                    result.append(rs.getInt("Id")).append("\t")
                            .append(rs.getString("Name")).append("\t\t")
                            .append(rs.getDouble("Price")).append("\n");
                }

                output.setText(result.toString());

            } catch (Exception ex) {
                output.setText(ex.getMessage());
            }
        });

        // ===== Update Price =====
        updateBtn.setOnAction(e -> {
            try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD)) {

                String sql = "UPDATE MenuItem SET Price = 200 WHERE Price <= 100";
                Statement st = con.createStatement();
                int rows = st.executeUpdate(sql);

                output.setText(rows + " record(s) updated successfully!\n\n" +
                        "All MenuItem prices <= 100 are now changed to 200.");

            } catch (Exception ex) {
                output.setText(ex.getMessage());
            }
        });

        // ===== Delete Items starting with P =====
        deleteBtn.setOnAction(e -> {
            try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD)) {

                String sql = "DELETE FROM MenuItem WHERE Name LIKE 'P%'";
                Statement st = con.createStatement();
                int rows = st.executeUpdate(sql);

                output.setText(rows + " record(s) deleted successfully!\n\n" +
                        "All MenuItems starting with letter P are removed.");

            } catch (Exception ex) {
                output.setText(ex.getMessage());
            }
        });

        // ===== Layout =====
        VBox buttons = new VBox(10,
                insertRestaurantBtn,
                insertMenuBtn,
                selectBtn,
                cafeBtn,
                updateBtn,
                deleteBtn);

        buttons.setPadding(new Insets(10));

        output.setPrefHeight(350);
        output.setEditable(false);

        BorderPane root = new BorderPane();
        root.setLeft(buttons);
        root.setCenter(output);
        root.setPadding(new Insets(15));

        Scene scene = new Scene(root, 800, 400);

        stage.setTitle("Restaurant & MenuItem CRUD - JavaFX");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
