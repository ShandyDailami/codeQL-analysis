import java.io.File;
import java.util.Scanner;

public class java_14944_FileScanner_A03 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();

        File directory = new File(directoryPath);

        File[] allFiles = directory.listFiles();

        if (allFiles != null) {
            for (File file : allFiles) {
                if (file.isFile()) {
                    String fileName = file.getName();
                    String extension = fileName.substring(fileName.lastIndexOf('.') + 1);

                    if ("txt".equalsIgnoreCase(extension) || "log".equalsIgnoreCase(extension)) {
                        System.out.println("File found: " + file.getPath());
                    }
                } else if (file.isDirectory()) {
                    System.out.println("Directory found: " + file.getPath());
                }
            }
        }

        scanner.close();
    }
}