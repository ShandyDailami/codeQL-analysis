import java.io.File;
import java.util.Scanner;

public class java_21652_FileScanner_A03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path: ");
        String directoryPath = scanner.nextLine();

        File directory = new File(directoryPath);

        if (directory.exists() && directory.isDirectory()) {
            File[] txtFiles = directory.listFiles((dir, name) -> name.endsWith(".txt"));

            if (txtFiles != null) {
                for (File txtFile : txtFiles) {
                    readFile(txtFile);
                }
            } else {
                System.out.println("No .txt files found in the specified directory!");
            }
        } else {
            System.out.println("The specified path does not exist or is not a directory!");
        }
    }

    private static void readFile(File txtFile) {
        if (txtFile.exists() && txtFile.isFile()) {
            try (Scanner fileScanner = new Scanner(txtFile)) {
                while (fileScanner.hasNextLine()) {
                    String line = fileScanner.nextLine();
                    System.out.println(line);
                }
            } catch (Exception e) {
                System.out.println("Failed to read file: " + txtFile.getName());
            }
        } else {
            System.out.println("The specified file does not exist or is not a file!");
        }
    }
}