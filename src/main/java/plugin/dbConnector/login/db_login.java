package plugin.dbConnector.login;

import plugin.GlobalVariable;

import java.sql.*;

public class db_login {
    GlobalVar_login var = new GlobalVar_login();
    GlobalVariable gv = new GlobalVariable();

    public void ConnectDB() {

        String dbUrl = gv.dbUrl_om;
        String dbUsername = gv.dbUsername_om;
        String dbPassword = gv.dbPassword_om;

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            // Register the Oracle JDBC driver
            Class.forName("oracle.jdbc.driver.OracleDriver");

            // Establish the connection
            connection = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
            System.out.println("Connected to the database successfully!");

            // Create a statement object
            statement = connection.createStatement();

            // Execute a query to count the number of rows in the table
            String query = "SELECT * FROM LOGIN"; // Modify with your actual table name
            resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                String nameTestcase = resultSet.getString("NAME_TESTCASE");

                String userId = resultSet.getString("USER_ID");
                var.user_id.put(nameTestcase, userId != null ? userId : "");

                String password = resultSet.getString("PASSWORD");
                var.password.put(nameTestcase, password != null ? password : "");

                String deviceId = resultSet.getString("DEVICE_ID");
                var.device_id.put(nameTestcase, deviceId != null ? deviceId : "");

                String osType = resultSet.getString("OS_TYPE");
                var.os_type.put(nameTestcase, osType != null ? osType : "");

                String deviceInfo = resultSet.getString("DEVICE_INFO");
                var.device_info.put(nameTestcase, deviceInfo != null ? deviceInfo : "");

                String osVersion = resultSet.getString("OS_VERSION");
                var.os_version.put(nameTestcase, osVersion != null ? osVersion : "");

                String jailbreakFlag = resultSet.getString("JAILBREAK_FLAG");
                var.jailbreak_flag.put(nameTestcase, jailbreakFlag != null ? jailbreakFlag : "");
            }
            // Get metadata to dynamically retrieve column names and count
        } catch (ClassNotFoundException e) {
            System.out.println("Oracle JDBC Driver not found");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Connection or query failed");
            e.printStackTrace();
        } finally {
            // Close the resources
            try {
                if (resultSet != null) resultSet.close();
                if (statement != null) statement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


    }
}




