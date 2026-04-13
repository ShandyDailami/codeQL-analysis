import java.io.File;
import java.io.FilenameFilter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class java_38863_FileScanner_A07 {

    public static void main(String[] args) {
        String rootDirectory = "/path/to/your/directory"; // replace with your directory path
        File directory = new File(rootDirectory);
        String[] extensions = {"txt", "pdf"}; // replace with your file extensions

        File[] files = directory.listFiles(new FileFilter() {
            public boolean accept(File pathname) {
                for (String extension : extensions) {
                    if (pathname.getName().endsWith(extension)) {
                        return true;
                    }
                }
                return false;
            }
        });

        if (files != null) {
            for (File file : files) {
                Path path = Paths.get(file.getPath());
                try {
                    // Read the contents of the file
                    byte[] bytes = Files.readAllBytes(path);

                    // Process the file contents here (for example, check for auth failure)
                    // You would replace this with your own logic for security-sensitive operations

                    // Here's a simple example: print the file path
                    System.out.println("File: " + file.getPath());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}