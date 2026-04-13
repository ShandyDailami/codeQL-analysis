import java.io.*;
import java.nio.file.*;

public class java_20787_FileScanner_A01 {
    public static void main(String[] args) {
        String directoryPath = "/path/to/directory";
        String fileName = "security_sensitive_file";

        try (FileScanner fileScanner = Files.newScanner(Paths.get(directoryPath), "UTF-8")) {
            while (fileScanner.hasNext()) {
                Path path = fileScanner.nextPath();
                if (path.toString().endsWith(fileName)) {
                    File file = path.toFile();
                    System.out.println("Security sensitive operation: Accessing file " + file.getAbsolutePath());
                    // Do something with the file
                    // For instance, reading and printing its contents
                    try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                        String line;
                        while ((line = reader.readLine()) != null) {
                            System.out.println(line);
                        }
                    }
                    System.out.println("Security sensitive operation: Accessed file " + file.getAbsolutePath());
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}