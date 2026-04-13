import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class java_12499_FileScanner_A07 {
    public static void main(String[] args) throws IOException {
        String dirPath = "/path/to/directory"; // Replace with your directory path
        String extension = ".txt"; // Replace with your file extension

        File directory = new File(dirPath);

        File[] filesWithExtension = directory.listFiles(new FilenameFilter() {
            public boolean accept(File dir, String name) {
                return name.endsWith(extension);
            }
        });

        if (filesWithExtension != null) {
            for (File file : filesWithExtension) {
                Path path = Paths.get(file.getAbsolutePath());

                // Security-sensitive operation: Checking if the file is readable
                if (Files.isReadable(path)) {
                    System.out.println("File " + file.getName() + " is readable.");
                } else {
                    System.out.println("File " + file.getName() + " is not readable.");
                }

                // Security-sensitive operation: Checking if the file has a specific attribute
                if (Files.isSameFile(path, "/path/to/other/file")) {
                    System.out.println("File " + file.getName() + " is the same file.");
                } else {
                    System.out.println("File " + file.getName() + " is not the same file.");
                }

                // Security-sensitive operation: Checking if the file has the correct permissions
                if (Files.isReadable(path) && Files.isWritable(path)) {
                    System.out.println("File " + file.getName() + " has the correct permissions.");
                } else {
                    System.out.println("File " + file.getName() + " does not have the correct permissions.");
                }
            }
        }
    }
}