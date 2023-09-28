// Nama : Retno Pinka Pratiwi 
// NIM  : L0122137

// import packages yang akan digunakan
import java.util.ArrayList;
import java.util.Scanner;

public class PPBO_03_L0122137 {
  // ArrayList untuk menampung data buah dan sayur.
  private ArrayList<String> arraySayur = new ArrayList<String>();
  private ArrayList<String> arrayBuah = new ArrayList<String>();

  public static void main(String[] args) {
    PPBO_03_L0122137 buahSayur = new PPBO_03_L0122137();
    Scanner scanner = new Scanner(System.in);

    // mencetak menu dengan perulangan while agar selalu muncul setiap setelah
    // menyelesaikan tugas sebuah method
    while (true) {
      // inisialisasi opsi dengan hasil dari method printMenu
      int opsi = buahSayur.printMenu(scanner);

      if (opsi == 1) {
        // Opsi 1 untuk menambahkan buah atau sayur ke dalam array
        System.out.println("Tambah Buah atau Sayur");
        // petunjuk singkat untuk pengguna
        System.out.println("Petunjuk:");
        System.out.println(
            "- Untuk menambahkan buah ke dalam daftar, \nawali penulisan dengan buah kemudian diikuti dengan nama buah. \nContoh: buah mangga");
        System.out.println(
            "- Untuk mengambahkan sayur ke dalam daftar, \nawali penulisan dengan kata sayur kemudian diikuti dengan nama sayur. \nContoh: sayur bayam\n");

        // memasukkan nama buah atau sayur yang akan dimasukkan dalam array
        System.out.println("Masukkan nama buah atau sayur yang ingin ditambahkan");
        System.out.print(">> ");
        String input = scanner.nextLine();

        // memanggil method checkInput untuk mengecek input apakah termasuk buah atau
        // sayur dengan parameter inputan yang telah ditambahkan sebelumnya
        buahSayur.checkInput(input);

      } else if (opsi == 2) {
        // memanggil method printBuah untuk mencetak daftar buah yang tersimpan dalam
        // arrayBuah
        buahSayur.printBuah();
      } else if (opsi == 3) {
        // memanggil method printSayur untuk mencetak daftar sayur yang tersimpan dalam
        // arraySayur
        buahSayur.printSayur();
      } else {
        // ketika input yang dimasukkan selain angka 1, 2, dan 3, maka program akan
        // berhenti.
        System.out.println("Keluar Program...");
        break;
      }
    }
    scanner.close();
  }

  // method untuk mencetak menu dengan parameter scanner yang digunakan untuk
  // meminta inputan serta mengembalikan sebuah integer yang merupakan kode angka
  // dari menu yang dimasukkan oleh pengguna
  private int printMenu(Scanner scanner) {
    System.out.println("Program Pencatat Buah dan Sayuran");
    System.out.println("1. Tambah buah/sayur");
    System.out.println("2. Lihat daftar buah");
    System.out.println("3. Lihat daftar sayur");
    System.out.println("4. Keluar dari program");

    System.out.print(">> ");
    int opsi = scanner.nextInt();
    scanner.nextLine();

    return opsi;
  }

