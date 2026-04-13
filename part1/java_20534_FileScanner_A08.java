import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class java_20534_FileScanner_A08 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter directory path to start scan:");
        String directoryPath = scanner.nextLine();
        scanner.close();

        File directory = new File(directoryPath);

        if (!directory.exists()) {
            System.out.println("Directory does not exist.");
            return;
        }

        if (!directory.isDirectory()) {
            System.out.println("Entered path is not a directory.");
            return;
        }

        try (FileScanner scanner = new FileScanner(directory)) {
            scanner.filter(FileFilterUtils.INSTANCE::acceptAllFiles);
            scanner.forEach(file -> {
                if (file.isDirectory()) {
                    System.out.printf("Skipping directory: %s%n", file);
                    return;
                }

                try (FileReader reader = new FileReader(file)) {
                    StringBuilder builder = new StringBuilder();
                    int content;
                    while ((content = reader.read()) != -1) {
                        builder.append((char) content);
                    }

                    String fileContent = builder.toString();
                    byte[] fileBytes = fileContent.getBytes();
                    byte[] integrityBytes = fileContent.getBytes("ISO-8859-1"); // The same as ISO-8859-1
                    long integrityCheck = Files.integrityCheck(file.toPath(), integrityBytes);

                    if (integrityCheck != -1) {
                        System.out.printf("File integrity check failed for file: %s%n", file);
                        return;
                    }

                    System.out.printf("File: %s, Content: %s%n", file, fileContent);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}