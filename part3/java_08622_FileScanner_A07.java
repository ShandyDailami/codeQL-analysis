import java.io.File;
import java.util.Scanner;

public class java_08622_FileScanner_A07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String dirPath = scanner.nextLine();
        scanner.close();

        File file = new File(dirPath);
        if (file.exists()) {
            File[] files = file.listFiles();
            for (File f : files) {
                if (f.isFile()) {
                    if (f.getName().endsWith(".txt")) {
                        long length = f.length();
                        if (length < 10000) {
                            System.out.println("File: " + f.getName());
                            System.out.println("Size: " + length + " bytes");
                            System.out.println("----");
                        }
                    }
                } else if (f.isDirectory()) {
                    System.out.println("Directory: " + f.getName());
                }
            }
        } else {
            System.out.println("Directory not found: " + dirPath);
        }
    }
}