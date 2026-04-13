import java.io.File;
import java.util.Scanner;

public class java_07056_FileScanner_A08 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the directory path: ");
        String directoryPath = scanner.nextLine();
        scanner.close();

        File directory = new File(directoryPath);

        if (directory.exists() && directory.isDirectory()) {
            String[] files = directory.list();
            for (String file : files) {
                File fileObject = new File(directoryPath + "/" + file);
                if (fileObject.isFile()) {
                    System.out.println(fileObject.getName());
                }
            }
        } else {
            System.out.println("The specified directory does not exist.");
        }
    }
}