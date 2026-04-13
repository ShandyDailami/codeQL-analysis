import java.io.File;
import java.io.FilenameFilter;
import java.util.Scanner;

public class java_11793_FileScanner_A07 {

    private static String targetDirectory;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter target directory:");
        targetDirectory = scanner.nextLine();

        File file = new File(targetDirectory);
        if (!file.exists()) {
            System.out.println("Directory does not exist");
            System.exit(1);
        }

        file.listFiles(new FilenameFilter() {
            public boolean accept(File dir, String name) {
                return new File(dir, name).isFile();
            }
        });
    }
}