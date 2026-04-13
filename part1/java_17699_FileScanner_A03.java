import java.io.File;
import java.io.FilenameFilter;

public class java_17699_FileScanner_A03 {

    public static void main(String[] args) {
        String directory = "/path/to/directory"; // replace with your directory
        fileScan(directory, new FileExtensionFilter(".txt"));
    }

    private static void fileScan(String directory, FilenameFilter filter) {
        File folder = new File(directory);
        File[] listOfFiles = folder.listFiles(filter);

        if (listOfFiles != null) {
            for (File file : listOfFiles) {
                if (file.isFile()) {
                    System.out.println("File: " + file.getAbsolutePath());
                } else if (file.isDirectory()) {
                    System.out.println("Directory: " + file.getAbsolutePath());
                    fileScan(file.getAbsolutePath(), filter);
                }
           
            }
        }
    }

    private static class FileExtensionFilter implements FilenameFilter {
        private String extension;

        public java_17699_FileScanner_A03(String extension) {
            this.extension = extension;
        }

        @Override
        public boolean accept(File dir, String name) {
            return name.endsWith(this.extension);
        }
    }
}