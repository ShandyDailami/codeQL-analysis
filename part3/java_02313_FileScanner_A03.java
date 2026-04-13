import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_02313_FileScanner_A03 {
    private static final String[] VULNERABLE_PATTERNS = { "password", "secret", "token" };

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the directory path:");
        String directoryPath = scanner.nextLine();

        File directory = new File(directoryPath);
        File[] files = directory.listFiles();

        for (File file : files) {
            if (file.isFile()) {
                scanFileForVulnerabilities(file);
            }
        }
    }

    private static void scanFileForVulnerabilities(File file) {
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                for (String pattern : VULNERABLE_PATTERNS) {
                    if (line.contains(pattern)) {
                        System.out.println("Vulnerable line in file: " + file.getPath() + ": " + line);
                    }
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error reading file: " + file.getPath());
        }
    }
}