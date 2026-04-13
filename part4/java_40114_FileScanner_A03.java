import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_40114_FileScanner_A03 {

    public static void main(String[] args) {

        File directory = new File(".");
        findSecretFile(directory);

    }

    public static void findSecretFile(File directory) {

        FileFilter fileFilter = new FileFilter() {
            public boolean accept(File pathname) {
                return pathname.getName().equals("secret.txt");
            }
        };

        File[] foundFiles = directory.listFiles(fileFilter);

        if (foundFiles != null) {
            for (File file : foundFiles) {
                if (file.isFile()) {
                    System.out.println("Found secret file: " + file.getAbsolutePath());
                }
            }
        } else {
            System.out.println("No secret files found in " + directory.getAbsolutePath());
        }
    }
}