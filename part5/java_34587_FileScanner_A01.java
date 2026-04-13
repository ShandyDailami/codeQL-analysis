import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_34587_FileScanner_A01 {

    public static void main(String[] args) {
        String directoryPath = "./src/main/resources";
        File directory = new File(directoryPath);

        if (directory.exists()) {
            File[] files = directory.listFiles();

            if (files != null) {
                for (File file : files) {
                    if (file.isFile()) {
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
                System.out.println("No files found in directory: " + directoryPath);
            }
        } else {
            System.out.println("Directory: " + directoryPath + " does not exist");
        }
    }
}