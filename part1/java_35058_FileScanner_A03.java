import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_35058_FileScanner_A03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();

        File directory = new File(directoryPath);

        if (directory.exists()) {
            File[] allFiles = directory.listFiles();
            if (allFiles != null) {
                for (File file : allFiles) {
                    if (file.isFile() && file.canRead()) {
                        try (Scanner fileScanner = new Scanner(file)) {
                            while (fileScanner.hasNextLine()) {
                                String line = fileScanner.nextLine();
                                System.out.println(line);
                            }
                        } catch (FileNotFoundException e) {
                            e.printStackTrace();
                        }
                    }
                }
            } else {
                System.out.println("No files in the directory!");
            }
        } else {
            System.out.println("Directory does not exist!");
        }
    }
}