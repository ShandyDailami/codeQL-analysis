import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.regex.Pattern;

public class java_05548_FileScanner_A01 {
    private final String targetDirectory;
    private final String targetExtension;

    public java_05548_FileScanner_A01(String targetDirectory, String targetExtension) {
        this.targetDirectory = targetDirectory;
        this.targetExtension = targetExtension;
    }

    public void scan() {
        File rootDirectory = new File(targetDirectory);
        File[] matchingFiles = rootDirectory.listFiles(new FileFilter() {
            public boolean accept(File pathname) {
                return pathname.isFile() && pathname.getName().endsWith(targetExtension);
            }
        });

        if (matchingFiles != null) {
            Arrays.sort(matchingFiles, new java.util.Comparator<File>() {
                public int compare(File o1, File o2) {
                    return o1.getName().compareTo(o2.getName());
                }
            });

            for (File file : matchingFiles) {
                System.out.println("Found file: " + file.getAbsolutePath());
            }
        } else {
            System.out.println("No files with the extension " + targetExtension + " found in the directory " + targetDirectory);
        }
    }

    public static void main(String[] args) {
        new SecureFileScanner(".", ".txt").scan();
    }
}