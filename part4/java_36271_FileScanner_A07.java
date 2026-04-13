import java.io.File;
import java.io.FileFilter;

public class java_36271_FileScanner_A07 {

    public static void main(String[] args) {
        String directoryPath = "/path/to/your/directory"; // replace with your directory path

        File directory = new File(directoryPath);

        File[] txtFiles = directory.listFiles(new FileFilter() {
            public boolean accept(File pathname) {
                return pathname.isFile() && pathname.getName().endsWith(".txt");
            }
        });

        if (txtFiles != null) {
            for (File txtFile : txtFiles) {
                System.out.println(txtFile.getAbsolutePath());
            }
        } else {
            System.out.println("No .txt files found in the directory.");
        }
    }
}