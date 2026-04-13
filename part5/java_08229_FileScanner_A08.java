import java.io.File;
import java.util.Scanner;

public class java_08229_FileScanner_A08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();

        File directory = new File(directoryPath);

        if (!directory.exists() || !directory.isDirectory()) {
            System.out.println("Directory does not exist or is not a directory.");
            return;
        }

        System.out.println("Scanning files in directory: " + directory.getAbsolutePath());

        File[] files = directory.listFiles();

        for (File file : files) {
            if (file.isFile() && file.getName().endsWith(".txt")) {
                processFile(file);
            }
        }

        scanner.close();
    }

    private static void processFile(File file) {
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                // Here you can perform security-sensitive operations related to A08_IntegrityFailure
                // For example, here we're just printing the line
                System.out.println(line);
            }
        } catch (Exception e) {
            System.out.println("Error processing file: " + file.getAbsolutePath());
        }
    }
}