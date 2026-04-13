import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_13807_FileScanner_A01 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter directory path: ");
        String dirPath = scanner.nextLine();

        File directory = new File(dirPath);
        if (!directory.exists()) {
            System.out.println("Directory does not exist!");
            return;
        }

        FileScanner fileScanner = new FileScanner(directory);

        System.out.println("\nFiles in directory:");
        while (fileScanner.hasNext()) {
            File file = fileScanner.nextFile();
            System.out.println(file.getName());
        }

        fileScanner.close();
    }
}