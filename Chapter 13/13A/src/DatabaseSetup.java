import java.sql.Connection;
import java.sql.Statement;

public class DatabaseSetup {

    public static void createTables() {

        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement()) {

            stmt.execute("""
                CREATE TABLE IF NOT EXISTS ProductGroups (
                    id INTEGER PRIMARY KEY AUTOINCREMENT,
                    name TEXT NOT NULL
                )
            """);

            stmt.execute("""
                CREATE TABLE IF NOT EXISTS ParameterGroups (
                    id INTEGER PRIMARY KEY AUTOINCREMENT,
                    name TEXT NOT NULL
                )
            """);

            stmt.execute("""
                CREATE TABLE IF NOT EXISTS Parameters (
                    id INTEGER PRIMARY KEY AUTOINCREMENT,
                    name TEXT NOT NULL,
                    unit TEXT
                )
            """);

            stmt.execute("""
                CREATE TABLE IF NOT EXISTS Products (
                    id INTEGER PRIMARY KEY AUTOINCREMENT,
                    name TEXT NOT NULL,
                    description TEXT,
                    release_date TEXT,
                    group_id INTEGER,
                    FOREIGN KEY(group_id) REFERENCES ProductGroups(id)
                )
            """);

            stmt.execute("""
                CREATE TABLE IF NOT EXISTS ProductGroup_ParameterGroup (
                    product_group_id INTEGER,
                    parameter_group_id INTEGER
                )
            """);

            stmt.execute("""
                CREATE TABLE IF NOT EXISTS ParameterGroup_Parameter (
                    parameter_group_id INTEGER,
                    parameter_id INTEGER
                )
            """);

            stmt.execute("""
                CREATE TABLE IF NOT EXISTS ProductParameters (
                    product_id INTEGER,
                    parameter_id INTEGER,
                    value TEXT
                )
            """);

            System.out.println("Таблицы созданы!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}