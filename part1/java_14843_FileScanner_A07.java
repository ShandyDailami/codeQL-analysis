import java.io.File;
import java.io.IOException;

public class java_14843_FileScanner_A07 {
    public static void main(String[] args) {
        String dir = "/path/to/directory"; // replace with your directory

        File directory = new File(dir);
        printFilesAndDirectories(directory, "");
    }

    private static void printFilesAndDirectories(File directory, String indent) {
        for (int i = 0; i < indent.length() / 4; i++) {
            System.out.print(" ");
        }
        System.out.println(directory.getName());

        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    printFilesAndDirectories(file, indent + " ");
                } else {
                    for (int i = 0; i < indent.length() / 4; i++) {
                        System.out.print(" ");
                    }
                    System.out.println(file.getName());
                }
            }
        }
    }
}