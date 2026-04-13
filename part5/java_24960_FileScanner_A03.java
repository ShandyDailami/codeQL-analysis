import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.Scanner;

public class java_24960_FileScanner_A03 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the name of the file you want to search:");
        String filename = scanner.nextLine();
        File dir = new File(".");

        String[] files = dir.list(new FilenameFilter() {
            public boolean accept(File dir, String name) {
                return name.endsWith(filename);
            }
        });

        if(files != null) {
            System.out.println("Files ending with " + filename + ": " + Arrays.toString(files));
        } else {
            System.out.println("No files found in the current directory or subdirectories!");
        }
    }
}