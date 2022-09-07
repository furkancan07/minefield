import java.util.Random;
import java.util.Scanner;

public class MayinTarlasi {
    /*
     * Oyun metin tabanlıdır.
     * Çift boyutlu diziler üzerinden oynanmalı ve MineSweeper sınıfı içerisinde
     * tasarlanmalı.
     * Matris boyutunu yani satır ve sütun sayısını kullanıcı belirlemeli.
     * Diziye ait eleman sayısının çeyreği (elemanSayisi / 4) kadar rastgele mayın
     * yerleştirilmeli. Örneğin dizi 4x3 boyutunda ise eleman sayısı (satırSayısı *
     * sütunSayısı) formülü ile hesaplanmalı ve boyutu 12 olmalı. Bu durumda mayın
     * sayısı 12 / 4 = 3 adet olmalıdır. (ipucu : bu mayınların konumlarını tutacak
     * ikinci bir dizi oluşturabilirsiniz.)
     * Kullanıcı matris üzerinden bir nokta seçmeli. Nokta seçimi için satır ve
     * sütun değerlerini girmeli.
     * Seçilen noktanın dizinin sınırları içerisinde olup olmadığını kontrol
     * edilmeli ve koşul sağlanmazsa tekrar nokta istenmeli.
     * Kullanıcının girdiği noktada mayın var ise oyunu kaybetmeli.
     * Mayın yok ise, ilgili noktaya değen tüm konumlarına bakılmalı (sağı, solu,
     * yukarısı, aşağısı, sol üst çapraz, sağ üst çapraz, sağ alt çapraz, sol alt
     * çapraz) ve etrafındaki mayınların sayısının toplamı ilgili noktaya yazılmalı.
     * Noktaya değen herhangi bir mayın yok ise "0" değeri atanmalı.
     * Kullanıcı hiç bir mayına basmadan tüm noktaları seçebilirse oyunu kazanmalı.
     */
    Scanner scan = new Scanner(System.in);
    Random rand = new Random();
    int rowNumber, colNumber;
    String[][] map;
    int[][] board;
    int mayinSayisi;

    MayinTarlasi(int rowNumber, int colNumber) {
        this.rowNumber = rowNumber;
        this.colNumber = colNumber;
        this.map = new String[rowNumber][colNumber];
        this.board = new int[rowNumber][colNumber];
        this.mayinSayisi = (rowNumber * colNumber) / 4;

    }

    public void run() {
        int dogru = 0;
        oyunuHazirla();
        System.out.println("--------------");
        while (true) {
            printMap(board);
            System.out.print("satir gir: ");
            int satir = scan.nextInt();
            System.out.print("sütun gir: ");
            int sütun = scan.nextInt();
            if (map[satir][sütun] != "*") {
                check(satir, sütun);
                dogru++;
                if (dogru == (mayinSayisi * 4 - mayinSayisi)) {
                    System.out.println("Tebrikler Oyunu Kazandiniz :)");
                    break;
                }
            } else {
                System.out.println("Game Over");
                break;
            }

        }
    }

    public void check(int r, int c) {
        if (map[r][c] == "-") {
            if ((c < colNumber - 1) && map[r][c + 1] == "*") {
                board[r][c]++;
            }
            if ((r < rowNumber - 1) && map[r + 1][c] == "*") {
                board[r][c]++;
            }
            if (r > 0 && map[r - 1][c] == "*") {
                board[r][c]++;
            }
            if (c > 0 && map[r][c - 1] == "*") {
                board[r][c]++;
            }

            if (board[r][c] == 0) {
                board[r][c] = -2;
            }

        }

    }

    public void oyunuHazirla() {
        int row, col;
        int say = 0;

        while (say < mayinSayisi) {
            row = rand.nextInt(rowNumber);
            col = rand.nextInt(colNumber);
            if (map[row][col] != "*") {
                map[row][col] = "*";
                say++;
            }
        }
        int i, j;
        for (i = 0; i < map.length; i++) {
            for (j = 0; j < map[i].length; j++) {
                if (map[i][j] != "*") {
                    map[i][j] = "-";

                }
                System.out.print(map[i][j] + " ");
            }
            System.out.println();

        }

    }

    public void printMap(int[][] arr) {
        int i, j;
        for (i = 0; i < arr.length; i++) {
            for (j = 0; j < arr[i].length; j++) {

                System.out.print(arr[i][j] + " ");
            }
            System.out.println();

        }
    }
}
