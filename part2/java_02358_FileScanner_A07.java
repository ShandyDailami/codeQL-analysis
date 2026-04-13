import java.io.File;
import java.util.Scanner;

public class java_02358_FileScanner_A07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the directory path:");
        String path = scanner.nextLine();
        File file = new File(path);

        if (file.exists() && file.isDirectory()) {
            File[] files = file.listFiles();
            if (files != null) {
                for (File f : files) {
                    if (f.getName().endsWith(".auth")) { // assuming .auth files are security-sensitive
                        System.out.println("Found auth file: " + f.getName());
                    }
                }
            } else {
                System.out.println("Error: " + file.getName() + " is not a directory.");
            }
        } else {
            System.out.println("Error: " + file.getName() + " does not exist or is not a directory.");
        }

        scanner.close();
    }
}