import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.util.Scanner;

public class java_00678_FileScanner_A07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter directory path: ");
        String dirPath = scanner.nextLine();

        File dir = new File(dirPath);
        if (!dir.exists()) {
            System.out.println("Directory does not exist");
            return;
        }

        if (args.length == 0) {
            listFiles(dir);
        } else {
            listMatchingFiles(dir, args[0]);
        }
    }

    public static void listFiles(File dir) {
        File[] files = dir.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isFile() && file.getName().endsWith(".txt")) {
                    listMatchingFiles(file.getParentFile(), "AuthFailure");
                }
            }
        }
    }

    public static void listMatchingFiles(File dir, String keyword) {
        File[] files = dir.listFiles(new FileFilter() {
            public boolean accept(File pathname) {
                return pathname.getName().toLowerCase().contains(keyword);
            }
        });
        if (files != null) {
            for (File file : files) {
                System.out.println(file.getPath());
            }
        }
    }
}