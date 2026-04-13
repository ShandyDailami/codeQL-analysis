import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class java_25318_FileScanner_A03 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String dirPath = scanner.nextLine();

        File dir = new File(dirPath);

        if (dir.isDirectory()) {
            String[] files = dir.list();
            for (String file : files) {
                File fileObj = new File(dirPath + "/" + file);
                Scanner fileScanner = new Scanner(fileObj);
                while (fileScanner.hasNextLine()) {
                    System.out.println(fileScanner.nextLine());
                }
                fileScanner.close();
            }
        } else {
            System.out.println("The path is not a directory.");
        }

        scanner.close();
    }
}