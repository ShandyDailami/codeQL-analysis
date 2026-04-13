import java.io.*;

public class java_15081_FileScanner_A08 {

    public static void main(String[] args) {
        String directoryPath = "/path/to/directory"; // replace with actual directory path
        scanDirectory(directoryPath);
    }

    public static void scanDirectory(String directoryPath) {
        File directory = new File(directoryPath);

        if (!directory.exists()) {
            System.out.println("Directory does not exist.");
            return;
        }

        File[] files = directory.listFiles();

        if (files == null) {
            System.out.println("Error listing files in directory.");
            return;
        }

        for (File file : files) {
            if (file.isFile()) {
                printFileContents(file);
            }
        }
    }

    public static void printFileContents(File file) {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + file.getPath());
        }
    }
}