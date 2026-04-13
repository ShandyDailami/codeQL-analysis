import java.io.File;
import java.util.Scanner;

public class java_08102_FileScanner_A08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the path to the directory:");
        String directoryPath = scanner.nextLine();
        scanner.close();

        File directory = new File(directoryPath);

        if (!directory.exists()) {
            System.out.println("Directory does not exist!");
            return;
        }

        if (directory.listFiles() == null) {
            System.out.println("Directory is empty!");
            return;
        }

        File[] files = directory.listFiles();

        for (File file : files) {
            if (file.isFile()) {
                long length = file.length();
                if (length > 1024 && length < 1024 * 1024 * 1024) {
                    System.out.println("File " + file.getName() + " is of size " + length + " bytes, which is not considered as a security sensitive file.");
                }
            }
        }
    }
}