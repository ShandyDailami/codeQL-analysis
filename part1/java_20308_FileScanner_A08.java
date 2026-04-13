import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_20308_FileScanner_A08 {
    public static void main(String[] args) {
        File file = new File(".");
        long lastModified = file.lastModified();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory:");
        String dir = scanner.nextLine();

        File dirFile = new File(dir);

        if (dirFile.exists()) {
            File[] txtFiles = dirFile.listFiles((dir, name) -> name.endsWith(".txt"));

            for (File txtFile : txtFiles) {
                long fileModified = txtFile.lastModified();

                if (fileModified > lastModified) {
                    System.out.println("File: " + txtFile.getName() + ", last modified: " + fileModified);
                    lastModified = fileModified;
                }
            }
        } else {
            System.out.println("Directory does not exist!");
        }

        scanner.close();
    }
}