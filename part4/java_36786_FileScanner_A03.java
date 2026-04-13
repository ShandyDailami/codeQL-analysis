import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class java_36786_FileScanner_A03 {
    public static void main(String[] args) {
        List<File> directories = new ArrayList<>();
        List<File> files = new ArrayList<>();

        // Get all root directories
        File[] roots = File.listRoots();
        for (File root : roots) {
            directories.addAll(listDirectories(root));
        }

        // Get all files in the root directories
        for (File dir : directories) {
            files.addAll(listFiles(dir));
        }

        // Print directories and files
        System.out.println("Directories:");
        for (File dir : directories) {
            System.out.println(dir.getPath());
        }

        System.out.println("Files:");
        for (File file : files) {
            System.out.println(file.getPath());
        }
    }

    private static List<File> listDirectories(File dir) {
        List<File> directories = new ArrayList<>();
        File[] subDirs = dir.listFiles();
        if (subDirs != null) {
            for (File subDir : subDirs) {
                if (subDir.isDirectory()) {
                    directories.add(subDir);
                    directories.addAll(listDirectories(subDir));
                }
            }
        }
        return directories;
    }

    private static List<File> listFiles(File dir) {
        List<File> files = new ArrayList<>();
        File[] subFiles = dir.listFiles();
        if (subFiles != null) {
            for (File subFile : subFiles) {
                if (!subFile.isDirectory()) {
                    files.add(subFile);
                }
            }
        }
        return files;
    }
}