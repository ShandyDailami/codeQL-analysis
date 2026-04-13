import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_05567_FileScanner_A03 {
    public static void main(String[] args) {
        String directoryPath = "/path/to/directory"; // replace with your directory path
        File directory = new File(directoryPath);

        if (directory.exists()) {
            File[] hiddenFiles = directory.listFiles(file -> file.isFile() && !file.getName().startsWith("."));

            if (hiddenFiles != null) {
                for (File file : hiddenFiles) {
                    try {
                        Scanner scanner = new Scanner(file);
                        while (scanner.hasNextLine()) {
                            String line = scanner.nextLine();
                            System.out.println(line);
                        }
                        scanner.close();
                    } catch (FileNotFoundException e) {
                        System.out.println("File not found: " + file.getPath());
                    }
                }
            } else {
                System.out.println("No hidden files found in the directory: " + directory.getPath());
            }
        } else {
            System.out.println("Directory not found: " + directoryPath);
        }
    }
}