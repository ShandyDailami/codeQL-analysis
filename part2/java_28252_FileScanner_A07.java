import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_28252_FileScanner_A07 {
    public static void main(String[] args) {
        File fileDirectory = new File("C:\\path\\to\\directory");  // specify your directory here

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the file name to search for: ");
        String fileName = scanner.nextLine();

        try (FileScanner fileScanner = new FileScanner(fileDirectory)) {
            while (fileScanner.hasNext()) {
                File file = fileScanner.nextFile(fileName);

                if (file != null) {
                    System.out.println("File found: " + file.getPath());
                } else {
                    System.out.println("File not found");
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Invalid path or file not found: " + e.getMessage());
        }
    }
}