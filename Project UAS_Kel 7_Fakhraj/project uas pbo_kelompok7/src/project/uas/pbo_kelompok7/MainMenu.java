package project.uas.pbo_kelompok7;
import java.sql.Date;
import java.util.Scanner;

public class MainMenu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Karyawan karyawan = new Karyawan();
        Departemen departemen = new Departemen();
        Absensi absensi = new Absensi();

        while (true) {
            System.out.println("=============================");
            System.out.println("Menu:");
            System.out.println("1. Tambah Karyawan");
            System.out.println("2. Lihat Karyawan");
            System.out.println("3. Tambah Departemen");
            System.out.println("4. Lihat Departemen");
            System.out.println("5. Tambah Absensi");
            System.out.println("6. Lihat Absensi");
            System.out.println("7. Keluar");
            System.out.println("=============================");
            System.out.print("Pilih menu: ");
            int pilihan = scanner.nextInt();

            switch (pilihan) {
                case 1:
                    System.out.print("Nama: ");
                    String nama = scanner.nextLine();
                    System.out.print("NIP: ");
                    String nip = scanner.nextLine();
                    System.out.print("Departemen: ");
                    String departemenNama = scanner.nextLine();
                    karyawan.addKaryawan(nama, nip, departemenNama);
                    break;
                case 2:
                    System.out.println("=============================");
                    karyawan.getAllKaryawan();
                    break;
                case 3:
                    System.out.print("Nama Departemen: ");
                    String namaDepartemen = scanner.nextLine();
                    System.out.print("Manager: ");
                    String manager = scanner.nextLine();
                    departemen.addDepartemen(namaDepartemen, manager);
                    break;
                case 4:
                    departemen.getAllDepartemen();
                    break;
                case 5:
                    System.out.print("ID Karyawan: ");
                    int idKaryawan = scanner.nextInt();
                    System.out.print("ID Departemen: ");
                    int idDepartemen = scanner.nextInt();
                    System.out.print("Tanggal (yyyy-mm-dd): ");
                    String tanggal = scanner.next();
                    System.out.print("Status: ");
                    String status = scanner.next();
                    absensi.addAbsensi(idKaryawan, idDepartemen, Date.valueOf(tanggal), status);
                    break;
                case 6:
                    absensi.getAllAbsensi();
                    break;
                case 7:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Pilihan tidak valid");
            }
        }
    }
}

