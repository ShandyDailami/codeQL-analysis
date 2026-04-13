import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class java_19091_FileScanner_A03 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String path = scanner.nextLine();
        File file = new File(path);

        if (file.isDirectory()) {
            String[] list = file.list();
            Arrays.sort(list);
            for (String string : list) {
                System.out.println(string);
            }
        } else {
            System.out.println("Not a directory");
        }

        scanner.close();
    }
}