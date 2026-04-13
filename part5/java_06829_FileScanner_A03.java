import java.io.File;
import java.util.Scanner;

public class java_06829_FileScanner_A03 {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter the directory path: ");
            String dirPath = scanner.nextLine();

            File directory = new File(dirPath);

            if (directory.exists()) {
                FileScanner scanner = new FileScanner();
                String[] files = directory.list();

                if (files != null) {
                    for (String file : files) {
                        File fileObj = new File(directory.getPath() + "/" + file);

                        if (fileObj.isFile()) {
                            System.out.println("File: " + fileObj.getName());
                        } else {
                            System.out.println("Directory: " + fileObj.getName());
                        }
                    }
                } else {
                    System.out.println("No files in the directory.");
                }
            } else {
                System.out.println("Directory does not exist.");
            }

            scanner.close();
        } catch (Exception e) {
            System.out.println("An error occurred.");
        }
    }
}