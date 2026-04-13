import java.io.File;
import java.util.Scanner;

public class java_28166_FileScanner_A01 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();

        File directory = new File(directoryPath);

        if (directory.exists()) {
            listFiles(directory, directoryPath);
        } else {
            System.out.println("The directory does not exist.");
        }

        scanner.close();
    }

    private static void listFiles(File directory, String path) {
        for (File file : directory.listFiles()) {
            if (file.isFile()) {
                System.out.println(path + "/" + file.getName());
            } else if (file.isDirectory()) {
                listFiles(file, path + "/" + file.getName());
            }
        }
    }
}