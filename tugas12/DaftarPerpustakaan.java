package tugas12;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DaftarPerpustakaan {
    // Nama file untuk penyimpanan data dalam format teks
    private static final String TEXT_FILE = "buku.txt";
    // Nama file untuk penyimpanan data dalam format serialisasi
    private static final String SERIAL_FILE = "buku.ser";
    // List untuk menyimpan objek Buku
    private static List<Buku> bukuList = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Tampilkan menu utama
        while (true) {
            System.out.println("\nDaftar Perpustakaan:");
            System.out.println("1. Tambah Buku");
            System.out.println("2. Simpan Buku ke File Teks");
            System.out.println("3. Simpan Buku ke File Serialisasi");
            System.out.println("4. Tampilkan Semua Buku");
            System.out.println("5. Keluar");
            System.out.print("Pilih menu (dalam angka): ");
            int menu = scanner.nextInt(); // Membaca input menu dari pengguna
            scanner.nextLine(); // Konsumsi newline

            switch (menu) {
                case 1 -> tambahBuku(scanner);
                case 2 -> simpanFileTeks();
                case 3 -> simpanFileSerial();
                case 4 -> tampilkanBuku();
                case 5 -> {
                    System.out.println("Keluar dari sistem perpustakaan.");
                    scanner.close();
                    return;
                }
                default -> System.out.println("Pilihan tidak valid.");
            }
        }
    }

    // Method untuk menambahkan buku ke sistem
    private static void tambahBuku(Scanner scanner) {
        System.out.print("Masukkan judul buku: ");
        String judul = scanner.nextLine();
        System.out.print("Masukkan nama pengarang: ");
        String pengarang = scanner.nextLine();
        System.out.print("Masukkan tahun terbit: ");
        int tahunTerbit = scanner.nextInt();

        bukuList.add(new Buku(judul, pengarang, tahunTerbit));
        System.out.println("Buku berhasil ditambahkan ke sistem.");
    }

    // Method untuk menyimpan file dalam format teks
    private static void simpanFileTeks() {
        try (FileWriter writer = new FileWriter(TEXT_FILE)) {
            for (Buku buku : bukuList) {
                writer.write(buku.toString() + "\n");
            }
            System.out.println("Data buku berhasil disimpan ke file teks.");
        } catch (IOException e) {
            System.out.println("Terjadi kesalahan saat menyimpan file teks.");
            e.printStackTrace();
        }
    }

    // Method untuk menyimpan file dalam format serial
    private static void simpanFileSerial() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(SERIAL_FILE))) {
            oos.writeObject(bukuList);
            System.out.println("Buku berhasil disimpan ke file serial.");
        } catch (IOException e) {
            System.out.println("Terjadi kesalahan saat menyimpan file serial.");
            e.printStackTrace();
        }
    }

    // Method untuk menampilkan daftar buku
    private static void tampilkanBuku() {
        if (bukuList.isEmpty()) {
            System.out.println("Tidak ada buku dalam sistem.");
        } else {
            System.out.println("\nDaftar Buku:");
            for (Buku buku : bukuList) {
                buku.informasi();
            }
        }
    }
}
