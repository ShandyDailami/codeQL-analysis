import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class java_37600_FileScanner_A03 {
    private static final String DIR = "src/main/java";
    private static final String EXT = ".java";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter directory:");
        String dir = scanner.nextLine();

        File f = new File(dir);
        if (f.isDirectory()) {
            File[] files = f.listFiles((dir1, name) -> name.endsWith(EXT));
            if (files != null) {
                Arrays.stream(files).forEach(FileScanner::printFileInfo);
            } else {
                System.out.println("No java files found in the directory.");
            }
        } else {
            System.out.println("Not a directory.");
        }

        scanner.close();
    }

    private static void printFileInfo(File file) {
        System.out.println("File name: " + file.getName());
        System.out.println("File path: " + file.getPath());
        System.out.println("File absolute path: " + file.getAbsolutePath());
        System.out.println("File last modified: " + file.lastModified());
        System.out.println("---------------------");
    }
}