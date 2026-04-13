import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_34977_FileScanner_A08 {
    public static void main(String[] args) {
        File dir = new File("path_to_directory"); // replace with your directory path

        File[] files = dir.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isFile() && containsSensitiveInfo(file)) {
                    System.out.println("Found sensitive file: " + file.getName());
                }
            }
        }
    }

    private static boolean containsSensitiveInfo(File file) {
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.contains("A08_IntegrityFailure")) {
                    return true;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return false;
    }
}