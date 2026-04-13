import java.io.File;
import java.util.Scanner;

public class java_16945_FileScanner_A01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the path to the directory: ");
        String path = scanner.nextLine();

        File file = new File(path);

        if (file.exists() && file.canRead()) {
            File[] files = file.listFiles();

            if (files != null) {
                for (File f : files) {
                    if (f.isFile()) {
                        System.out.println(f.getName());
                    }
                }
            }
        } else {
            System.out.println("Access denied for " + path);
        }

        scanner.close();
    }
}