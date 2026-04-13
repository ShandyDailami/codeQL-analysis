import java.io.*;

public class java_03392_FileScanner_A07 {
    public static void main(String[] args) throws IOException {
        // Define the directory path
        File directory = new File("/path/to/directory");

        // Use FileFilter to only scan files with .txt extension
        File[] txtFiles = directory.listFiles(new FileFilter() {
            public boolean accept(File pathname) {
                return pathname.isFile() && pathname.getName().endsWith(".txt");
            }
        });

        // If no txtFiles found, print a message and exit
        if (txtFiles == null) {
            System.out.println("No .txt files found in the directory.");
            System.exit(1);
        }

        // Loop through all the txtFiles
        for (File txtFile : txtFiles) {
            // Open the file
            FileReader reader = new FileReader(txtFile);

            // Read the file character by character
            int c;
            while ((c = reader.read()) != -1) {
                // If the character is an uppercase letter, print a warning
                if (Character.isUpperCase((char) c)) {
                    System.out.println("Warning: File \"" + txtFile.getName() + "\" contains an uppercase letter.");
                }
            }

            // Close the reader
            reader.close();
        }
    }
}