import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_28681_FileScanner_A08 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter directory path: ");
        String directoryPath = input.nextLine();

        File directory = new File(directoryPath);
        File[] txtFiles = directory.listFiles((dir, name) -> name.endsWith(".txt"));

        for (File file : txtFiles) {
            System.out.println("Scanning file: " + file.getName());

            Scanner fileScanner = new Scanner(file);
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                System.out.println("Line: " + line);

                // This is a placeholder for security-sensitive operation.
                // In a real-world application, this operation should be more complex and
                // the result should be checked against a pre-defined list of known bad patterns.
                if (line.contains("badpattern")) {
                    System.out.println("File is insecure: The file contains a known bad pattern.");
                } else {
                    System.out.println("File is secure: The file does not contain a known bad pattern.");
                }
            }

            fileScanner.close();
        }

        input.close();
    }
}