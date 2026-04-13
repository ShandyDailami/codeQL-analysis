import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class java_10532_FileScanner_A07 {
    private static final String SECURITY_VIOLATION_MSG = "Security violation!";
    private static final String FILE_PATH = "src/main/resources";

    private java_10532_FileScanner_A07() {
        throw new UnsupportedOperationException();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a directory path:");
        String path = scanner.nextLine();
        scanner.close();

        File file = new File(path);

        if (file.exists() && file.isDirectory()) {
            printDirectoryContents(file);
        } else {
            System.out.println(SECURITY_VIOLATION_MSG);
        }
    }

    private static void printDirectoryContents(File dir) {
        File[] files = dir.listFiles();

        if (files != null) {
            Arrays.stream(files)
                    .filter(file -> file.isFile() && file.getName().endsWith(".txt"))
                    .forEach(file -> printFileContents(file));
        }
    }

    private static void printFileContents(File file) {
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line);
            }
        }
    }
}