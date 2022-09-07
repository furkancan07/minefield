import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        System.out.print("Mapin satir sayisini gir: ");
        int satir = scan.nextInt();
        System.out.print("Mapin sutun sayisini gir: ");
        int sütun = scan.nextInt();
        MayinTarlasi m = new MayinTarlasi(satir, sütun);
        m.run();
        scan.close();

    }
}
