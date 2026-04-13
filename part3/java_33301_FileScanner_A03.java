import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_33301_FileScanner_A03 {
    public static void main(String[] args) {
        String directoryPath = "/path/to/directory"; // replace with your directory
        String extension = ".*.txt"; // example extension

        File directory = new File(directoryPath);
        if (directory.exists()) {
            File[] files = directory.listFiles((dir, name) -> name.matches(extension));
            if (files != null) {
                for (File file : files) {
                    if (file.isFile() && file.canRead()) {
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
            }
        } else {
            System.out.println("Directory not found!");
        }
    }
}