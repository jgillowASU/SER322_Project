import bountyboard.dao.BountyBoardService;
import bountyboard.dao.DatabaseConnection;
import bountyboard.ui.MenuHandler;

import java.sql.Connection;

public class Main {
    public static void main(String[] args) {
        String jdbcUrl = args[0];
        String user = args[1];
        String pw = args[2];

        try (Connection conn = DatabaseConnection.getConnection(jdbcUrl, user, pw)) {
            BountyBoardService service = new BountyBoardService(conn);
            MenuHandler handler = new MenuHandler(service);
            handler.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
