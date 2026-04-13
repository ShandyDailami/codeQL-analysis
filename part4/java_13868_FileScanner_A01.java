import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class java_13868_FileScanner_A01 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter directory path: ");
        String path = scanner.nextLine();
        File startDir = new File(path);

        if (startDir.exists() && startDir.isDirectory()) {
            List<File> files = getFilesWithExtension(startDir, new String[]{"txt", "java"});
            for (File file : files) {
                System.out.println(file.getAbsolutePath());
            }
        } else {
            System.out.println("Invalid directory or no such directory.");
        }
    }

    private static List<File> getFilesWithExtension(File directory, String[] extensions) {
        List<File> result = new ArrayList<>();
        FilenameFilter filter = new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                for (String extension : extensions) {
                    if (name.endsWith(extension)) {
                        return true;
                    }
                }
                return false;
            }
        };
        File[] files = directory.listFiles(filter);
        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    result.add(file);
                } else if (file.isDirectory()) {
                    result.addAll(getFilesWithExtension(file, extensions));
                }
            }
        }
        return result;
    }
}