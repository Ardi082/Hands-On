import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class ReadingTextFile {

    public static void main(String[] args) {

        Path path = Paths.get("employees.txt");
        Path copyPath = Paths.get("copy_employees.txt");

        // Mengecek apakah file ditemukan
        if (Files.notExists(path)) {
            System.out.println("File employees.txt tidak ditemukan!");
            return;
        }

        // Menyimpan data ke ArrayList
        ArrayList<String> employees = new ArrayList<>();

        try (BufferedReader br = Files.newBufferedReader(
                path, StandardCharsets.UTF_8)) {

            String line;

            // Membaca file baris demi baris
            while ((line = br.readLine()) != null) {
                employees.add(line);
            }

            // Menampilkan data karyawan
            System.out.println("Daftar Karyawan:");

            for (String employee : employees) {
                System.out.println(employee);
            }

            // Menulis data ke file baru
            Files.write(copyPath, employees, StandardCharsets.UTF_8);

            System.out.println("--------------------------");
            System.out.println("Data berhasil disalin ke copy_employees.txt");

        } catch (IOException e) {
            System.out.println("Terjadi kesalahan: " + e.getMessage());
        }
    }
}