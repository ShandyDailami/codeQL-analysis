import java.io.File;
import java.util.Scanner;

public class java_37128_FileScanner_A03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the directory path: ");
        String dirPath = scanner.nextLine();

        // Get the directory object
        File dir = new File(dirPath);

        // Check if directory exists
        if (dir.exists() && dir.isDirectory()) {
            System.out.println("Files and directories in " + dirPath);
            String[] files = dir.list();

            for (String fileName : files) {
                File file = new File(dirPath + "/" + fileName);
                if (file.isFile()) {
                    System.out.println(fileName);
                } else {
                    System.out.println("Directory: " + fileName);
                }
            }
        } else {
            System.out.println("Invalid directory path!");
        }

        scanner.close();
    }
}