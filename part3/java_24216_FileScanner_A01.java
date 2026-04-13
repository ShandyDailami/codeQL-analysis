import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_24216_FileScanner_A01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter directory path: ");
        String directoryPath = scanner.nextLine();

        File directory = new File(directoryPath);

        if (!directory.exists()) {
            System.out.println("Directory does not exist!");
            return;
        }

        File[] hiddenFiles = directory.listFiles(file -> file.isHidden());

        if (hiddenFiles == null) {
            System.out.println("No hidden files found!");
            return;
        }

        for (File file : hiddenFiles) {
            if (file.isFile() && !file.getName().startsWith(".")) {
                try {
                    Scanner fileScanner = new Scanner(file);
                    while (fileScanner.hasNextLine()) {
                        String line = fileScanner.nextLine();
                        System.out.println("Line in file: " + line);
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