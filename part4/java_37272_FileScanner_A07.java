import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class java_37272_FileScanner_A07 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String dirPath = scanner.nextLine();
        System.out.println("Enter the string to search for:");
        String searchString = scanner.nextLine();

        File directory = new File(dirPath);
        File[] listOfFiles = directory.listFiles();

        if (listOfFiles != null) {
            for (File file : listOfFiles) {
                if (file.isFile() && file.canRead()) {
                    Scanner fileScanner = new Scanner(file);
                    while (fileScanner.hasNextLine()) {
                        String line = fileScanner.nextLine();
                        if (line.contains(searchString)) {
                            System.out.println("File: " + file.getAbsolutePath() + " contains the string: " + line);
                        }
                    }
                    fileScanner.close();
                }
            }
        }
    }
}