package repository.DBRepo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import Module.HasId;
import repository.Repository;

public abstract class DBRepository<T extends HasId> implements Repository<T>, AutoCloseable {
    protected Connection connection;
    public DBRepository(String dbUrl) {
        try {
            connection = DriverManager.getConnection(dbUrl);

    }   catch (SQLException e) {
            throw new RuntimeException(e);
    }
    }
    @Override
    public void close() throws Exception {
        connection.close();
    }
}
