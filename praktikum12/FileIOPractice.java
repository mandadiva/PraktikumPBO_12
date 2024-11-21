package praktikum12;

import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;

public class FileIOPractice {
    public static void main(String[] args) {
        String filePath = "data.txt";
        // Menulis data ke file
        try (FileWriter writer = new FileWriter(filePath)) {
            writer.write("Belajar File I/O di java!\n");
            writer.write("Pemrograman Berorientasi Objek.\n");
            System.out.println("Data berhasil ditulis ke file: " + filePath);
        } catch (IOException e) {
            System.out.println("Terjadi kesalahan saat menulis file.");
            e.printStackTrace();
        }
        // Membaca data dari file
        try (FileReader reader = new FileReader(filePath)) {
            int character;
            System.out.println("\nIsi file:");
            while ((character = reader.read()) != -1) {
                System.out.print((char) character);  // Menggunakan print() agar karakter tampil horizontal
            }
            System.out.println();  // Untuk memastikan ada baris baru setelah output
        } catch (IOException e) {
            System.out.println("Terjadi kesalahan saat membaca file.");
            e.printStackTrace();
        }
    }
}
