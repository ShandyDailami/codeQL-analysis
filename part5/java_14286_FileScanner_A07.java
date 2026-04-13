import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class java_14286_FileScanner_A07 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String path = scanner.nextLine();

        File directory = new File(path);

        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    long length = file.length();
                    if (length < 200) {
                        System.out.println("File: " + file.getName() + ", Length: " + length + " bytes");
                    }
                }
            }
        }
    }
}