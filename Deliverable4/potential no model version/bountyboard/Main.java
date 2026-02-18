package com.bountyboard;

import com.bountyboard.dao.BountyBoardService;
import com.bountyboard.dao.DatabaseConnection;
import com.bountyboard.ui.MenuHandler;

import java.sql.Connection;

// takes in args to avoid hardcoded resources. Uses try with resources to guarantee the connection is closed.
// args[0]=jdbcUrl args[1]=dbUser args[2]=dbPass

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
