import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class java_03637_FileScanner_A08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter directory path:");
        String path = scanner.nextLine();
        printDirectoryContents(new File(path));
    }

    private static void printDirectoryContents(File dir) {
        File[] files = dir.listFiles();
        if (files != null) {
            Arrays.stream(files)
                  .forEach(file -> {
                      if (file.isDirectory()) {
                          printDirectoryContents(file);
                      } else {
                          System.out.println(file.getAbsolutePath());
                      }
                  });
        }
    }
}