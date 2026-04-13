import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_06765_FileScanner_A07 {
    public static void main(String[] args) throws FileNotFoundException {
        String directory = "C:\\path\\to\\your\\directory"; // Replace with your directory
        File directoryFile = new File(directory);
        if (directoryFile.isDirectory()) {
            String textFileExtension = ".txt";
            File[] txtFiles = directoryFile.listFiles((dir, name) -> name.endsWith(textFileExtension));

            if (txtFiles != null) {
                for (File txtFile : txtFiles) {
                    Scanner fileScanner = new Scanner(txtFile);
                    while (fileScanner.hasNextLine()) {
                        String line = fileScanner.nextLine();
                        System.out.println(line); // Print the line to console

                        // Place security-sensitive operations related to AuthFailure here

                    }
                    fileScanner.close();
                }
            } else {
                System.out.println("No .txt files found in the directory.");
            }
        } else {
            System.out.println("Provided path is not a directory.");
        }
    }
}