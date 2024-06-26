package project.uas.pbo_kelompok7;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Karyawan {
    public void addKaryawan(String nama, String nip, String departemen) {
        String sql = "INSERT INTO Karyawan (Nama, NIP, Departemen) VALUES (?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, nama);
            pstmt.setString(2, nip);
            pstmt.setString(3, departemen);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void getAllKaryawan() {
        String sql = "SELECT * FROM Karyawan";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("ID"));
                System.out.println("Nama: " + rs.getString("Nama"));
                System.out.println("NIP: " + rs.getString("NIP"));
                System.out.println("Departemen: " + rs.getString("Departemen"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
