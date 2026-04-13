import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.Scanner;

public class java_28956_FileScanner_A01 implements FileFilter {
    private String[] dirs;
    private String[] exts;

    public java_28956_FileScanner_A01(String[] dirs, String[] exts) {
        this.dirs = dirs;
        this.exts = exts;
    }

    public boolean accept(File pathname) {
        // Check if the file is a directory
        if (pathname.isDirectory()) {
            String name = pathname.getName();
            return Arrays.asList(dirs).contains(name);
        }

        // Check if the file extension is in the list of allowed extensions
        String name = pathname.getName();
        int lastDot = name.lastIndexOf('.');
        if (lastDot == -1) return false;
        String extension = name.substring(lastDot + 1);
        return Arrays.asList(exts).contains(extension);
    }

    public static void main(String[] args) {
        // Check if the user has provided directories and file extensions
        if (args.length != 2) {
            System.out.println("Usage: SecurityFileScanner <dir> <ext>");
            System.exit(1);
        }

        String[] dirs = args[0].split(",");
        String[] exts = args[1].split(",");

        try {
            SecurityFileScanner scanner = new SecurityFileScanner(dirs, exts);
            File[] roots = File.listRoots();
            for (File root : roots) {
                printDirectory(root, scanner);
            }
        } catch (SecurityException e) {
            System.err.println("Cannot access directory: " + e.getDirectory() + ": " + e.getMessage());
        }
    }

    private static void printDirectory(File dir, FileFilter filter) {
        File[] files = dir.listFiles(filter);
        if (files == null) return;
        for (File file : files) {
            if (file.isDirectory()) {
                printDirectory(file, filter);
            } else {
                System.out.println(file.getAbsolutePath());
            }
        }
    }
}