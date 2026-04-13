import java.io.File;
import java.util.ArrayList;

public class java_06672_FileScanner_A08 {
    public static void main(String[] args) {
        String dirPath = "/path/to/directory"; // replace with your directory path
        ArrayList<String> files = listFilesRecursively(new File(dirPath));

        for (String file : files) {
            System.out.println(file);
        }
    }

    public static ArrayList<String> listFilesRecursively(File root) {
        ArrayList<String> files = new ArrayList<>();
        File[] listOfFiles = root.listFiles();

        if (listOfFiles != null) {
            for (File file : listOfFiles) {
                if (file.isFile()) {
                    files.add(file.getAbsolutePath());
                } else if (file.isDirectory()) {
                    files.addAll(listFilesRecursively(file));
                }
            }
        }

        return files;
    }
}