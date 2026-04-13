import java.io.File;
import java.util.Arrays;
import java.util.List;

public class java_39478_FileScanner_A01 {
    private List<String> directories;
    private List<String> files;

    public java_39478_FileScanner_A01(String directoryPath) {
        File directory = new File(directoryPath);
        if (!directory.exists()) {
            throw new IllegalArgumentException("Directory not found");
        }
        if (!directory.isDirectory()) {
            throw new IllegalArgumentException("Provided path is not a directory");
        }

        directories = Arrays.asList(directory.list());
        directories.remove(".");
        directories.remove("..");

        File[] listOfFiles = directory.listFiles();
        files = new ArrayList<>();

        for (File file : listOfFiles) {
            if (file.isFile()) {
                files.add(file.getName());
            }
        }
    }

    public void printDirectories() {
        for (String s : directories) {
            System.out.println(s);
        }
    }

    public void printFiles() {
        for (String s : files) {
            System.out.println(s);
        }
    }

    public static void main(String[] args) {
        FileScanner scanner = new FileScanner(".");
        scanner.printDirectories();
        scanner.printFiles();
    }
}