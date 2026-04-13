import java.io.File;
import java.util.Scanner;

public class java_12268_FileScanner_A03 {
    private static final String DIRECTORY = "/path/to/directory"; // Replace with actual directory

    public static void main(String[] args) {
        File directory = new File(DIRECTORY);
        if (directory.exists() && directory.isDirectory()) {
            File[] files = directory.listFiles();
            if (files != null) {
                Scanner scanner = new Scanner(System.in);
                for (File file : files) {
                    if (file.isFile()) {
                        System.out.println("Enter a line to search in " + file.getName() + ":");
                        String line = scanner.nextLine();
                        if (file.getName().contains(line)) {
                            System.out.println("Found line in " + file.getName());
                        }
                    }
                }
            }
        } else {
            System.out.println("The specified directory does not exist.");
        }
        scanner.close();
    }
}