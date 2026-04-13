import java.io.File;
import java.util.Scanner;

public class java_40764_FileScanner_A01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String path = scanner.nextLine();

        File directory = new File(path);

        if (directory.exists()) {
            fileScan(directory, ".txt");
        } else {
            System.out.println("Directory does not exist");
        }
    }

    public static void fileScan(File directory, String extension) {
        for (File file : directory.listFiles()) {
            if (file.isFile() && file.getName().endsWith(extension)) {
                try {
                    Scanner scanner = new Scanner(file);
                    while (scanner.hasNextLine()) {
                        String line = scanner.nextLine();
                        System.out.println(line);
                    }
                    scanner.close();
                } catch (Exception e) {
                    System.out.println("Error reading file: " + file.getName());
                }
            } else if (file.isDirectory()) {
                fileScan(file, extension);
            }
        }
    }
}