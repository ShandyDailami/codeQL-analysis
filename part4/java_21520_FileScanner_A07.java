import java.io.File;
import java.util.Scanner;

public class java_21520_FileScanner_A07 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();
        File directory = new File(directoryPath);

        if (!directory.exists()) {
            System.out.println("Directory not found!");
            System.exit(0);
        }

        String authFailureFilePath = "/A07_AuthFailure"; // you can change this as per your requirement
        File authFailureFile = new File(directory, authFailureFilePath);

        if (!authFailureFile.exists()) {
            System.out.println("AuthFailure file not found!");
            System.exit(0);
        }

        try (Scanner fileScanner = new Scanner(authFailureFile)) {
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                if (line.contains("AuthFailure")) {
                    System.out.println("AuthFailure found in file: " + authFailureFile.getPath());
                    break;
                }
            }
        } catch (Exception e) {
            System.out.println("Error occurred while reading file: " + authFailureFile.getPath());
        }
    }
}