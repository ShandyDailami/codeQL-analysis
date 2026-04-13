import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class java_16264_FileScanner_A03 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();

        try {
            File directory = new File(directoryPath);

            if (directory.exists()) {
                File[] files = directory.listFiles();

                if (files != null) {
                    for (File file : files) {
                        if (file.isFile()) {
                            System.out.println("File name: " + file.getName());
                            System.out.println("File size: " + file.length() + " bytes");
                        }
                    }
                }
            } else {
                System.out.println("The specified directory does not exist.");
            }

            scanner.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}