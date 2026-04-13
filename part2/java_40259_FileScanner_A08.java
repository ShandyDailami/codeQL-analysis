import java.io.File;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class java_40259_FileScanner_A08 {
    public static void main(String[] args) {
        Set<String> uniqueFiles = new HashSet<>();

        // Use FileScanner to find all files in the directory.
        FileScanner fileScanner = new FileScanner(new File("."), new String[] {"txt"}, true);

        while (fileScanner.hasNext()) {
            File file = fileScanner.nextFile();
            uniqueFiles.add(file.getPath());
        }

        // Print out all unique files.
        for (String path : uniqueFiles) {
            System.out.println(path);
        }
    }
}

class FileScanner {
    private File[] files;
    private int index;

    public java_40259_FileScanner_A08(File dir, String[] extensions, boolean recurse) {
        // Implementation not provided in this task
        throw new UnsupportedOperationException();
    }

    public boolean hasNext() {
        return index < files.length;
    }

    public File nextFile() {
        return files[index++];
    }
}