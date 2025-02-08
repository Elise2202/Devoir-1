import java.sql.*;

public class TestJDBC {
    public static void main(String[] args) {
        // Database connection parameters
        String url = "jdbc:postgresql://localhost:5432/mydatabase";
        String user = "postgres";  // Replace with your PostgreSQL username
        String password = "Sophie266@";  // Replace with your PostgreSQL password

        // JDBC connection
        try {
            // Load PostgreSQL JDBC Driver
            Class.forName("org.postgresql.Driver");

            // Establish connection
            Connection cx = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to the database!");

            // Create a statement
            Statement st = cx.createStatement();

            // Execute a query
            ResultSet rs = st.executeQuery("SELECT * FROM personnes");

            // Process the result set
            while (rs.next()) {
                String nom = rs.getString("nom");
                int age = rs.getInt("age");
                System.out.println(nom + " a " + age + " ans");
            }

            // Close resources
            rs.close();
            st.close();
            cx.close();
            System.out.println("Connection closed.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
