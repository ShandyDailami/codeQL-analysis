import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_39722_FileScanner_A07 {

    public static void main(String[] args) {
        String directoryPath = "/path/to/directory"; // replace with your directory path
        String fileExtension = ".txt"; // replace with your file extension

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter your password:");
            String password = scanner.nextLine();

            if (isPasswordCorrect(password)) {
                File directory = new File(directoryPath);
                printFiles(directory, fileExtension);
            } else {
                System.out.println("Wrong password! Access denied.");
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        }
    }

    private static boolean isPasswordCorrect(String password) {
        // Replace this with your actual authentication logic
        return password.equals("correct-password");
    }

    private static void printFiles(File directory, String fileExtension) {
        File[] files = directory.listFiles((dir, name) -> name.endsWith(fileExtension));

        if (files != null) {
            for (File file : files) {
                System.out.println(file.getPath());
            }
        } else {
            System.out.println("No files found!");
        }
    }
}