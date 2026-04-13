import java.io.*;

public class java_03084_FileScanner_A03 {

    // FileScanner class uses FileFilter interface
    // to filter files based on some criteria
    public static void main(String[] args) throws IOException {
        String directory = "/path/to/directory";
        File file = new File(directory);

        // FileFilter is used to filter files or directories
        // here we are filtering files with .txt extension
        FileFilter txtFileFilter = new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.isFile() && pathname.getName().endsWith(".txt");
            }
        };

        // Recursive method to list files in directory
        listFiles(file, txtFileFilter);
    }

    private static void listFiles(File dir, FileFilter fileFilter) throws IOException {
        File[] files = dir.listFiles(fileFilter);

        if (files == null) {
            return;
        }

        for (File file : files) {
            if (file.isDirectory()) {
                listFiles(file, fileFilter);
            } else {
                System.out.println(file.getAbsolutePath());
            }
        }
    }
}