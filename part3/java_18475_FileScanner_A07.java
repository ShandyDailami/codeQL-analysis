import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class java_18475_FileScanner_A07 {
    public static void main(String[] args) {
        String directoryPath = "/path/to/directory"; // replace with your directory path
        File directory = new File(directoryPath);

        if (!directory.exists()) {
            System.out.println("Directory does not exist!");
            return;
        }

        File[] hiddenFiles = directory.listFiles((dir, name) -> name.startsWith("."));

        if (hiddenFiles != null) {
            for (File file : hiddenFiles) {
                if (file.isFile()) {
                    try {
                        Scanner scanner = new Scanner(file);
                        long length = 0;
                        while (scanner.hasNextLine()) {
                            String line = scanner.nextLine();
                            length += line.getBytes().length;
                        }
                        scanner.close();

                        System.out.println("File: " + file.getName());
                        System.out.println("Length: " + length + " bytes");
                    } catch (FileNotFoundException e) {
                        System.out.println("File not found: " + file.getName());
                    } catch (IOException e) {
                        System.out.println("Error reading file: " + file.getName());
                    }
                }
            }
        }
    }
}