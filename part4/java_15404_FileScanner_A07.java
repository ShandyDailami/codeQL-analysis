import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class java_15404_FileScanner_A07 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();
        scanner.close();

        File directory = new File(directoryPath);

        if (directory.exists()) {
            File file = new File(directoryPath + "/A07_AuthFailure.txt");

            try {
                if (file.createNewFile()) {
                    System.out.println("File created.");
                } else {
                    System.out.println("File already exists.");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Directory does not exist.");
        }
    }
}