import java.io.*;

public class java_36592_FileScanner_A07 {
    public static void main(String[] args) {
        String directoryPath = "/path/to/directory"; // specify your directory here
        String targetFileExtension = "txt"; // specify your target file extension here

        File directory = new File(directoryPath);

        FileScanner fileScanner = new FileScanner(directory, targetFileExtension);

        try {
            fileScanner.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class FileScanner {
    private File directory;
    private String targetFileExtension;

    public java_36592_FileScanner_A07(File directory, String targetFileExtension) {
        this.directory = directory;
        this.targetFileExtension = targetFileExtension;
    }

    public void start() throws Exception {
        File[] files = directory.listFiles();

        for (File file : files) {
            if (file.isFile() && file.getName().endsWith(targetFileExtension)) {
                processFile(file);
            } else if (file.isDirectory()) {
                start();
            }
        }
    }

    private void processFile(File file) {
        // Place your security-sensitive operations here
        // For example, here is a simple code snippet to read a file and print its content

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (Exception e) {
            // handle exception
        }
    }
}