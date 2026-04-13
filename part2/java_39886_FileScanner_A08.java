import java.io.File;
import java.util.Scanner;

public class java_39886_FileScanner_A08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter directory path: ");
        String dirPath = scanner.nextLine();

        File directory = new File(dirPath);
        if (directory.exists() && directory.isDirectory()) {
            String[] files = directory.list();
            for (String fileName : files) {
                File file = new File(directory, fileName);
                if (file.isFile() && file.canRead()) {
                    System.out.println("Content of " + file.getAbsolutePath() + ":");
                    Scanner fileScanner = new Scanner(file);
                    while (fileScanner.hasNextLine()) {
                        System.out.println(fileScanner.nextLine());
                    }
                    fileScanner.close();
                }
            }
        } else {
            System.out.println("Invalid directory path or no such directory exists.");
        }
        scanner.close();
    }
}