import java.io.File;
import java.util.Scanner;

public class java_19247_FileScanner_A01 {
    public static void main(String[] args) {
        String directoryPath = System.getProperty("user.dir");
        File directory = new File(directoryPath);

        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    try (Scanner scanner = new Scanner(file)) {
                        System.out.println("File: " + file.getName());
                        while (scanner.hasNextLine()) {
                            System.out.println(scanner.nextLine());
                        }
                    }
                }
            }
        }
    }
}