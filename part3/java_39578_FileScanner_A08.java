import java.io.File;
import java.util.Scanner;

public class java_39578_FileScanner_A08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a pattern:");
        String pattern = scanner.next();
        scanner.close();

        String currentDir = System.getProperty("user.dir");
        File dir = new File(currentDir);

        File[] matchingFiles = dir.listFiles((dir1, name) -> name.matches(pattern));

        if (matchingFiles != null) {
            for (File file : matchingFiles) {
                System.out.println(file.getName());
            }
        } else {
            System.out.println("No files found matching the pattern.");
        }
    }
}