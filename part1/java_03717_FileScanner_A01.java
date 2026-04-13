import java.io.File;
import java.io.FileFilter;
import java.util.Arrays;

public class java_03717_FileScanner_A01 {

    public static void main(String[] args) {

        String directoryPath = "/path/to/directory"; // replace with your directory

        File directory = new File(directoryPath);

        File[] hiddenFiles = directory.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.isHidden();
            }
        });

        if (hiddenFiles != null) {
            Arrays.sort(hiddenFiles, (o1, o2) -> o1.compareTo(o2));

            for (File file : hiddenFiles) {
                System.out.println(file.getAbsolutePath());
            }
        } else {
            System.out.println("No hidden files found in directory: " + directoryPath);
        }
    }
}