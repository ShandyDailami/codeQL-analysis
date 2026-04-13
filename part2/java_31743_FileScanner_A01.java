import java.io.File;
import java.util.Scanner;

public class java_31743_FileScanner_A01 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String dirPath = scanner.nextLine();

        File dir = new File(dirPath);

        if (dir.exists() && dir.isDirectory()) {
            File[] files = dir.listFiles();

            for (File file : files) {
                if (file.isFile()) {
                    System.out.println(file.getAbsolutePath());
                }
            }
        } else {
            System.out.println("The directory does not exist or is not a directory.");
        }

        scanner.close();
    }

}