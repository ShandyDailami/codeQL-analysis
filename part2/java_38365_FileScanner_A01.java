import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class java_38365_FileScanner_A01 {

    private static final Pattern IMAGE_EXTENSIONS = Pattern.compile(".*\\.(jpg|png|jpeg|gif|bmp)$", Pattern.CASE_INSENSITIVE);

    public static void main(String[] args) {
        String directoryPath = "/path/to/directory"; // replace with your directory path
        File directory = new File(directoryPath);
        if (!directory.exists() || !directory.isDirectory()) {
            System.out.println("Directory does not exist or it is not a directory.");
            return;
        }

        try (FileScanner fileScanner = new FileScanner()) {
            fileScanner.matchFiles(directory, Main::isImage, System.out::println);
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
    }

    private static boolean isImage(File file) {
        if (file.isDirectory()) {
            return false;
        }
        String name = file.getName();
        return IMAGE_EXTENSIONS.matcher(name).matches();
    }
}