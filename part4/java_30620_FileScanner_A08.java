import java.io.File;
import java.io.FileFilter;
import java.util.Arrays;

public class java_30620_FileScanner_A08 {
    private String directory;
    private String extension;

    public java_30620_FileScanner_A08(String directory, String extension) {
        this.directory = directory;
        this.extension = extension;
    }

    public void scan() {
        File file = new File(directory);
        if (file.exists()) {
            File[] list = file.listFiles(new FileFilter() {
                @Override
                public boolean accept(File pathname) {
                    return pathname.isDirectory() || (pathname.getName().endsWith(extension));
                }
            });

            if (list != null) {
                Arrays.stream(list).forEach(f -> printFiles(f, ""));
            } else {
                System.out.println("Directory not found.");
            }
        } else {
            System.out.println("Directory does not exist.");
        }
    }

    private void printFiles(File file, String indentation) {
        for (int i = 0; i < indentation.length(); i++) {
            System.out.print("-");
        }
        System.out.println(file.getName());

        if (file.isDirectory()) {
            File[] list = file.listFiles(new FileFilter() {
                @Override
                public boolean accept(File pathname) {
                    return pathname.isDirectory() || (pathname.getName().endsWith(extension));
                }
            });

            if (list != null) {
                Arrays.stream(list).forEach(f -> printFiles(f, indentation + "-"));
            }
        }
    }

    public static void main(String[] args) {
        new FileScanner(".", ".txt").scan();
    }
}