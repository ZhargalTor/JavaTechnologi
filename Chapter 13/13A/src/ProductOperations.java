import java.sql.Connection;
import java.sql.PreparedStatement;

public class ProductOperations {

    public static void addProduct(
            String name,
            String description,
            String date,
            int groupId) {

        String sql = """
            INSERT INTO Products(name, description, release_date, group_id)
            VALUES (?, ?, ?, ?)
        """;

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, name);
            ps.setString(2, description);
            ps.setString(3, date);
            ps.setInt(4, groupId);

            ps.executeUpdate();

            System.out.println("Продукт добавлен!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void deleteProductsWithParameter(int parameterId) {

        String sql = """
            DELETE FROM Products
            WHERE id IN (
                SELECT product_id
                FROM ProductParameters
                WHERE parameter_id = ?
            )
        """;

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, parameterId);

            ps.executeUpdate();

            System.out.println("Продукты удалены!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void moveParameterGroup(
            int parameterGroupId,
            int oldGroupId,
            int newGroupId) {

        String deleteSql = """
            DELETE FROM ProductGroup_ParameterGroup
            WHERE product_group_id = ?
            AND parameter_group_id = ?
        """;

        String insertSql = """
            INSERT INTO ProductGroup_ParameterGroup
            VALUES (?, ?)
        """;

        try (Connection conn = DBConnection.getConnection()) {

            PreparedStatement ps1 = conn.prepareStatement(deleteSql);
            ps1.setInt(1, oldGroupId);
            ps1.setInt(2, parameterGroupId);
            ps1.executeUpdate();

            PreparedStatement ps2 = conn.prepareStatement(insertSql);
            ps2.setInt(1, newGroupId);
            ps2.setInt(2, parameterGroupId);
            ps2.executeUpdate();

            System.out.println("Группа параметров перемещена!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}