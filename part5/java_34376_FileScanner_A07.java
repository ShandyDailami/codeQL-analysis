import java.io.File;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class java_34376_FileScanner_A07 {
    private static final String DIR_PATH = "/path/to/directory";

    public static void main(String[] args) {
        Set<File> files = new HashSet<>();
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter file paths:");
            while (scanner.hasNextLine()) {
                String path = scanner.nextLine();
                File file = new File(DIR_PATH + "/" + path);
                if (file.exists() && file.canRead()) {
                    files.add(file);
                } else {
                    System.out.println("Invalid file path: " + path);
                }
            }
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }

        if (files.isEmpty()) {
            System.out.println("No files found.");
        } else {
            System.out.println("Files found: " + files);
        }
    }
}