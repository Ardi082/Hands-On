import java.io.IOException;
import java.nio.file.*;
import java.util.*;

// Generic Class Produk
class Produk<T, U, V> {
    private T nama;
    private U harga;
    private V stok;

    public Produk(T nama, U harga, V stok) {
        this.nama = nama;
        this.harga = harga;
        this.stok = stok;
    }

    @Override
    public String toString() {
        return nama + "," + harga + "," + stok;
    }
}

public class ProdukWriterNew {

    public static void main(String[] args) {

        // Membuat daftar produk
        List<Produk<String, Double, Integer>> produkList = new ArrayList<>();

        produkList.add(new Produk<>("Laptop", 1.5E7, 10));
        produkList.add(new Produk<>("Mouse", 150000.0, 50));
        produkList.add(new Produk<>("Keyboard", 350000.0, 25));

        Path filePath = Paths.get("produk_output.txt");

        try {
            // Menyimpan data produk ke file
            List<String> lines = new ArrayList<>();

            for (Produk<String, Double, Integer> p : produkList) {
                lines.add(p.toString());
            }

            Files.write(filePath, lines);

            System.out.println("Data produk berhasil disimpan menggunakan NIO.2");

            // Membaca kembali isi file
            List<String> hasil = Files.readAllLines(filePath);

            System.out.println("Isi file:");

            for (String line : hasil) {
                System.out.println(line);
            }

        } catch (IOException e) {
            System.out.println("Gagal menyimpan file: " + e.getMessage());
        }
    }
}