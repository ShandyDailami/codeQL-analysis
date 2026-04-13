import java.io.File;
import java.util.Scanner;

public class java_18631_FileScanner_A07 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String path = scanner.nextLine();

        File file = new File(path);

        if (file.exists()) {
            if (file.isDirectory()) {
                System.out.println("Directory Found: " + file.getAbsolutePath());
                File[] files = file.listFiles();

                if (files != null) {
                    for (File f : files) {
                        if (f.isFile()) {
                            System.out.println("File Found: " + f.getAbsolutePath());
                            readFile(f);
                        } else if (f.isDirectory()) {
                            System.out.println("Directory Found: " + f.getAbsolutePath());
                            listDirectory(f);
                        }
                    }
                }
            } else {
                System.out.println("File Found: " + file.getAbsolutePath());
                readFile(file);
            }
        } else {
            System.out.println("Directory not found: " + path);
        }

        scanner.close();
    }

    private static void readFile(File file) {
        // This is a placeholder for the security-sensitive operation. You need to implement it.
        System.out.println("Reading file: " + file.getAbsolutePath());
    }

    private static void listDirectory(File dir) {
        // This is a placeholder for the security-sensitive operation. You need to implement it.
        System.out.println("Listing directory: " + dir.getAbsolutePath());
    }
}