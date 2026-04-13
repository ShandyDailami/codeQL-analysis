import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class java_40520_FileScanner_A08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter directory path: ");
        String directoryPath = scanner.nextLine();

        File directory = new File(directoryPath);

        if (directory.exists() && directory.isDirectory()) {
            File[] txtFiles = directory.listFiles((dir, name) -> name.endsWith(".txt"));

            if (txtFiles != null) {
                Arrays.stream(txtFiles)
                      .map(File::getName)
                      .forEach(System.out::println);
            } else {
                System.out.println("No .txt files found in the directory.");
            }
        } else {
            System.out.println("Directory does not exist or is not a directory.");
        }

        scanner.close();
    }
}