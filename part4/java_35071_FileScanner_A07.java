import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_35071_FileScanner_A07 {

    public static void checkFile(String directoryPath, String fileName) throws FileNotFoundException {
        File directory = new File(directoryPath);
        File file = new File(directory, fileName);
        if (file.exists()) {
            throw new FileNotFoundException("File '" + fileName + "' not found in directory '" + directoryPath + "'");
        } else {
            System.out.println("File '" + fileName + "' not found in directory '" + directoryPath + "'");
        }
    }

    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter the directory path:");
            String directoryPath = scanner.nextLine();
            System.out.println("Enter the file name:");
            String fileName = scanner.nextLine();
            checkFile(directoryPath, fileName);
        } catch (FileNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}