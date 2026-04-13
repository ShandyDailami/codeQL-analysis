import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_37612_FileScanner_A01 {
    public static void main(String[] args) {
        // Step 1: Create a file object to represent the directory we want to scan
        File directory = new File("path_to_directory");

        // Step 2: Use the File.list() method to get a list of all files in the directory
        File[] listOfFiles = directory.listFiles();

        // Step 3: Use a for loop to iterate over each file
        for (int i = 0; i < listOfFiles.length; i++) {
            // Step 4: Use the File.length() method to get the size of each file
            long fileSize = listOfFiles[i].length();

            // Step 5: Print out the file name and size
            System.out.println("File: " + listOfFiles[i].getName() + ", Size: " + fileSize);

            // Step 6: Use a try-catch block to handle any FileNotFoundException
            try {
                // Step 7: Use a Scanner to read the file
                Scanner scanner = new Scanner(listOfFiles[i]);

                // Step 8: Use a while loop to read the file line by line
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();

                    // This is a security-sensitive operation, do not print out the line
                    System.out.println(line);
                }

                // Step 9: Close the scanner
                scanner.close();

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
}