import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class java_01217_FileScanner_A07 {
    private static int lineCount = 0;

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the directory path: ");
        String path = scanner.next();

        File file = new File(path);

        if (file.exists()) {
            scanDirectory(file);
            System.out.println("Number of lines of code: " + lineCount);
        } else {
            System.out.println("The path does not exist");
        }

        scanner.close();
    }

    private static void scanDirectory(File directory) throws IOException {
        for (File file : directory.listFiles()) {
            if (file.isDirectory()) {
                scanDirectory(file);
            } else if (file.isFile()) {
                scanFile(file);
            }
        }
    }

    private static void scanFile(File file) throws IOException {
        if (file.canRead()) {
            for (String line : new java.util.Scanner(file).useDelimiter("\\A").next().split("\n")) {
                lineCount++;
            }
        }
    }
}