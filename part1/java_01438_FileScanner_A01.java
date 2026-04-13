import java.io.File;
import java.util.Scanner;

public class java_01438_FileScanner_A01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the directory path: ");
        String path = scanner.nextLine();

        File file = new File(path);

        if (file.exists()) {
            if (file.isDirectory()) {
                File[] files = file.listFiles();
                for (File f : files) {
                    if (f.isFile()) {
                        System.out.println(f.getName());
                    }
                }
            } else {
                System.out.println("Given path is not a directory.");
            }
        } else {
            System.out.println("Given path does not exist.");
        }

        scanner.close();
    }
}