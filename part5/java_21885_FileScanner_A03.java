import java.io.File;
import java.io.FileFilter;

public class java_21885_FileScanner_A03 {
    public static void main(String[] args) {
        String directoryPath = "/path/to/directory"; // Replace with your directory path

        File directory = new File(directoryPath);

        File[] txtFiles = directory.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.isFile() && pathname.getName().endsWith(".txt");
            }
        });

        if (txtFiles != null) {
            for (File txtFile : txtFiles) {
                System.out.println(txtFile.getAbsolutePath());
            }
        } else {
            System.out.println("No .txt files found in the directory");
        }
    }
}