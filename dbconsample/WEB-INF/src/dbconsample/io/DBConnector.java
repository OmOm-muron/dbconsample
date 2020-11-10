package dbconsample.io;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DBConnector implements AutoCloseable {
    public Connection connection;
    
    public DBConnector() throws NamingException, SQLException {
        try {
            setConnection();
        } catch(NamingException | SQLException e) {
            throw e;
        }
    }
    
    public Connection getConnection() {
        return this.connection;
    }
    
    public void setConnection() throws NamingException, SQLException {
        try {
            if (this.connection == null || this.connection.isClosed()) {
                InitialContext initCtx = new InitialContext();
                DataSource ds = (DataSource)initCtx.lookup("java:comp/env/jdbc/sample");
                this.connection = ds.getConnection();
            }
        } catch (NamingException | SQLException e) {
            this.connection = null;
            throw e;
        }
    }
    
    public void close() {
        if(this.connection != null) {
            try {
                this.connection.close();
            } catch(SQLException e) {
                this.connection = null;
            } finally {
                this.connection = null;
            }
        }
    }
    
    public void commit() throws SQLException {
        this.connection.commit();
    }
}
