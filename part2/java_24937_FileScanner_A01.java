import java.io.File;
import java.util.Scanner;

public class java_24937_FileScanner_A01 {

    private static final String DIRECTORY_PATH = "C:\\path\\to\\directory"; // replace with your directory path
    private static final String FILE_EXTENSION = ".*\\.java$";

    public static void main(String[] args) {
        File directory = new File(DIRECTORY_PATH);
        fileScanner(directory);
    }

    private static void fileScanner(File directory) {
        for (File file : directory.listFiles((dir, name) -> name.matches(FILE_EXTENSION))) {
            if (file.isFile()) {
                Scanner scanner = new Scanner(file);
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    // if the line contains a security-sensitive operation, print it out
                    if (line.contains("security-sensitive operation")) {
                        System.out.println("Found security-sensitive operation in file: " + file.getPath());
                    }
                }
                scanner.close();
            } else if (file.isDirectory()) {
                fileScanner(file);
            }
        }
    }
}