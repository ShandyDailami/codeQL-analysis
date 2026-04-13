import java.io.File;
import java.util.Scanner;

public class java_39971_FileScanner_A07 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String dirPath = scanner.nextLine();

        File dir = new File(dirPath);

        if (dir.exists() && dir.isDirectory()) {
            File authFailureFile = new File(dirPath + "/AuthFailure.txt");
            if (authFailureFile.exists() && authFailureFile.canRead()) {
                System.out.println("AuthFailure.txt found in the specified directory!");
            } else {
                System.out.println("AuthFailure.txt not found in the specified directory!");
            }
        } else {
            System.out.println("The specified path does not exist or is not a directory!");
        }

        scanner.close();
    }
}