  /*
   * Method untuk mengecek sebuah inputan
   * Program ini adalah sebuah program yang dapat mengecek kata awal.
   * Untuk memasukkan buah ke dalam arrayBuah, pengguna harus memasukkan kata
   * "buah" setelah itu diikuti dengan nama buah itu sendiri
   * contoh:
   * buah mangga (valid)
   * mangga (tidak valid)
   * 
   * Sama halnya untuk memasukkan sayur juga harus diawali dengan kata "sayur"
   * lalu diikuti dengan nama sayurnya.
   * contoh:
   * sayur bayam (valid)
   * bayam (tidak valid)
   * 
   * ketika tidak memasukkan kata sayur atau bayam, maka akan menampilkan pesan
   * "Input harus mengandung kata Sayur atau buah."
   */
  private void checkInput(String input) {
    /* mengecek apakah ada kata "sayur" di inputan yang dimasukkan */
    if (input.toLowerCase().contains("sayur")) {
      String[] arrayInputSayur = input.split(" ", 2);

      /*
       * Ketika inputan mengandung kata "sayur" namun sayur tidak berada di awal kata
       * (array index ke-0), maka tidak dapat dimasukkan dalam array
       * contoh:
       * sayur bayam (valid)
       * bayam sayur (tidak valid)
       */
      if (arrayInputSayur[0].toLowerCase().equals("sayur")) {
        // array ke-1 yang berisi nama sayur diisikan ke variabel inputAddSayur
        String inputAddSayur = arrayInputSayur[1];
        // memanggil method addSayur dengan parameter inputAddSayur untuk menambahkan
        // sayur ke dalam arraylist
        addSayur(inputAddSayur);
        System.out.printf("%s berhasil ditambahkan ke daftar.", inputAddSayur);
      } else {
        // ketika kata "sayur" tidak berada di array index ke-0
        System.out.printf("Input yang dimasukkan tidak valid!\n");
      }

      /* mengecek apakah ada kata "buah" di inputan yang dimasukkan */
    } else if (input.toLowerCase().contains("buah")) {
      String[] arrayInputBuah = input.split(" ", 2);

      /*
       * Ketika inputan mengandung kata "buah" namun buah tidak berada di awal kata
       * (array index ke-0), maka tidak dapat dimasukkan dalam array
       * contoh:
       * buah mangga (valid)
       * mangga buah (tidak valid)
       */
      if (arrayInputBuah[0].toLowerCase().equals("buah")) {
        // array ke-1 yang berisi nama buah diisikan ke variabel inputAddBuah
        String inputAddBuah = arrayInputBuah[1];
        // memanggil method addBuah dengan parameter inputAddBuah untuk menambahkan nama
        // buah ke dalam arraylist
        addBuah(inputAddBuah);
        System.out.printf("%s berhasil ditambahkan ke daftar buah.\n", inputAddBuah);
      } else {
        // ketika kata "buah" tidak berada di array index ke-0
        System.out.println("Input yang dimasukkan tidak valid!\n");
      }
    } else {
      // ketika input yang dimasukkan tidak mengandung kata "buah" atau "sayur"
      System.out.println("Input harus mengandung kata Sayur atau buah.");
    }
  }

  // method untuk memasukkan nama buah ke dalam Array List
  private void addBuah(String input) {
    this.arrayBuah.add(input);
  }

  // method untuk memasukkan nama sayur ke dalam Array List
  private void addSayur(String input) {
    this.arraySayur.add(input);
  }

  // method untuk mencetak daftar buah yang ada di dalam arrayList
  private void printBuah() {
    if (arrayBuah.isEmpty()) {
      // ketika tidak ada data di dalam arraylist
      System.out.println("Tidak ada data!\n");
    } else {
      // mencetak daftar buah dengan bentuk tabel agar mudah dibaca
      System.out.println("---------------------------");
      System.out.printf("| %-5s | %-15s |\n", "No.", "Nama Buah");
      System.out.println("---------------------------");
      // mengambil nama buah di dalam arraylist dengan perulangan
      for (int i = 0; i < arrayBuah.size(); i++) {
        System.out.printf("| %-5d | %-15s |\n", i, arrayBuah.get(i));
      }
      System.out.println("---------------------------");
    }
  }

  // method untuk mencetak daftar sayur yang ada di dalam arrayList
  private void printSayur() {
    // ketika tidak ada data di dalam arraylist
    if (arraySayur.isEmpty()) {
      System.out.println("Tidak ada data!\n");
    } else {
      // mencetak daftar sayur dengan bentuk tabel agar mudah dibaca
      System.out.println("---------------------------");
      System.out.printf("| %-5s | %-15s |\n", "No.", "Nama Buah");
      System.out.println("---------------------------");
      // mengambil nama buah di dalam arraylist dengan perulangan
      for (int i = 0; i < arraySayur.size(); i++) {
        System.out.printf("| %-5d | %-15s |\n", i, arraySayur.get(i));
      }
      System.out.println("---------------------------");
    }
  }
}
