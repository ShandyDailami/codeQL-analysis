import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class java_01291_FileScanner_A03 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter directory path:");
        String directoryPath = scanner.nextLine();

        FileFilter filter = new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.isFile() && pathname.getName().endsWith(".txt");
            }
        };

        File directory = new File(directoryPath);
        List<File> txtFiles = new ArrayList<>(directory.listFiles(filter));

        if (txtFiles.isEmpty()) {
            System.out.println("No text files found in directory.");
            return;
        }

        System.out.println("Writing filtered file names to 'filtered_files.txt'...");
        try (java.io.PrintWriter writer = new java.io.PrintWriter(new java.io.FileWriter("filtered_files.txt"))) {
            for (File file : txtFiles) {
                writer.println(file.getName());
            }
        } catch (Exception e) {
            System.out.println("An error occurred while writing to 'filtered_files.txt'.");
        }

        System.out.println("Operation completed.");
    }
}