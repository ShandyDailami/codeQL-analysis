import java.io.File;
import java.util.Scanner;

public class java_13320_FileScanner_A08 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();

        File rootDirectory = new File(directoryPath);
        getAllFiles(rootDirectory, ".txt");
    }

    private static void getAllFiles(File directory, String extension) {
        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isFile() && file.getName().endsWith(extension)) {
                    System.out.println("File name: " + file.getName());
                    System.out.println("File path: " + file.getPath());
                    System.out.println("-----------------------");
                } else if (file.isDirectory()) {
                    getAllFiles(file, extension);
                }
            }
        }
    }
}