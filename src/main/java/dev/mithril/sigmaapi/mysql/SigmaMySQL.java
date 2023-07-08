package dev.mithril.sigmaapi.mysql;

import com.mysql.cj.jdbc.MysqlConnectionPoolDataSource;
import com.mysql.cj.jdbc.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SigmaMySQL {

    private MysqlDataSource dataSource;

    private Connection connection;

    public SigmaMySQL(String host, int port, String databaseName, String user, String password) throws SQLException {
        dataSource = new MysqlConnectionPoolDataSource();

        dataSource.setServerName(host);
        dataSource.setPortNumber(port);
        dataSource.setDatabaseName(databaseName);
        dataSource.setUser(user);
        dataSource.setPassword(password);

        testDataSource(dataSource);

        connection = dataSource.getConnection();
    }



    public void testDataSource(DataSource dataSource) throws SQLException {
        try (Connection conn = dataSource.getConnection()) {
            if (!conn.isValid(1)) {
                throw new SQLException("Could not establish database connection.");
            }
        }
    }


    public MysqlDataSource getDataSource() {
        return dataSource;
    }

    public Connection getConnection() {
        return connection;
    }
}
