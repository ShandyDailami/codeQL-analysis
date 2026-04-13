import java.io.File;

public class java_41646_FileScanner_A08 {
    public static void main(String[] args) {
        // Create a new File object pointing to the current directory
        File currentDirectory = new File(".");

        // Use the list method to get an array of File objects
        File[] listOfFiles = currentDirectory.listFiles();

        // If there are files in the directory
        if (listOfFiles != null) {
            // Loop through each file
            for (File file : listOfFiles) {
                // Print out the name of each file
                System.out.println(file.getName());
            }
        }
    }
}