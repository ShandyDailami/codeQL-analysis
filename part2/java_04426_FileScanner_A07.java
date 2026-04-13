import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class java_04426_FileScanner_A07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter directory path:");
        String directoryPath = scanner.nextLine();

        File directory = new File(directoryPath);

        if (directory.exists()) {
            File[] txtFiles = directory.listFiles((dir, name) -> name.endsWith(".txt"));

            if (txtFiles != null) {
                for (File txtFile : txtFiles) {
                    try {
                        Scanner fileScanner = new Scanner(txtFile);
                        while (fileScanner.hasNextLine()) {
                            String line = fileScanner.nextLine();
                            System.out.println(line);
                        }
                        fileScanner.close();
                    } catch (FileNotFoundException e) {
                        System.out.println("File not found: " + txtFile.getPath());
                    }
                }
            } else {
                System.out.println("No .txt files in directory: " + directoryPath);
            }
        } else {
            System.out.println("Directory not found: " + directoryPath);
        }
    }
}