import java.io.File;
import java.io.FilenameFilter;

public class java_10142_FileScanner_A01 {
    private final String directoryPath;

    public java_10142_FileScanner_A01(String directoryPath) {
        this.directoryPath = directoryPath;
    }

    public void scan() {
        File directory = new File(directoryPath);
        if (directory.exists() && directory.isDirectory()) {
            searchFile(directory);
        } else {
            System.out.println("Directory does not exist or it is not a directory.");
        }
    }

    private void searchFile(File directory) {
        File[] files = directory.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.toLowerCase().endsWith(".txt");
            }
        });

        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    System.out.println("File found: " + file.getAbsolutePath());
                } else {
                    System.out.println("Directory found: " + file.getAbsolutePath());
                    searchFile(file); // recursive call
                }
            }
        }
    }

    public static void main(String[] args) {
        FileScanner scanner = new FileScanner("C:\\path\\to\\your\\directory"); // replace with your directory path
        scanner.scan();
    }
}