import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class java_12799_FileScanner_A07 {
    public static void main(String[] args) {
        String directoryPath = "/path/to/directory"; // Replace with the actual path
        String extension = ".txt";

        File directory = new File(directoryPath);

        if (directory.exists()) {
            File[] files = directory.listFiles((dir, name) -> name.endsWith(extension));

            if (files != null) {
                for (File file : files) {
                    try (Scanner scanner = new Scanner(file)) {
                        while (scanner.hasNextLine()) {
                            String line = scanner.nextLine();
                            System.out.println(line);
                        }
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                }
            }
        } else {
            System.out.println("Directory does not exist");
        }
    }
}