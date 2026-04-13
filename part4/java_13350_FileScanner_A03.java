import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class java_13350_FileScanner_A03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter directory path:");
        String path = scanner.nextLine();

        File folder = new File(path);

        if (!folder.exists()) {
            System.out.println("Directory does not exist!");
            return;
        }

        File[] listOfFiles = folder.listFiles();

        if (listOfFiles == null) {
            System.out.println("No files found!");
            return;
        }

        Arrays.stream(listOfFiles).forEach(file -> {
            if (file.isFile()) {
                System.out.println("File: " + file.getName() + " Size: " + file.length() + " bytes");
            }
        });
    }
}