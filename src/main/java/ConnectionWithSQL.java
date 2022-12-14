import java.io.PrintStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionWithSQL {
    public static final String USER_NAME = "Eduard";
    public static final String PASSWORD = "56565656QqQ_";
    public static final String URL = "jdbc:mysql://localhost:3306/adressbook";
    public static Statement statement;
    public static Connection connection;
    private static ResultSet resultSet;
    private static PrintStream printStream = new PrintStream(System.out);;


    public void insert(String data) throws SQLException {
        String query = "INSERT INTO adressbook.address(Adress, FirstName, LastName, Age) \n VALUES " + data;
        statement.executeUpdate(query);
    }

    public void showBase() throws SQLException {
        String query = "select * from address";
        resultSet = statement.executeQuery(query);

        while(resultSet.next()) {
            int id = resultSet.getInt(1);
            String address = resultSet.getString(2);
            String firstName = resultSet.getString(3);
            String lastName = resultSet.getString(4);
            int age = resultSet.getInt(5);
            printStream.printf("id: %d, Адрес: %s, Житель: %s %s, Возраст: %d%n", id, address, firstName, lastName, age);
        }

    }

    public void closeConnection() throws SQLException {
        connection.close();
        statement.close();
    }

    static {
        try {
            connection = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
            printStream.println("База подключена");
        } catch (SQLException var2) {
            var2.printStackTrace();
            throw new RuntimeException();
        }
    }

    static {
        try {
            statement = connection.createStatement();
        } catch (SQLException var1) {
            var1.printStackTrace();
            throw new RuntimeException();
        }
    }


}
