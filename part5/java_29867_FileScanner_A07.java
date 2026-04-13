import java.io.File;
import java.io.FilenameFilter;

public class java_29867_FileScanner_A07 {
    public static void main(String[] args) {
        File directory = new File(".");
        String[] extensions = {"txt", "jpg", "png", "gif", "jpeg"};
        scanDirectory(directory, extensions);
    }

    private static void scanDirectory(File directory, String[] extensions) {
        File[] listOfFiles = directory.listFiles(new FileFilter() {
            public boolean accept(File file) {
                if (file.isDirectory()) {
                    return true;
                } else {
                    String name = file.getName();
                    for (String extension : extensions) {
                        if (name.endsWith(extension)) {
                            return true;
                        }
                    }
                }
                return false;
            }
        });

        if (listOfFiles != null) {
            for (File file : listOfFiles) {
                if (file.isDirectory()) {
                    scanDirectory(file, extensions);
                } else {
                    System.out.println("File: " + file.getAbsolutePath());
                }
            }
        }
    }
}