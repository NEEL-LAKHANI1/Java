package Assignment_9_10_JDBC_CRUD;

import java.sql.*;

public class A9_JDBC {

    static final String url = "jdbc:mysql://localhost:3306/A9_JDBC";
    static final String user = "root";
    static final String password = "bhavya@1";

    public static void main(String[] args) {

        try {
            // Load MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish connection
            Connection con = DriverManager.getConnection(url, user, password);

            // 1. Insert Records
            insertRestaurants(con);
            insertMenuItems(con);

            // 2. Select MenuItems where price <= 100
            System.out.println("\nMenu Items with Price <= 100:");
            selectByPrice(con);

            // 3. Select MenuItems available in Restaurant named "Cafe Java"
            System.out.println("\nMenu Items available in Cafe Java:");
            selectCafeJavaItems(con);

            // 4. Update MenuItems where price <= 100 to price = 200
            System.out.println("\nUpdating Menu Items with Price <= 100 to 200...");
            updatePrice(con);

            System.out.println("\nMenu Items after Update:");
            displayAllMenuItems(con);

            // 5. Delete MenuItems where name starts with 'P'
            System.out.println("\nDeleting Menu Items whose name starts with P...");
            deleteByName(con);

            System.out.println("\nMenu Items after Delete:");
            displayAllMenuItems(con);

            // Close connection
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Insert 10 records into Restaurant table
    static void insertRestaurants(Connection con) throws SQLException {

        String query = "INSERT INTO Restaurant VALUES (?, ?, ?)";
        PreparedStatement ps = con.prepareStatement(query);

        String[][] restaurants = {
                {"1", "Cafe Java", "Pune"},
                {"2", "Food Hub", "Mumbai"},
                {"3", "Spice Villa", "Delhi"},
                {"4", "Burger Town", "Nagpur"},
                {"5", "Pizza Point", "Nashik"},
                {"6", "Tasty Treat", "Chennai"},
                {"7", "Green Bowl", "Bangalore"},
                {"8", "Royal Dine", "Hyderabad"},
                {"9", "Quick Bite", "Kolkata"},
                {"10", "Urban Cafe", "Jaipur"}
        };

        for (String[] r : restaurants) {
            ps.setInt(1, Integer.parseInt(r[0]));
            ps.setString(2, r[1]);
            ps.setString(3, r[2]);
            ps.executeUpdate();
        }

        System.out.println("10 Restaurant records inserted successfully.");
    }

    // Insert 10 records into MenuItem table
    static void insertMenuItems(Connection con) throws SQLException {

        String query = "INSERT INTO MenuItem VALUES (?, ?, ?, ?)";
        PreparedStatement ps = con.prepareStatement(query);

        Object[][] items = {
                {1, "Pasta", 90, 1},
                {2, "Burger", 120, 1},
                {3, "Pizza", 80, 2},
                {4, "Coffee", 60, 1},
                {5, "Sandwich", 110, 3},
                {6, "Paneer Roll", 95, 4},
                {7, "French Fries", 70, 5},
                {8, "Momos", 130, 6},
                {9, "Pancake", 85, 1},
                {10, "Tea", 40, 7}
        };

        for (Object[] item : items) {
            ps.setInt(1, (int) item[0]);
            ps.setString(2, (String) item[1]);
            ps.setDouble(3, (double) item[2]);
            ps.setInt(4, (int) item[3]);
            ps.executeUpdate();
        }

        System.out.println("10 MenuItem records inserted successfully.");
    }

    // Select all MenuItems where price <= 100
    static void selectByPrice(Connection con) throws SQLException {

        String query = "SELECT * FROM MenuItem WHERE Price <= 100";
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(query);

        printMenuTable(rs);
    }

    // Select all MenuItems available in Restaurant named "Cafe Java"
    static void selectCafeJavaItems(Connection con) throws SQLException {

        String query = "SELECT m.* FROM MenuItem m " +
                "JOIN Restaurant r ON m.ResId = r.Id " +
                "WHERE r.Name = 'Cafe Java'";

        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(query);

        printMenuTable(rs);
    }

    // Update MenuItems price <=100 to 200
    static void updatePrice(Connection con) throws SQLException {

        String query = "UPDATE MenuItem SET Price = 200 WHERE Price <= 100";
        Statement st = con.createStatement();

        int rows = st.executeUpdate(query);
        System.out.println(rows + " record(s) updated.");
    }

    // Delete MenuItems whose name starts with P
    static void deleteByName(Connection con) throws SQLException {

        String query = "DELETE FROM MenuItem WHERE Name LIKE 'P%'";
        Statement st = con.createStatement();

        int rows = st.executeUpdate(query);
        System.out.println(rows + " record(s) deleted.");
    }

    // Display all MenuItems table
    static void displayAllMenuItems(Connection con) throws SQLException {

        String query = "SELECT * FROM MenuItem";
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(query);

        printMenuTable(rs);
    }

    // Common method to print ResultSet in tabular format
    static void printMenuTable(ResultSet rs) throws SQLException {

        System.out.println("-----------------------------------------------------");
        System.out.printf("%-5s %-15s %-10s %-10s\n", "ID", "NAME", "PRICE", "RES_ID");
        System.out.println("-----------------------------------------------------");

        while (rs.next()) {
            System.out.printf("%-5d %-15s %-10.2f %-10d\n",
                    rs.getInt("Id"),
                    rs.getString("Name"),
                    rs.getDouble("Price"),
                    rs.getInt("ResId"));
        }

        System.out.println("-----------------------------------------------------");
    }
}
