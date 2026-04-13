import java.io.File;
import java.util.Scanner;

public class java_36413_FileScanner_A08 {
    private static final String DIRECTORY = "C:\\Users\\ASUS\\Downloads\\";
    private static final String FILE_EXTENSION = ".*\\.txt";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter directory path:");
        String directoryPath = scanner.nextLine();

        File directory = new File(directoryPath);

        if (!directory.exists()) {
            System.out.println("Directory does not exist");
            return;
        }

        if (!directory.isDirectory()) {
            System.out.println("Entered path is not a directory");
            return;
        }

        System.out.println("Enter file extension (without dot):");
        String fileExtension = scanner.nextLine();

        File[] txtFiles = directory.listFiles((dir, name) -> name.endsWith(fileExtension + ".txt"));

        if (txtFiles == null) {
            System.out.println("No .txt files in the directory");
            return;
        }

        for (File txtFile : txtFiles) {
            System.out.println("File: " + txtFile.getName());
            readFile(txtFile);
            System.out.println();
        }
    }

    private static void readFile(File txtFile) {
        try (Scanner fileScanner = new Scanner(txtFile)) {
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                System.out.println("Line: " + line);
            }
        } catch (Exception e) {
            System.out.println("Error reading file: " + txtFile.getName());
        }
    }
}