import java.io.File;
import java.util.Scanner;

public class java_29968_FileScanner_A01 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String path = scanner.nextLine();

        File file = new File(path);

        if (file.exists()) {
            if (file.isDirectory()) {
                File[] files = file.listFiles();
                if (files != null) {
                    for (File f : files) {
                        if (f.isFile()) {
                            System.out.println("File name: " + f.getName());
                        }
                    }
                }
            } else {
                System.out.println("Entered path is not a directory.");
            }
        } else {
            System.out.println("Entered path does not exist.");
        }
    }
}