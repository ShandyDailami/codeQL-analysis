import java.io.*;

public class java_39547_FileScanner_A01 {

    public static void main(String[] args) {
        String directoryPath = "/path/to/directory";
        String targetFileExtension = ".txt";

        File directory = new File(directoryPath);
        File[] files = directory.listFiles((dir, name) -> name.endsWith(targetFileExtension));

        if (files != null) {
            for (File file : files) {
                System.out.println("Scanning file: " + file.getPath());
                try (FileReader reader = new FileReader(file)) {
                    int character;
                    while ((character = reader.read()) != -1) {
                        System.out.print((char) character);
                    }
                } catch (IOException e) {
                    System.err.println("Unable to read file: " + file.getPath());
                }
            }
        } else {
            System.out.println("No files with extension: " + targetFileExtension + " found in directory: " + directoryPath);
        }
    }
}