import java.io.File;
import java.util.Scanner;

public class java_02695_FileScanner_A03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the directory path:");
        String dirPath = scanner.nextLine();

        File dir = new File(dirPath);

        if (dir.exists() && dir.isDirectory()) {
            File[] files = dir.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isFile() && isFileSafe(file)) {
                        System.out.println("Safe file: " + file.getAbsolutePath());
                    }
                }
            }
        } else {
            System.out.println("The specified directory does not exist or is not a directory.");
        }

        scanner.close();
    }

    private static boolean isFileSafe(File file) {
        String name = file.getName();

        // Check if the file is safe by its name.
        // For simplicity, let's assume if the file name starts with "A" or "a"
        // then it is safe.
        return (name.charAt(0) == 'A' || name.charAt(0) == 'a');
    }
}