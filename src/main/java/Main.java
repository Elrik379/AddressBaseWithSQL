import java.io.IOException;
import java.sql.SQLException;
import workWithSQL.Process;

public class Main {

    public static void main(String[] args) throws SQLException, IOException {
        ConnectionWithSQL sql = new ConnectionWithSQL();
        Process process = new Process();
        sql.insert(process.addingData());
        sql.showBase();
        sql.closeConnection();
    }
}