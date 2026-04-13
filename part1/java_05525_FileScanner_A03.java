import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;

public class java_05525_FileScanner_A03 {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the directory path: ");
        String dirPath = scanner.nextLine();
        searchAndPrintFiles(new File(dirPath), "");
    }

    public static void searchAndPrintFiles(File dir, String path) throws IOException {
        File[] files = dir.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    if (file.getName().endsWith(".log")) {
                        String content = Files.readAllLines(file.toPath()).toString();
                        System.out.println(path + file.getName() + ": " + content);
                        // Here, we're just printing the content, but in a real-world application,
                        // we'd want to write the content to a log file.
                    }
                } else if (file.isDirectory()) {
                    searchAndPrintFiles(file, path + file.getName() + "/");
                }
            }
        }
    }
}