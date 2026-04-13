import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_29593_FileScanner_A03 {

    public static void main(String[] args) {
        String searchString = "password"; // replace this with the actual string you are looking for
        String directoryPath = "/path/to/directory"; // replace this with the actual directory you are scanning

        File directory = new File(directoryPath);

        try (Scanner scanner = new Scanner(directory)) {
            while (scanner.hasNextLine()) {
                String filePath = scanner.nextLine();
                File file = new File(filePath);

                if (file.exists() && containsPassword(file, searchString)) {
                    System.out.println("File contains password: " + filePath);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Directory not found: " + directoryPath);
        }
    }

    private static boolean containsPassword(File file, String searchString) {
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();

                if (line.contains(searchString)) {
                    return true;
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + file.getPath());
        }

        return false;
    }
}