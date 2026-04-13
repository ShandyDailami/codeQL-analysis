import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_01364_FileScanner_A03 {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the pattern to search:");
        String pattern = scanner.nextLine();

        File currentDir = new File(".");
        File[] matchingFiles = currentDir.listFiles((dir, name) -> name.matches(pattern));

        if (matchingFiles != null) {
            for (File file : matchingFiles) {
                System.out.println(file.getAbsolutePath());
            }
        } else {
            System.out.println("No files found with pattern: " + pattern);
        }
    }
}