import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class java_13004_FileScanner_A01 {
    private static final String ROOT_PATH = "C:\\";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path: ");
        String directoryPath = scanner.nextLine();

        File rootDir = new File(ROOT_PATH);
        File[] restrictedFiles = rootDir.listFiles((dir, name) -> name.endsWith(".pdf"));

        if (restrictedFiles == null) {
            System.out.println("No files found in the specified directory");
        } else {
            Arrays.stream(restrictedFiles).forEach(file -> scanFile(file));
        }

        scanner.close();
    }

    private static void scanFile(File file) {
        if (file.isFile()) {
            System.out.println("File: " + file.getAbsolutePath());
        } else if (file.isDirectory()) {
            System.out.println("Directory: " + file.getAbsolutePath());
            File[] filesInDir = file.listFiles();
            if (filesInDir != null) {
                Arrays.stream(filesInDir).forEach(SecureFileScanner::scanFile);
            }
        }
    }
}