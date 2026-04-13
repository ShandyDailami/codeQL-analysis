import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_41909_FileScanner_A03 {

    private static final String DIR_PATH = "src/main/resources";

    public static void main(String[] args) {
        scanDirectory(new File(DIR_PATH));
    }

    private static void scanDirectory(File dir) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Please enter a file name:");
            String fileName = scanner.nextLine();
            File file = new File(dir, fileName);
            if (file.exists()) {
                scanFile(file);
            } else {
                System.out.println("File not found!");
            }
        } catch (FileNotFoundException e) {
            System.out.println("Invalid file path!");
        }
    }

    private static void scanFile(File file) {
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line);
            }
        } catch (Exception e) {
            System.out.println("Error scanning file: " + file.getAbsolutePath());
        }
    }
}