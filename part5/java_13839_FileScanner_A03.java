import java.io.File;
import java.util.Scanner;

public class java_13839_FileScanner_A03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter directory path:");
        String directoryPath = scanner.nextLine();

        File directory = new File(directoryPath);

        if (!directory.exists()) {
            System.out.println("Directory does not exist.");
            return;
        }

        if (!directory.isDirectory()) {
            System.out.println("Entered path is not a directory.");
            return;
        }

        File[] files = directory.listFiles();
        if (files == null) {
            System.out.println("No files found in the directory.");
            return;
        }

        for (File file : files) {
            if (file.isFile()) {
                String fileName = file.getName();
                int lastDotIndex = fileName.lastIndexOf('.');
                if (lastDotIndex == -1) {
                    System.out.println("File name does not contain extension.");
                    continue;
                }

                String extension = fileName.substring(lastDotIndex + 1);
                if (extension.equals("exe") || extension.equals("dll")) {
                    System.out.println("Suspicious file: " + file.getAbsolutePath());
                }
            }
        }
    }
}