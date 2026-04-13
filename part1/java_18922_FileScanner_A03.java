import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_18922_FileScanner_A03 {

    public static void main(String[] args) {
        String directoryPath = "path_to_directory"; // replace with your directory path
        File directory = new File(directoryPath);

        if (directory.exists()) {
            File[] files = directory.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isFile()) {
                        Scanner scanner = null;
                        try {
                            scanner = new Scanner(file);
                            while (scanner.hasNextLine()) {
                                String line = scanner.nextLine();
                                System.out.println(line);
                            }
                        } catch (FileNotFoundException e) {
                            e.printStackTrace();
                        } finally {
                            if (scanner != null) {
                                scanner.close();
                            }
                        }
                    }
                }
            }
        } else {
            System.out.println("Directory does not exist.");
        }
    }
}