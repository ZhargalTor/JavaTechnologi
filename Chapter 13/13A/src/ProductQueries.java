import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ProductQueries {

    // Параметры группы продукции
    public static void showParametersForGroup(int groupId) {

        String sql = """
            SELECT Parameters.name
            FROM Parameters
            JOIN ParameterGroup_Parameter pgp
                ON Parameters.id = pgp.parameter_id
            JOIN ProductGroup_ParameterGroup pg
                ON pgp.parameter_group_id = pg.parameter_group_id
            WHERE pg.product_group_id = ?
        """;

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, groupId);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                System.out.println(rs.getString("name"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Продукция без заданного параметра
    public static void showProductsWithoutParameter(int parameterId) {

        String sql = """
            SELECT name
            FROM Products
            WHERE id NOT IN (
                SELECT product_id
                FROM ProductParameters
                WHERE parameter_id = ?
            )
        """;

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, parameterId);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                System.out.println(rs.getString("name"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Продукция по группе
    public static void showProductsByGroup(int groupId) {

        String sql = """
            SELECT *
            FROM Products
            WHERE group_id = ?
        """;

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, groupId);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                System.out.println(
                        rs.getString("name") + " | " +
                                rs.getString("description")
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Продукция со всеми параметрами
    public static void showProductDetails() {

        String sql = """
            SELECT Products.name AS product,
                   Parameters.name AS parameter,
                   ProductParameters.value
            FROM ProductParameters
            JOIN Products
                ON Products.id = ProductParameters.product_id
            JOIN Parameters
                ON Parameters.id = ProductParameters.parameter_id
        """;

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                System.out.println(
                        rs.getString("product") +
                                " | " +
                                rs.getString("parameter") +
                                " = " +
                                rs.getString("value")
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}