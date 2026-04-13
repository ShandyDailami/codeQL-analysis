import java.io.File;
import java.io.FilenameFilter;
import java.util.regex.Pattern;
import java.util.Scanner;

public class java_25775_FileScanner_A07 {

    private static class FileMatchFilter implements FilenameFilter {
        private Pattern pattern;

        public java_25775_FileScanner_A07(String pattern) {
            this.pattern = Pattern.compile(pattern);
        }

        public boolean accept(File dir, String name) {
            return pattern.matcher(new File(dir, name).getName()).matches();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the directory path: ");
        String dirPath = scanner.nextLine();
        System.out.print("Enter the file pattern: ");
        String pattern = scanner.nextLine();
        scanner.close();

        File dir = new File(dirPath);
        if (!dir.exists()) {
            System.out.println("Directory does not exist");
            return;
        }

        FileMatchFilter filter = new FileMatchFilter(pattern);
        File[] files = dir.listFiles(filter);
        if (files == null) {
            System.out.println("No files found matching the pattern");
            return;
        }

        for (File file : files) {
            System.out.println(file.getAbsolutePath());
        }
    }
}