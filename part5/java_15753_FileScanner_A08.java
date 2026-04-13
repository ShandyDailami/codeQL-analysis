import java.io.File;
import java.util.Scanner;

public class java_15753_FileScanner_A08 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the path of the directory:");
        String path = input.nextLine();

        File directory = new File(path);
        if (!directory.exists()) {
            System.out.println("Directory does not exist");
            return;
        }

        File[] files = directory.listFiles();
        if (files == null) {
            System.out.println("No files in directory");
            return;
        }

        for (File file : files) {
            if (file.isFile()) {
                checkFileIntegrity(file);
            } else if (file.isDirectory()) {
                System.out.println("Directory: " + file.getPath());
                File[] nestedFiles = file.listFiles();
                if (nestedFiles != null) {
                    for (File nestedFile : nestedFiles) {
                        if (nestedFile.isFile()) {
                            checkFileIntegrity(nestedFile);
                        } else if (nestedFile.isDirectory()) {
                            System.out.println("Directory in directory: " + nestedFile.getPath());
                        }
                    }
                }
            }
        }
    }

    private static void checkFileIntegrity(File file) {
        // Integrity check logic goes here. This is a placeholder for the actual integrity check
        System.out.println("Checking integrity of file: " + file.getPath());
    }
}