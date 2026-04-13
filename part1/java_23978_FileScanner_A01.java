import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;

public class java_23978_FileScanner_A01 {
    public static void main(String[] args) throws IOException {
        String directoryPath = "/path/to/directory"; // replace with your directory path
        File directory = new File(directoryPath);

        if (!directory.exists()) {
            throw new IllegalArgumentException("Directory does not exist");
        }

        if (!directory.canRead()) {
            throw new SecurityException("Cannot read directory");
        }

        File[] files = directory.listFiles();
        if (files == null) {
            throw new IOException("Error listing files in directory");
        }

        FilenameFilter filter = (dir, name) -> name.endsWith(".txt");
        long sum = 0;
        for (File file : files) {
            if (file.isFile() && filter.accept(directory, file.getName())) {
                sum += file.length();
            }
        }

        System.out.println("Total size of .txt files: " + sum);
    }
}