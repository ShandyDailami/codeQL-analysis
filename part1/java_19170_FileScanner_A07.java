import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class java_19170_FileScanner_A07 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter the directory path: ");
        String directoryPath = scanner.nextLine();

        List<File> txtFiles = new ArrayList<>();
        File directory = new File(directoryPath);

        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isFile() && file.getName().endsWith(".txt") && !file.getName().startsWith(".")) {
                    txtFiles.add(file);
                }
            }
        }

        for (File file : txtFiles) {
            System.out.println("File name: " + file.getName());
        }

        scanner.close();
    }
}