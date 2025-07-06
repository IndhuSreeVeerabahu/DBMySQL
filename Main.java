import java.sql.*;

public class Main {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/tasks";
        String user = "root";
        String password = "Indhu@2024";

        String insertQuery = "INSERT INTO Employee (empcode, empname, empage, esalary) VALUES (?, ?, ?, ?)";

        Object[][] employees = {
            {101, "Jenny", 25, 10000.0},
            {102, "Jacky", 30, 20000.0},
            {103, "Joe", 20, 40000.0},
            {104, "John", 40, 80000.0},
            {105, "Shameer", 25, 90000.0}
        };

        try (Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {

            for (Object[] employee : employees) {
                preparedStatement.setInt(1, (Integer) employee[0]);
                preparedStatement.setString(2, (String) employee[1]);
                preparedStatement.setInt(3, (Integer) employee[2]);
                preparedStatement.setDouble(4, (Double) employee[3]);
                preparedStatement.executeUpdate();
            }

            System.out.println("Records inserted successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
