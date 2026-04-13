import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class java_40284_FileScanner_A08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the directory path: ");
        String directoryPath = scanner.nextLine();

        File directory = new File(directoryPath);
        List<File> txtFiles = new ArrayList<>();

        if (directory.exists() && directory.isDirectory()) {
            File[] files = directory.listFiles((dir, name) -> name.endsWith(".txt"));
            for (File file : files) {
                if (file.isFile() && !file.isHidden()) {
                    txtFiles.add(file);
                }
            }

            if (txtFiles.isEmpty()) {
                System.out.println("No .txt files found in the directory.");
            } else {
                for (File txtFile : txtFiles) {
                    System.out.println("Found .txt file: " + txtFile.getAbsolutePath());
                }
            }
        } else {
            System.out.println("Invalid directory or it is not a directory.");
        }

        scanner.close();
    }
}