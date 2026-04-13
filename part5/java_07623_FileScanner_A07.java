import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;

public class java_07623_FileScanner_A07 {
    public static void main(String[] args) {
        String directoryPath = "/path/to/directory"; // replace with your directory path
        File directory = new File(directoryPath);
        
        if (directory.exists() && directory.isDirectory()) {
            File[] txtFiles = directory.listFiles(new FileFilter() {
                @Override
                public boolean accept(File pathname) {
                    return (pathname.isFile() && pathname.getName().endsWith(".txt"));
                }
            });
            
            if (txtFiles != null) {
                for (File txtFile : txtFiles) {
                    System.out.println("Found text file: " + txtFile.getAbsolutePath());
                }
            } else {
                System.out.println("No text files found in directory: " + directoryPath);
            }
        } else {
            System.out.println("Invalid directory: " + directoryPath);
        }
    }
}