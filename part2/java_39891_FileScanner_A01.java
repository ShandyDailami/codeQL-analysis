import java.io.File;
import java.util.Scanner;

public class java_39891_FileScanner_A01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a directory path:");
        String path = scanner.nextLine();

        File file = new File(path);
        File[] rootDirectories = file.listRoots();

        if (rootDirectories != null) {
            for (File rootDirectory : rootDirectories) {
                System.out.println("Root directory: " + rootDirectory.getAbsolutePath());
            }
        } else {
            System.out.println("No root directories found.");
        }
    }
}