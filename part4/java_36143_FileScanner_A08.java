import java.io.*;

public class java_36143_FileScanner_A08 {
    public static void main(String[] args) {
        String directoryPath = "/path/to/directory";
        String searchFilePattern = "*.txt";

        File directory = new File(directoryPath);
        File[] matchingFiles = directory.listFiles((dir, name) -> name.endsWith(searchFilePattern));

        if (matchingFiles != null) {
            for (File file : matchingFiles) {
                try (FileReader reader = new FileReader(file)) {
                    int character;
                    while ((character = reader.read()) != -1) {
                        System.out.print((char) character);
                    }
                } catch (IOException e) {
                    System.err.println("Unable to read file " + file.getPath());
                }
            }
        } else {
            System.out.println("No matching files found in " + directoryPath);
        }
    }
}