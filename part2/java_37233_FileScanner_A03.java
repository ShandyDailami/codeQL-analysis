import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.Scanner;

public class java_37233_FileScanner_A03 {
    public static void main(String[] args) {
        File file = new File(".");

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a file name:");
        String fileName = scanner.nextLine();

        FilenameFilter filter = new FilenameFilter() {
            public boolean accept(File dir, String name) {
                return name.equalsIgnoreCase(fileName);
            }
        };

        File[] list = file.listFiles(filter);

        if (list == null) {
            System.out.println("No file found with the name " + fileName);
            return;
        }

        for (File f : list) {
            if (f.isFile()) {
                System.out.println(f.getAbsolutePath());
            } else if (f.isDirectory()) {
                System.out.println(f.getAbsolutePath() + " directory");
            }
        }
    }
}