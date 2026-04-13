import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class java_22164_FileScanner_A03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String dirPath = scanner.nextLine();
        File directory = new File(dirPath);

        List<File> txtFiles = new ArrayList<>();
        searchForTxtFiles(directory, txtFiles);

        if(txtFiles.isEmpty()) {
            System.out.println("No .txt files found in the directory or its subdirectories!");
        } else {
            System.out.println("Found .txt files:");
            for (File txtFile : txtFiles) {
                System.out.println(txtFile.getAbsolutePath());
            }
        }
    }

    private static void searchForTxtFiles(File directory, List<File> txtFiles) {
        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isFile() && file.getName().endsWith(".txt")) {
                    txtFiles.add(file);
                } else if (file.isDirectory()) {
                    searchForTxtFiles(file, txtFiles);
                }
            }
        }
    }
}