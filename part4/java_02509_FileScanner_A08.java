import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.Scanner;

public class java_02509_FileScanner_A08 {

    private static final String ENDING = "jpg";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory:");
        String directory = scanner.nextLine();
        System.out.println("Enter the file ending:");
        ENDING = scanner.nextLine();

        File dir = new File(directory);

        if (dir.exists() && dir.isDirectory()) {
            File[] files = dir.listFiles(new FilenameFilter() {
                @Override
                public boolean accept(File dir, String name) {
                    return name.toLowerCase().endsWith("." + ENDING);
                }
            });

            if (files != null) {
                Arrays.sort(files);
                for (File file : files) {
                    System.out.println(file.getAbsolutePath());
                }
            } else {
                System.out.println("No files with ending " + ENDING + " found in " + dir.getAbsolutePath());
            }
        } else {
            System.out.println(dir.getAbsolutePath() + " does not exist or is not a directory");
        }
    }
}