import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_32559_FileScanner_A07 {
    public static void main(String[] args) throws FileNotFoundException {
        File directory = new File(".");
        File[] files = directory.listFiles();

        // Use a FileScanner to read files
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the name of a file:");
        String filename = scanner.nextLine();

        for (File file : files) {
            if (file.getName().equalsIgnoreCase(filename)) {
                Scanner fileScanner = new Scanner(file);
                while (fileScanner.hasNextLine()) {
                    String line = fileScanner.nextLine();
                    System.out.println(line);
                }
                fileScanner.close();
            }
        }

        scanner.close();
    }
}