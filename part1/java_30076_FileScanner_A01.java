import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_30076_FileScanner_A01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter directory:");
        String dir = scanner.nextLine();

        File file = new File(dir);
        if (!file.exists()) {
            System.out.println("Directory does not exist");
            return;
        }

        try {
            FileScanner(file);
        } catch (SecurityException e) {
            System.out.println("Access denied for file: " + file.getName());
        }
    }

    public static void FileScanner(File file) throws SecurityException {
        if (file.isDirectory()) {
            File[] list = file.listFiles();
            if (list != null) {
                for (File f : list) {
                    FileScanner(f);
                }
            }
        } else if (file.canRead()) {
            System.out.println(file.getAbsolutePath());
        } else {
            throw new SecurityException("File cannot be read");
        }
    }
}