package project.uas.pbo_kelompok7;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Departemen {
    public void addDepartemen(String namaDepartemen, String manager) {
        String sql = "INSERT INTO Departemen (NamaDepartemen, Manager) VALUES (?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, namaDepartemen);
            pstmt.setString(2, manager);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void getAllDepartemen() {
        String sql = "SELECT * FROM Departemen";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("ID"));
                System.out.println("Nama Departemen: " + rs.getString("NamaDepartemen"));
                System.out.println("Manager: " + rs.getString("Manager"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
