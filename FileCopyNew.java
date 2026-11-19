import java.io.IOException;
import java.nio.file.*;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.ArrayList;

public class FileCopyNew {

    public static void main(String[] args) {

        Path source = Paths.get("report.txt");
        Path backup = Paths.get("backup/report.txt");
        Path logFile = Paths.get("log.txt");

        ArrayList<String> logs = new ArrayList<>();

        try {
            // Menulis isi laporan ke file
            Files.write(source,
                List.of("Report Generated", "Status: OK"),
                StandardCharsets.UTF_8);

            System.out.println("Laporan berhasil dibuat.");
            logs.add("Laporan berhasil dibuat.");

            // Mengecek apakah file sumber ditemukan
            if (Files.exists(source)) {

                // Membuat folder backup jika belum ada
                if (Files.notExists(backup.getParent())) {
                    Files.createDirectories(backup.getParent());
                }

                // Menyalin file ke folder backup
                Files.copy(source, backup,
                    StandardCopyOption.REPLACE_EXISTING);

                System.out.println("Backup berhasil dibuat.");
                logs.add("Backup berhasil dibuat.");

            } else {
                System.out.println("File report.txt tidak ditemukan.");
                logs.add("File report.txt tidak ditemukan.");
            }

        } catch (IOException e) {
            System.out.println("Terjadi kesalahan: " + e.getMessage());
            logs.add("Terjadi kesalahan: " + e.getMessage());

        } finally {
            // Menyimpan hasil operasi ke log.txt
            try {
                Files.write(logFile, logs,
                    StandardCharsets.UTF_8,
                    StandardOpenOption.CREATE,
                    StandardOpenOption.APPEND);

                System.out.println("Log berhasil disimpan ke log.txt.");

            } catch (IOException e) {
                System.out.println("Gagal menyimpan log: " + e.getMessage());
            }
        }
    }
}