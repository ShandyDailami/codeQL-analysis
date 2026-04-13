import java.io.File;
import java.util.Scanner;

public class java_02605_FileScanner_A07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();

        File directory = new File(directoryPath);

        if (directory.exists()) {
            listFiles(directory, "A");
        } else {
            System.out.println("Directory does not exist");
        }

        scanner.close();
    }

    private static void listFiles(File directory, String letter) {
        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isFile() && file.getName().startsWith(letter) && file.getName().endsWith(".java")) {
                    System.out.println(file.getAbsolutePath());
                } else if (file.isDirectory()) {
                    listFiles(file, letter);
                }
            }
        }
    }
}