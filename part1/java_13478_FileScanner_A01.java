import java.io.File;
import java.util.Scanner;

public class java_13478_FileScanner_A01 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a prefix: ");
        String prefix = scanner.next();

        File directory = new File(".");

        printFiles(directory, prefix);
    }

    private static void printFiles(File directory, String prefix) {
        File[] list = directory.listFiles();
        if (list != null) {
            for (File file : list) {
                if (file.getName().startsWith(prefix)) {
                    System.out.println(file.getAbsolutePath());
                }
            }
        }
    }
}