import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.Scanner;

public class java_07160_FileScanner_A01 {
    public static void main(String[] args) {
        File file = new File(".");

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a pattern: ");
        String pattern = scanner.next();

        file.list(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.matches(pattern);
            }
        });
    }
}