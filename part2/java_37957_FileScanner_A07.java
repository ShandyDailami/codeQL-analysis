import java.io.File;
import java.io.FileFilter;

public class java_37957_FileScanner_A07 {

    public static void main(String[] args) {
        String directoryPath = "/path/to/directory";
        File directory = new File(directoryPath);
        
        File[] hiddenFiles = directory.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.isHidden();
            }
        });
        
        if (hiddenFiles != null) {
            for (File file : hiddenFiles) {
                if (file.getName().endsWith(".txt") && file.canRead()) {
                    System.out.println("File: " + file.getAbsolutePath());
                }
            }
        } else {
            System.out.println("No hidden files in directory");
        }
    }
}