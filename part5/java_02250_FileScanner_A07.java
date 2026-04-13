import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class java_02250_FileScanner_A07 {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory:");
        String directoryPath = scanner.nextLine();

        File startingDirectory = new File(directoryPath);

        FileFilter filter = new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                // Only accept files readable by the current user
                return pathname.canRead();
            }
        };

        List<File> fileList = new ArrayList<>();
        populateFileList(startingDirectory, filter, fileList);

        for (File file : fileList) {
            System.out.println(file.getAbsolutePath());
        }
    }

    private static void populateFileList(File startingDirectory, FileFilter filter, List<File> fileList) {
        File[] files = startingDirectory.listFiles(filter);
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    populateFileList(file, filter, fileList);
                } else {
                    fileList.add(file);
                }
            }
        }
    }
}