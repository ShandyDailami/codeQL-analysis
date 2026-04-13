import java.io.File;
import java.util.Scanner;

public class java_19011_FileScanner_A03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();

        File directory = new File(directoryPath);

        if (directory.exists() && directory.isDirectory()) {
            File[] files = directory.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isFile()) {
                        String fileName = file.getName();
                        String extension = fileName.substring(fileName.lastIndexOf(".") + 1);

                        if (extension.equals("txt") || extension.equals("doc") || extension.equals("docx") || extension.equals("pdf")) {
                            System.out.println("File Name: " + fileName);
                            System.out.println("File Type: Text Document");

                            // Security-sensitive operation: Read file content
                            try {
                                Scanner fileScanner = new Scanner(file);
                                while (fileScanner.hasNextLine()) {
                                    String line = fileScanner.nextLine();
                                    System.out.println("Line Content: " + line);
                                }
                                fileScanner.close();
                            } catch (Exception e) {
                                System.out.println("Failed to read file content: " + e.getMessage());
                            }
                        }
                    }
                }
            }
        } else {
            System.out.println("Directory does not exist or it is not a directory.");
        }
    }
}