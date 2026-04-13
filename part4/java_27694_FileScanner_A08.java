import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;

public class java_27694_FileScanner_A08 {
    public static void main(String[] args) {
        String directory = "./src"; // Adjust this to your directory
        String[] extensions = {"txt", "java", "js", "html", "css"}; // Add more extensions if needed

        File startingDir = new File(directory);

        if (startingDir.exists() && startingDir.isDirectory()) {
            scanDirectory(startingDir, extensions);
        } else {
            System.out.println("Error: Directory " + directory + " does not exist or is not a directory.");
        }
    }

    private static void scanDirectory(File directory, String[] extensions) {
        File[] files = directory.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                if (pathname.isDirectory()) {
                    return true;
                }
                for (String extension : extensions) {
                    if (pathname.getName().toLowerCase().endsWith(extension)) {
                        return true;
                    }
                }
                return false;
            }
        });

        Arrays.stream(files).forEach(file -> {
            if (file.isFile()) {
                System.out.println("File: " + file.getAbsolutePath());
            } else if (file.isDirectory()) {
                System.out.println("Directory: " + file.getAbsolutePath());
                scanDirectory(file, extensions); // Recursive call
            }
        });
    }
}