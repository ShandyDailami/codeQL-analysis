import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_24740_FileScanner_A08 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();

        printFiles(new File(directoryPath));
    }

    private static void printFiles(File file) throws FileNotFoundException {
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            if (files != null) {
                for (File f : files) {
                    printFiles(f);
                }
            }
        } else {
            if (file.getName().endsWith(".txt")) {
                System.out.println(file.getAbsolutePath());
            }
        }
    }
}