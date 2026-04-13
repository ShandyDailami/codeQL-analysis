import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class java_24818_FileScanner_A03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path: ");
        String directoryPath = scanner.nextLine();

        File directory = new File(directoryPath);

        if (directory.exists()) {
            File[] listOfFiles = directory.listFiles();

            if (listOfFiles != null) {
                Arrays.stream(listOfFiles).forEach(file -> {
                    if (file.isFile()) {
                        String name = file.getName();
                        String extension = name.substring(name.lastIndexOf("."));

                        if (extension.equals(".txt")) {
                            System.out.println("File: " + file.getPath());
                        }
                    }
                });
            }
        } else {
            System.out.println("Directory does not exist!");
        }

        scanner.close();
    }
}