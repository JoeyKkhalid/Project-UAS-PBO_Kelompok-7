package project.uas.pbo_kelompok7;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;

public class Absensi {
    public void addAbsensi(int idKaryawan, int idDepartemen, Date tanggal, String status) {
        String sql = "INSERT INTO Absensi (ID_Karyawan, ID_Departemen, Tanggal, Status) VALUES (?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, idKaryawan);
            pstmt.setInt(2, idDepartemen);
            pstmt.setDate(3, tanggal);
            pstmt.setString(4, status);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void getAllAbsensi() {
        String sql = "SELECT * FROM Absensi";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("ID"));
                System.out.println("ID Karyawan: " + rs.getInt("ID_Karyawan"));
                System.out.println("ID Departemen: " + rs.getInt("ID_Departemen"));
                System.out.println("Tanggal: " + rs.getDate("Tanggal"));
                System.out.println("Status: " + rs.getString("Status"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
