import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_06603_FileScanner_A01 {

    public static void main(String[] args) throws FileNotFoundException {
        // a. Creating a FileScanner that allows user to input a directory path
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the directory path:");
        String path = scanner.nextLine();

        // b. Trying to access the directory
        File file = new File(path);
        if (!file.exists()) {
            System.out.println("Directory not found!");
            return;
        }

        // c. Listing the files in the directory
        File[] listOfFiles = file.listFiles();
        if (listOfFiles != null) {
            for (File temp : listOfFiles) {
                if (temp.isFile()) {
                    System.out.println(temp.getName());
                }
            }
        }

        // d. Closing the scanner
        scanner.close();
    }
}