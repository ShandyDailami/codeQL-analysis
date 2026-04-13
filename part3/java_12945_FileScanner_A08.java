import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_12945_FileScanner_A08 {
    public static void main(String[] args) {
        String pathToDirectory = "pathToDirectory";

        try {
            File dir = new File(pathToDirectory);

            // FileScanner will list all files and directories within the specified directory
            File[] files = dir.listFiles();

            for (File file : files) {
                if (file.isFile()) {
                    System.out.println("Reading file: " + file.getName());

                    // Use a Scanner to read the file
                    Scanner scanner = new Scanner(file);
                    while (scanner.hasNextLine()) {
                        System.out.println(scanner.nextLine());
                    }
                    scanner.close();
                }
            }

        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
            e.printStackTrace();
        }
    }
}