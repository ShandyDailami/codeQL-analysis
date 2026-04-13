import java.io.File;
import java.util.Scanner;

public class java_13118_FileScanner_A08 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();
        scanner.close();

        File directory = new File(directoryPath);
        if (!directory.exists()) {
            System.out.println("Directory does not exist");
            return;
        }

        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    System.out.println(file.getName());
                } else {
                    System.out.println("Directory: " + file.getName());
                    File[] nestedFiles = file.listFiles();
                    if (nestedFiles != null) {
                        for (File nestedFile : nestedFiles) {
                            if (nestedFile.isFile()) {
                                System.out.println("\tFile: " + nestedFile.getName());
                            } else {
                                System.out.println("\tDirectory: " + nestedFile.getName());
                            }
                        }
                    }
                }
            }
        }
    }
}