package pe.edu.upeu.conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLiteConnection {

    private static SQLiteConnection instance;
    private Connection connection;

    private static final String DB_NAME = "infraccion14_db";
    private static final String DB_PATH = "data/" + DB_NAME;
    private static final String URL = "jdbc:sqlite:" + DB_PATH;

    private SQLiteConnection() {

        try {

            Class.forName("org.sqlite.JDBC");

            // MOSTRAR RUTA DE LA BD
            System.out.println("Base de datos usada:");
            System.out.println(URL);

            connection = DriverManager.getConnection(URL);

            connection.createStatement()
                    .execute("PRAGMA foreign_keys = ON;");

            // CREAR TABLA
            String sql = """
                    CREATE TABLE IF NOT EXISTS infraccion (
                        placa TEXT PRIMARY KEY,
                        infractor TEXT,
                        fecha TEXT,
                        tipo TEXT,
                        monto REAL,
                        estado TEXT
                    )
                    """;

            Statement st = connection.createStatement();
            st.execute(sql);

            System.out.println("Conexión a SQLite establecida.");

        } catch (SQLException e) {

            System.err.println("Error al conectar a SQLite: "
                    + e.getMessage());

        } catch (ClassNotFoundException e) {

            throw new RuntimeException(e);
        }
    }

    public static synchronized SQLiteConnection getInstance() {

        if (instance == null) {
            instance = new SQLiteConnection();
        }

        return instance;
    }

    public Connection getConnection() {
        return connection;
    }
}