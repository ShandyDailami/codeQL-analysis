import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_41047_FileScanner_A03 {
    public static void main(String[] args) {
        String directoryPath = "/path/to/directory"; // replace with your directory path
        File directory = new File(directoryPath);

        if (!directory.exists()) {
            System.out.println("Directory does not exist");
            return;
        }

        File[] files = directory.listFiles();
        if (files == null) {
            System.out.println("No files in directory");
            return;
        }

        for (File file : files) {
            if (!file.isFile()) {
                continue;
            }

            try (Scanner scanner = new Scanner(file)) {
                while (scanner.hasNextLine()) {
                    System.out.println(scanner.nextLine());
                }
            } catch (FileNotFoundException e) {
                System.out.println("Error reading file: " + file.getName());
                e.printStackTrace();
            }
        }
    }
}