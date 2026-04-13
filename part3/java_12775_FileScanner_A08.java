import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class java_12775_FileScanner_A08 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the directory path: ");
        String dirPath = scanner.nextLine();
        System.out.print("Enter the string to search: ");
        String searchString = scanner.nextLine();

        File dir = new File(dirPath);

        if (dir.exists() && dir.isDirectory()) {
            File[] txtFiles = dir.listFiles((dir2, name) -> name.endsWith(".txt"));

            if (txtFiles != null) {
                for (File txtFile : txtFiles) {
                    Scanner fileScanner = new Scanner(txtFile);
                    while (fileScanner.hasNextLine()) {
                        String line = fileScanner.nextLine();
                        if (line.contains(searchString)) {
                            System.out.println("Found in file: " + txtFile.getName());
                        }
                    }
                    fileScanner.close();
                }
            } else {
                System.out.println("No .txt files found in the directory.");
            }
        } else {
            System.out.println("Invalid directory.");
        }
    }
}