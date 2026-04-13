import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.List;

public class java_20894_FileScanner_A08 {

    public static void main(String[] args) {
        File dir = new File("C:\\path_to_directory");
        List<File> listOfFiles = getFiles(dir, new FileExtensionFilter("txt"));
        for (File file : listOfFiles) {
            System.out.println("File Name: " + file.getName() + ", File Path: " + file.getAbsolutePath());
        }
    }

    private static List<File> getFiles(File dir, FileFilter filter) {
        List<File> files = new ArrayList<>();
        File[] foundFiles = dir.listFiles(filter);
        if (foundFiles != null) {
            for (File file : foundFiles) {
                if (file.isFile()) {
                    files.add(file);
                } else if (file.isDirectory()) {
                    files.addAll(getFiles(file, filter));
                }
            }
        }
        return files;
    }

    private static class FileExtensionFilter implements FileFilter {
        private String extension;

        public java_20894_FileScanner_A08(String extension) {
            this.extension = "." + extension;
        }

        @Override
        public boolean accept(File pathname) {
            return pathname.getName().toLowerCase().endsWith(extension);
        }
    }
}