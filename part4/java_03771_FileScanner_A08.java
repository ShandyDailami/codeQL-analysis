import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_03771_FileScanner_A08 {
    public static void main(String[] args) {
        String directoryPath = "/path/to/directory";
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter the integrity failure code:");
        String integrityFailureCode = scanner.nextLine();

        File directory = new File(directoryPath);
        File[] txtFiles = directory.listFiles((dir, name) -> name.endsWith(".txt"));

        if (txtFiles != null) {
            for (File file : txtFiles) {
                try {
                    Scanner fileScanner = new Scanner(file);
                    while (fileScanner.hasNextLine()) {
                        String line = fileScanner.nextLine();
                        if (line.contains(integrityFailureCode)) {
                            System.out.println("Potentially integrity failure detected in file: " + file.getName());
                        }
                    }
                    fileScanner.close();
                } catch (FileNotFoundException e) {
                    System.out.println("File not found: " + file.getName());
                }
            }
        }

        scanner.close();
    }
}