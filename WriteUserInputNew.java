import java.io.*;
import java.nio.file.*;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class WriteUserInputNew {

    public static void main(String[] args) {

        DateTimeFormatter formatter =
            DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        try (
            Scanner sc = new Scanner(System.in);
            BufferedWriter bw = Files.newBufferedWriter(
                Paths.get("user_input.txt"),
                StandardCharsets.UTF_8
            )
        ) {

            System.out.println("Masukkan teks (ketik exit untuk selesai):");

            while (true) {

                System.out.print("Enter text: ");
                String text = sc.nextLine();

                // Berhenti jika pengguna mengetik exit
                if (text.equalsIgnoreCase("exit")) {
                    break;
                }

                // Menambahkan timestamp
                String timestamp = LocalDateTime.now().format(formatter);

                bw.write("[" + timestamp + "] " + text);
                bw.newLine();

                System.out.println("Data berhasil disimpan.");
            }

            System.out.println("Semua data berhasil disimpan!");

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}