import java.io.File;
import java.util.Scanner;

public class java_41590_FileScanner_A08 {
    public static void main(String[] args) {
        // Scan current directory
        File dir = new File(".");
        String[] list = dir.list();

        if (list != null) {
            for (String fileName : list) {
                File file = new File(fileName);

                // Only process .txt files
                if (file.isFile() && fileName.endsWith(".txt")) {
                    Scanner scanner = new Scanner(file);

                    System.out.println("Content of " + fileName + ":");
                    while (scanner.hasNextLine()) {
                        System.out.println(scanner.nextLine());
                    }
                    scanner.close();
                }
            }
        }
    }
}