import java.io.File;
import java.util.Scanner;

public class java_21078_FileScanner_A08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String dirPath = scanner.next();

        File dir = new File(dirPath);
        File[] hiddenFiles = dir.listFiles(file -> file.isHidden());

        for (File file : hiddenFiles) {
            if (file.isFile() && file.canRead()) {
                System.out.println("The file " + file.getName() + " has read permissions. This is a security-sensitive operation.");
            }
        }
    }
}