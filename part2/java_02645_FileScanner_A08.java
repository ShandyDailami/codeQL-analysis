import java.io.File;
import java.io.FilenameFilter;

public class java_02645_FileScanner_A08 {

    public static void main(String[] args) {
        String directoryPath = "./target"; // replace with your directory path
        File directory = new File(directoryPath);

        if (directory.exists()) {
            FilenameFilter filter = new FilenameFilter() {
                @Override
                public boolean accept(File dir, String name) {
                    return name.endsWith(".java");
                }
            };

            File[] files = directory.listFiles(filter);

            for (File file : files) {
                System.out.println(file.getAbsolutePath());
            }
        } else {
            System.out.println("Directory does not exist.");
        }
    }
}