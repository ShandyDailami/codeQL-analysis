import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_32698_FileScanner_A07 {
    private static final String AUTH_FAILURE = "A07_AuthFailure";

    public static void main(String[] args) {
        String directoryPath = "your_directory_path";  // replace with your directory path
        File directory = new File(directoryPath);

        if (directory.exists()) {
            File[] files = directory.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isFile() && isFileSensitive(file)) {
                        printFileContent(file);
                    }
                }
            }
        } else {
            System.out.println("Directory does not exist");
        }
    }

    private static boolean isFileSensitive(File file) {
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.contains(AUTH_FAILURE)) {
                    return true;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return false;
    }

    private static void printFileContent(File file) {
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                System.out.println(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}