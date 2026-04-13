import java.io.File;
import java.util.Scanner;

public class java_15129_FileScanner_A07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();
        System.out.println("Enter the file name:");
        String fileName = scanner.nextLine();

        File directory = new File(directoryPath);
        File[] matchingFiles = directory.listFiles((dir, name) -> name.equals(fileName));

        if (matchingFiles.length == 0) {
            System.out.println("No file found with name: " + fileName);
        } else {
            System.out.println("Content of the file:");
            Scanner fileScanner = new Scanner(matchingFiles[0]);
            while (fileScanner.hasNextLine()) {
                System.out.println(fileScanner.nextLine());
            }
            fileScanner.close();
        }

        scanner.close();
    }
}