import java.io.File;
import java.io.FileFilter;
import java.util.Arrays;
import java.util.Scanner;

public class java_36772_FileScanner_A01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter directory path:");
        String dirPath = scanner.nextLine();

        File dir = new File(dirPath);

        if (!dir.exists() || !dir.isDirectory()) {
            System.out.println("Invalid directory path.");
            return;
        }

        FileFilter filter = new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return true;
            }
        };

        File[] files = dir.listFiles(filter);

        if (files == null) {
            return;
        }

        Arrays.sort(files, (o1, o2) -> o1.getName().compareTo(o2.getName()));

        for (File file : files) {
            System.out.println(file.getAbsolutePath());
        }
    }
}