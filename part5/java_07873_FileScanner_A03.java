import java.io.File;
import java.util.Scanner;

public class java_07873_FileScanner_A03 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String dirPath = scanner.nextLine();

        File directory = new File(dirPath);

        if (directory.exists()) {
            File[] files = directory.listFiles();

            if (files != null) {
                for (File file : files) {
                    if (file.isFile()) {
                        String filePath = file.getPath();
                        int lastDotIndex = filePath.lastIndexOf(".");
                        String fileExtension = filePath.substring(lastDotIndex);

                        if (fileExtension.equalsIgnoreCase(".txt")) {
                            System.out.println("Text file found: " + filePath);
                        } else if (fileExtension.equalsIgnoreCase(".pdf")) {
                            System.out.println("PDF file found: " + filePath);
                        } else if (fileExtension.equalsIgnoreCase(".doc")) {
                            System.out.println("Word file found: " + filePath);
                        } else {
                            System.out.println("Unrecognized file type: " + filePath);
                        }
                    }
                }
            }
        } else {
            System.out.println("Directory does not exist.");
        }
    }
}