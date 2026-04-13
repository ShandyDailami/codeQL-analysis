import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class java_11934_FileScanner_A01 {
    private File file;

    public java_11934_FileScanner_A01(String fileName) {
        file = new File(fileName);
    }

    public void searchFile(String keyword) {
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.contains(keyword)) {
                    System.out.println("File contains keyword: " + keyword);
                    break;
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }
    }

    public static void main(String[] args) {
        UniqueVanillaFileScanner scanner = new UniqueVanillaFileScanner("path_to_file");
        scanner.searchFile("sensitive_info");
    }
}