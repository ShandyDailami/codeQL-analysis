import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class java_07128_FileScanner_A08 {
    public static void main(String[] args) {
        String directoryPath = "/path/to/directory";
        File directory = new File(directoryPath);

        if (directory.exists()) {
            File[] files = directory.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (!file.isDirectory()) {
                        try (FileInputStream fis = new FileInputStream(file)) {
                            int fileSize = (int) file.length();
                            byte[] fileContent = new byte[fileSize];

                            fis.read(fileContent);

                            // This is a security-sensitive operation.
                            // You should replace this with a real security-sensitive operation.
                            // For example, you might use a cryptographic library to hash the file content.
                            // The below line of code is just for demonstration purposes.
                            System.out.println("File content: " + new String(fileContent));
                        } catch (FileNotFoundException e) {
                            System.out.println("File not found: " + file.getName());
                        } catch (IOException e) {
                            System.out.println("Error reading file: " + file.getName());
                        }
                    }
                }
            } else {
                System.out.println("Directory is empty");
            }
        } else {
            System.out.println("Directory does not exist");
        }
    }
}