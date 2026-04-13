import java.io.File;
import java.util.Scanner;

public class java_24230_FileScanner_A03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String dirPath = scanner.nextLine();

        File dir = new File(dirPath);

        if (dir.exists()) {
            File[] files = dir.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isFile()) {
                        String fileName = file.getName();
                        String extension = fileName.substring(fileName.lastIndexOf(".") + 1);

                        if (extension.equalsIgnoreCase("txt") || extension.equalsIgnoreCase("doc")
                                || extension.equalsIgnoreCase("docx") || extension.equalsIgnoreCase("xls")
                                || extension.equalsIgnoreCase("xlsx")) {
                            System.out.println("File name: " + fileName);
                        }
                    }
                }
            } else {
                System.out.println("No files in the directory.");
            }
        } else {
            System.out.println("The provided path does not exist.");
        }

        scanner.close();
    }
}