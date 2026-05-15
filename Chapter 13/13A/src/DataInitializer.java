import java.sql.Connection;
import java.sql.Statement;

public class DataInitializer {

    public static void fillDatabase() {

        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement()) {

            stmt.executeUpdate("""
                INSERT INTO ProductGroups(name)
                VALUES
                ('Телефоны'),
                ('Телевизоры'),
                ('Ноутбуки')
            """);

            stmt.executeUpdate("""
                INSERT INTO ParameterGroups(name)
                VALUES
                ('Размеры'),
                ('Экран'),
                ('Производительность')
            """);

            stmt.executeUpdate("""
                INSERT INTO Parameters(name, unit)
                VALUES
                ('Высота', 'см'),
                ('Ширина', 'см'),
                ('Диагональ', 'дюймы'),
                ('Оперативная память', 'ГБ'),
                ('Процессор', '')
            """);

            stmt.executeUpdate("""
                INSERT INTO ParameterGroup_Parameter
                VALUES
                (1, 1),
                (1, 2),
                (2, 3),
                (3, 4),
                (3, 5)
            """);

            stmt.executeUpdate("""
                INSERT INTO ProductGroup_ParameterGroup
                VALUES
                (1, 1),
                (1, 2),
                (1, 3),

                (2, 2),

                (3, 1),
                (3, 2),
                (3, 3)
            """);

            stmt.executeUpdate("""
                INSERT INTO Products(name, description, release_date, group_id)
                VALUES
                ('iPhone 15', 'Смартфон Apple', '2025-01-01', 1),

                ('Samsung Galaxy S25', 'Флагман Samsung', '2025-02-10', 1),

                ('Samsung TV', 'Телевизор Samsung 4K', '2024-10-10', 2),

                ('LG OLED TV', 'OLED телевизор LG', '2025-03-15', 2),

                ('MacBook Pro', 'Ноутбук Apple', '2025-01-20', 3),

                ('ASUS ROG', 'Игровой ноутбук', '2025-04-01', 3)
            """);

            stmt.executeUpdate("""
                INSERT INTO ProductParameters
                VALUES

                -- iPhone 15
                (1, 1, '15'),
                (1, 2, '7'),
                (1, 3, '6.1'),
                (1, 4, '8'),
                (1, 5, 'A17'),

                -- Samsung Galaxy
                (2, 1, '16'),
                (2, 2, '7.5'),
                (2, 3, '6.8'),
                (2, 4, '12'),
                (2, 5, 'Snapdragon 8'),

                -- Samsung TV
                (3, 3, '55'),

                -- LG OLED
                (4, 3, '65'),

                -- MacBook
                (5, 1, '1.5'),
                (5, 2, '35'),
                (5, 3, '14'),
                (5, 4, '16'),
                (5, 5, 'M3 Pro'),

                -- ASUS ROG
                (6, 1, '2'),
                (6, 2, '36'),
                (6, 3, '17'),
                (6, 4, '32'),
                (6, 5, 'Intel i9')
            """);

            System.out.println("Тестовые данные добавлены!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}