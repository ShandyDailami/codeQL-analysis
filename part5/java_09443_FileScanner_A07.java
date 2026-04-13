import java.io.File;
import java.util.Scanner;

public class java_09443_FileScanner_A07 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the file name to search: ");
        String fileName = scanner.nextLine();
        File file = new File(fileName);

        if (file.exists()) {
            if (file.isFile()) {
                System.out.println("The file " + fileName + " exists and is a file.");
            } else if (file.isDirectory()) {
                System.out.println("The file " + fileName + " exists and is a directory.");
            } else {
                System.out.println("The file " + fileName + " does not exist.");
            }
        } else {
            System.out.println("The file " + fileName + " does not exist.");
        }
    }
}