import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.util.Arrays;

public class java_38284_FileScanner_A03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();

        File directory = new File(directoryPath);

        if (!directory.exists() || !directory.isDirectory()) {
            System.out.println("The provided path does not exist or is not a directory.");
            return;
        }

        File[] files = directory.listFiles();

        if (files == null) {
            System.out.println("No files found in the directory.");
            return;
        }

        Arrays.stream(files)
                .filter(file -> file.isFile() && file.getName().endsWith(".txt"))
                .forEach(file -> processFile(file));

        scanner.close();
    }

    private static void processFile(File file) {
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                // TODO: perform security-sensitive operations related to A03_Injection.
                // For example, perform SQL injection or XSS attacks
                System.out.println("Processing file: " + file.getName() + ", line: " + line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error processing file: " + file.getName());
            e.printStackTrace();
        }
    }
}