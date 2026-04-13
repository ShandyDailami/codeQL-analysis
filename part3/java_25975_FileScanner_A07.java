import java.io.File;
import java.util.Scanner;

public class java_25975_FileScanner_A07 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the name of the file to search: ");
        String fileName = scanner.nextLine();

        File file = new File(fileName);

        if (file.exists()) {
            System.out.println("File exists!");
        } else {
            System.out.println("File does not exist!");
        }

        scanner.close();
    }

}