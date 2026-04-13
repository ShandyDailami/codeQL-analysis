import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class java_01642_FileScanner_A07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter directory path:");
        String dirPath = scanner.next();

        // List of files with a specified extension
        List<File> files = new ArrayList<>();
        File dir = new File(dirPath);

        // Add all files to the list
        File[] listOfFiles = dir.listFiles();
        if (listOfFiles != null) {
            for (File file : listOfFiles) {
                if (file.isFile()) {
                    String name = file.getName();
                    if (name.endsWith(".txt")) {  // Assuming all files are txt
                        files.add(file);
                    }
                }
            }
        }

        // Display contents of each file
        for (File file : files) {
            System.out.println("Contents of " + file.getName() + ":");
            try (Scanner scanner2 = new Scanner(file)) {
                while (scanner2.hasNextLine()) {
                    System.out.println(scanner2.nextLine());
                }
            }
        }

        scanner.close();
    }
}