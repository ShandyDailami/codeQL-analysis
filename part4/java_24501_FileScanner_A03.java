import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_24501_FileScanner_A03 {
    public static void main(String[] args) {
        String directoryPath = "/path/to/your/directory";  // replace with your directory path
        File directory = new File(directoryPath);

        if (directory.exists()) {
            File[] files = directory.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isFile()) {
                        try (Scanner scanner = new Scanner(file)) {
                            while (scanner.hasNextLine()) {
                                String line = scanner.nextLine();
                                System.out.println("File: " + file.getName() + ", Size: " + line.length() + " bytes");
                            }
                        } catch (FileNotFoundException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        } else {
            System.out.println("Directory does not exist");
        }
    }
}