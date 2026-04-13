import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_02751_FileScanner_A03 {

    public static void main(String[] args) {
        String directoryPath = "C:\\your\\directory\\path"; // replace with your directory path
        File directory = new File(directoryPath);

        if (directory.exists()) {
            File[] files = directory.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isFile()) {
                        try (Scanner scanner = new Scanner(file)) {
                            while (scanner.hasNextLine()) {
                                String line = scanner.nextLine();
                                System.out.println(line); // replace with your security-sensitive operation
                            }
                        } catch (FileNotFoundException e) {
                            System.out.println("File not found: " + file.getPath());
                        }
                    }
                }
            }
        } else {
            System.out.println("Directory not found: " + directoryPath);
        }
    }
}