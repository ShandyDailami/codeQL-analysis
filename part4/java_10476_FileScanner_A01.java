import java.io.File;
import java.util.Scanner;

public class java_10476_FileScanner_A01 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the name of the file:");
        String fileName = scanner.nextLine();
        File file = new File(fileName);

        if (file.exists()) {
            System.out.println("File exists");
            System.out.println("File content:");
            System.out.println(file.readText());
        } else {
            System.out.println("File does not exist");
        }

        scanner.close();
    }
}