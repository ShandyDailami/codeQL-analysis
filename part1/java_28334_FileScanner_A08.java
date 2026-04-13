import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_28334_FileScanner_A08 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();

        File directory = new File(directoryPath);

        if (!directory.exists()) {
            System.out.println("Directory does not exist.");
            System.exit(0);
        }

        if (directory.listFiles() == null) {
            System.out.println("Directory is empty.");
            System.exit(0);
        }

        File[] files = directory.listFiles();

        for (File file : files) {
            if (file.isFile()) {
                try {
                    Scanner fileScanner = new Scanner(file);
                    while (fileScanner.hasNextLine()) {
                        String line = fileScanner.nextLine();
                        System.out.println(line);
                    }
                    fileScanner.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }

        scanner.close();
    }
}