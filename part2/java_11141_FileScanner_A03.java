import java.io.File;
import java.io.FileFilter;
import java.util.Arrays;

public class java_11141_FileScanner_A03 {
    public static void main(String[] args) {
        String directoryPath = "/path/to/directory"; // replace with your directory path

        File directory = new File(directoryPath);

        if (!directory.exists()) {
            System.out.println("Directory does not exist");
            return;
        }

        // Use the custom FileFilter to find all files in the directory
        File[] allFiles = directory.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                // Check if the file is a directory
                if (pathname.isDirectory()) {
                    return false;
                }
                // Check if the file's name ends with a specific extension
                String name = pathname.getName();
                return name.toLowerCase().endsWith(".txt");
            }
        });

        if (allFiles != null) {
            Arrays.stream(allFiles).forEach(file -> System.out.println(file.getPath()));
        } else {
            System.out.println("No files found with the specified extension (.txt) in the directory");
        }
    }
}