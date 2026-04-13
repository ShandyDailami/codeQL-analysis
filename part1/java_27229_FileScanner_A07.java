import java.io.File;
import java.util.Scanner;

public class java_27229_FileScanner_A07 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the directory path: ");
        String directoryPath = scanner.nextLine();
        System.out.print("Enter the string to search for: ");
        String searchString = scanner.nextLine();
        File directory = new File(directoryPath);

        if (directory.exists() && directory.isDirectory()) {
            System.out.println("Searching for file with string: " + searchString);
            File[] matchingFiles = directory.listFiles((dir, name) -> name.endsWith(".txt"));

            if (matchingFiles != null) {
                for (File file : matchingFiles) {
                    if (file.exists() && file.canRead()) {
                        Scanner fileScanner = new Scanner(file);
                        while (fileScanner.hasNextLine()) {
                            String line = fileScanner.nextLine();
                            if (line.contains(searchString)) {
                                System.out.println("Found in file: " + file.getAbsolutePath());
                            }
                        }
                        fileScanner.close();
                    }
                }
            } else {
                System.out.println("No files found with extension '.txt' in the directory.");
            }
        } else {
            System.out.println("Invalid directory or it's not a directory.");
        }

        scanner.close();
    }
}