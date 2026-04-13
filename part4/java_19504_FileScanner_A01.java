import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class java_19504_FileScanner_A01 {

    private static final Set<String> ALLOWED_EXTENSIONS = new HashSet<>(Arrays.asList("txt", "java"));

    public static void main(String[] args) {
        String startDirectory = "src";
        File startFile = new File(startDirectory);
        File[] files = startFile.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.endsWith(".java");
            }
        });

        if (files != null) {
            for (File file : files) {
                readAndCheckFile(file);
            }
        }
    }

    private static void readAndCheckFile(File file) {
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (containsBrokenAccessControl(line)) {
                    System.out.println("Broken access control detected in: " + file.getAbsolutePath());
                }
            }
        } catch (Exception e) {
            System.out.println("Error while reading file: " + file.getAbsolutePath());
        }
    }

    private static boolean containsBrokenAccessControl(String line) {
        return line.contains("public") || line.contains("private") || line.contains("protected") ||
               line.contains("package") || line.contains("import") || line.contains("static") ||
               line.contains("final") || line.contains("abstract") || line.contains("native") ||
               line.contains("strictfp") || line.contains("volatile") || line.contains("transient") ||
               line.contains("interface") || line.contains("enum") || line.contains("annotation") ||
               line.contains("strict") || line.contains("synchronized") || line.contains("native") ||
               line.contains("double") || line.contains("float") || line.contains("long") || line.contains("true") ||
               line.contains("false") || line.contains("null") || line.contains("this");
    }
}