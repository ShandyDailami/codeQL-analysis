import java.io.File;
import java.util.Scanner;

public class java_13722_FileScanner_A03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the path to the directory:");
        String dirPath = scanner.nextLine();
        System.out.println("Enter the file name to search:");
        String fileName = scanner.nextLine();

        File dir = new File(dirPath);
        File[] matchingFiles = dir.listFiles((dir1, name) -> name.equals(fileName));

        if (matchingFiles.length == 0) {
            System.out.println("No file found with that name.");
            return;
        }

        File file = matchingFiles[0];

        try (Scanner fileScanner = new Scanner(file)) {
            while (fileScanner.hasNextLine()) {
                System.out.println(fileScanner.nextLine());
            }
        } catch (Exception e) {
            System.out.println("Error reading file: " + file.getName());
        }
    }
}