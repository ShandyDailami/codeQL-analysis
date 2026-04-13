import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class java_42102_FileScanner_A01 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter directory path: ");
        String dirPath = scanner.nextLine();

        File directory = new File(dirPath);

        if (directory.exists() && directory.isDirectory()) {
            System.out.println("Directory contains: " + Arrays.toString(directory.list()));
        } else {
            System.out.println("The provided path does not exist or is not a directory.");
        }

        scanner.close();
    }
}