import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_28402_FileScanner_A03 {
    private static final String DIR_PATH = "src/main/resources";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter file name: ");
        String fileName = scanner.next();
        scanner.close();

        File file = new File(DIR_PATH + File.separator + fileName);

        if (file.exists()) {
            try (Scanner fileScanner = new Scanner(file)) {
                while (fileScanner.hasNextLine()) {
                    String line = fileScanner.nextLine();
                    System.out.println(line);
                }
            } catch (FileNotFoundException e) {
                System.out.println("File not found: " + e.getMessage());
            }
        } else {
            System.out.println("File not found: " + fileName);
        }
    }
}