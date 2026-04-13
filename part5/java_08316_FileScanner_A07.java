import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_08316_FileScanner_A07 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the minimum size (in bytes) for the files you want to scan:");
        long minSize = scanner.nextLong();

        FileFilter filter = (File file) -> {
            return file.length() >= minSize;
        };

        File root = new File(".");

        if (args.length == 1) {
            root = new File(args[0]);
        }

        try {
            findFiles(root, filter);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void findFiles(File dir, FileFilter filter) throws FileNotFoundException {
        File[] files = dir.listFiles(filter);

        if (files == null) return;

        for (File file : files) {
            if (file.isDirectory()) {
                findFiles(file, filter);
            } else {
                System.out.println(file.getAbsolutePath());
            }
        }
    }
}