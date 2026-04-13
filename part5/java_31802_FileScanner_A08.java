import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_31802_FileScanner_A08 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter directory path: ");
        String directoryPath = scanner.nextLine();
        scanner.close();

        File startingDirectory = new File(directoryPath);

        FileFilter textFilesFilter = new FileFilter() {
            public boolean accept(File pathname) {
                return pathname.isFile() && pathname.getName().endsWith(".txt");
            }
        };

        try {
            findTextFiles(startingDirectory, textFilesFilter);
        } catch (FileNotFoundException e) {
            System.out.println("Directory not found!");
        }
    }

    private static void findTextFiles(File directory, FileFilter fileFilter) throws FileNotFoundException {
        if (directory.listFiles(fileFilter).length == 0) {
            System.out.println("No text files found in directory!");
        } else {
            System.out.println("Text files found in directory:");
            for (File textFile : directory.listFiles(fileFilter)) {
                System.out.println(textFile.getAbsolutePath());
            }
        }
    }
}