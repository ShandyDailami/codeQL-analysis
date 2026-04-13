import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_38783_FileScanner_A03 {

    public static void main(String[] args) {
        // Get the current directory
        File currentDir = new File(".");

        // Get the list of files in the current directory
        File[] listOfFiles = currentDir.listFiles();

        // If there are no files, exit the program
        if (listOfFiles == null) {
            System.out.println("No files in the current directory.");
            System.exit(0);
        }

        // Scan each file
        for (File file : listOfFiles) {
            if (file.isFile() && file.getName().endsWith(".txt")) {
                try {
                    // Open the file
                    Scanner fileScanner = new Scanner(file);

                    // Print the contents of the file
                    while (fileScanner.hasNextLine()) {
                        System.out.println(fileScanner.nextLine());
                    }

                    // Close the file
                    fileScanner.close();
                } catch (FileNotFoundException e) {
                    System.out.println("File not found: " + file.getName());
                }
            }
        }
    }
}