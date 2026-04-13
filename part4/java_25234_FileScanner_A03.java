import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_25234_FileScanner_A03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the file extension to search for:");
        String extension = scanner.nextLine();

        File directory = new File(".");
        File[] foundFiles = directory.listFiles((dir, name) -> name.endsWith(extension));

        if (foundFiles != null) {
            for (File file : foundFiles) {
                try {
                    Scanner fileScanner = new Scanner(file);
                    while (fileScanner.hasNextLine()) {
                        String line = fileScanner.nextLine();
                        System.out.println(line);
                    }
                    fileScanner.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }

        scanner.close();
    }
}