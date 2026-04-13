import java.io.File;
import java.util.Scanner;

public class java_28537_FileScanner_A07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter directory path:");
        String directoryPath = scanner.next();

        File directory = new File(directoryPath);

        printFileNames(directory);

        scanner.close();
    }

    private static void printFileNames(File directory) {
        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    String name = file.getName();
                    int lastDotIndex = name.lastIndexOf('.');

                    if (lastDotIndex != -1) {
                        String extension = name.substring(lastDotIndex + 1);

                        if (!extension.equals("java")) {
                            continue;
                        }
                    }

                    System.out.println(name);
                }
            }
        }
    }
}