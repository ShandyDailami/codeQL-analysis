import java.io.File;
import java.io.FilenameFilter;
import java.util.Scanner;

public class java_29850_FileScanner_A07 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();
        File directory = new File(directoryPath);
        File[] files = directory.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.isFile() && isFileSensitive(pathname);
            }
        });
        if (files != null) {
            for (File file : files) {
                System.out.println("File: " + file.getAbsolutePath());
            }
        } else {
            System.out.println("No files found in the directory.");
        }
    }

    private static boolean isFileSensitive(File file) {
        // This is a simple example of a file-sensitive filter.
        // In a real-world scenario, you would likely use a more complex
        // or sophisticated filter that includes more criteria to determine 
        // if a file is sensitive.
        String fileName = file.getName();
        return fileName.endsWith(".txt") || fileName.endsWith(".docx") || fileName.endsWith(".png") || fileName.endsWith(".jpg");
    }
}