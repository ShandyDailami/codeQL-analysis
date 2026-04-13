import java.io.*;

public class java_10746_FileScanner_A07 {

    public static void main(String[] args) {
        String directoryPath = "/path/to/directory"; // replace with your directory
        File directory = new File(directoryPath);

        if (!directory.exists()) {
            System.out.println("Directory does not exist!");
            return;
        }

        File[] files = directory.listFiles();
        if (files == null) {
            System.out.println("No files found!");
            return;
        }

        for (File file : files) {
            if (file.isFile()) {
                System.out.println(file.getName());
            }
        }
    }
}