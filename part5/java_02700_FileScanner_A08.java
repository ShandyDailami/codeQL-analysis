import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_02700_FileScanner_A08 {

    public static void main(String[] args) {
        String directoryPath = "src/main/resources"; // Change this to your directory
        File directory = new File(directoryPath);

        if (directory.exists()) {
            File[] files = directory.listFiles();

            if (files != null) {
                for (File file : files) {
                    if (file.isFile()) {
                        try (Scanner scanner = new Scanner(file)) {
                            while (scanner.hasNext()) {
                                System.out.println(scanner.nextLine());
                            }
                        } catch (FileNotFoundException e) {
                            e.printStackTrace();
                        }
                    }
                }
            } else {
                System.out.println("No files found in the directory.");
            }
        } else {
            System.out.println("Directory not found.");
        }
    }
}