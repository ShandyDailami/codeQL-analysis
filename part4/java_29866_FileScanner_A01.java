import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_29866_FileScanner_A01 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String dirPath = scanner.nextLine();

        File dir = new File(dirPath);

        if (!dir.exists()) {
            System.out.println("Directory does not exist!");
            System.exit(1);
        }

        FileFilter filter = new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.getName().endsWith(".java");
            }
        };

        try {
            findJavaFiles(dir, filter);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void findJavaFiles(File dir, FileFilter filter) throws FileNotFoundException {
        File[] files = dir.listFiles(filter);
        if (files == null) return;

        for (File file : files) {
            if (file.isDirectory()) {
                findJavaFiles(file, filter);
            } else {
                System.out.println("Found Java file: " + file.getPath());
            }
        }
    }
}