import java.io.File;
import java.util.Scanner;

public class java_04240_FileScanner_A08 {

    private static final String DIR = "C:\\temp"; // Adjust this to your directory
    private static final String PATTERN = ".txt"; // Adjust this to your file type

    public static void main(String[] args) {
        File dir = new File(DIR);
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Please enter the directory:");
            if (dir.canRead() && dir.exists() && dir.isDirectory()) {
                printFilesInDirectory(dir, scanner.nextLine(), scanner.nextLine());
            } else {
                System.out.println("Directory does not exist or you do not have read access to it.");
            }
        }
    }

    private static void printFilesInDirectory(File dir, String searchName, String extension) {
        File[] files = dir.listFiles((dir1, name) -> name.endsWith(extension));
        if (files != null) {
            for (File file : files) {
                if (file.getName().contains(searchName)) {
                    System.out.println(file.getAbsolutePath());
                }
            }
        }
    }
}