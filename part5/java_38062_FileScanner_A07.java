import java.io.File;
import java.util.Scanner;

public class java_38062_FileScanner_A07 {
    public static void main(String[] args) {
        File directory = new File("path_to_directory");
        File[] listOfFiles = directory.listFiles();

        if (listOfFiles != null) {
            for (File file : listOfFiles) {
                if (file.isFile()) {
                    System.out.println("File: " + file.getName());
                    Scanner scanner = new Scanner(file);
                    while (scanner.hasNextLine()) {
                        System.out.println("Content: " + scanner.nextLine());
                    }
                    scanner.close();
                }
            }
        }
    }
}