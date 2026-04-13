import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.List;

public class java_33149_FileScanner_A07 {
    public static void main(String[] args) {
        File currentDir = new File(".");
        List<File> txtFiles = new ArrayList<>();

        currentDir.deleteOnExit(); // delete this directory and its contents when the program ends

        // Traverse directory and print all txt files
        findTextFiles(currentDir, txtFiles);

        for (File txtFile : txtFiles) {
            System.out.println(txtFile.getAbsolutePath());
        }
    }

    private static void findTextFiles(File directory, List<File> txtFiles) {
        File[] files = directory.listFiles(new FileFilter() {
            public boolean accept(File pathname) {
                return pathname.isFile() && pathname.getName().endsWith(".txt");
            }
        });

        if (files != null) {
            for (File file : files) {
                txtFiles.add(file);
            }
        }

        // Traverse all subdirectories
        for (File file : directory.listFiles()) {
            if (file.isDirectory()) {
                findTextFiles(file, txtFiles);
            }
        }
    }
}