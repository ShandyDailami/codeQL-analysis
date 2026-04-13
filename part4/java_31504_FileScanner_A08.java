import java.io.*;

public class java_31504_FileScanner_A08 {

    public static void main(String[] args) {
        String directoryPath = "/path/to/directory"; // specify your directory path here
        String fileExtension = "txt"; // specify your file extension here
        scanDirectory(directoryPath, fileExtension);
    }

    private static void scanDirectory(String directoryPath, String fileExtension) {
        File dir = new File(directoryPath);
        File[] allFiles = dir.listFiles((File dir, String name) -> name.endsWith(fileExtension));

        if (allFiles != null) {
            for (File file : allFiles) {
                try {
                    printFileContent(file);
                } catch (IOException e) {
                    System.out.println("Error while reading file: " + file.getName());
                }
            }
        }
    }

    private static void printFileContent(File file) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println("File content: " + line); // Print file content here
        }
        reader.close();
    }
}