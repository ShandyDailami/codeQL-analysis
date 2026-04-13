import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class java_22581_FileScanner_A03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the file name:");
        String filename = scanner.next();

        try {
            File file = new File(filename);

            if (file.exists()) {
                Scanner fileScanner = new Scanner(file);
                while (fileScanner.hasNextLine()) {
                    String line = fileScanner.nextLine();
                    if (line.contains("security")) {
                        System.out.println("Security sensitive operation found in the file: " + file.getPath());
                    }
                }
                fileScanner.close();
            } else {
                System.out.println("File does not exist.");
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }
    }
}