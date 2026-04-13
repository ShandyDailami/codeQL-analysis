import java.io.File;
import java.util.ArrayList;

public class java_26312_FileScanner_A07 {

    public static void main(String[] args) {
        File directory = new File(".");
        ArrayList<File> files = new ArrayList<>();

        getAllFiles(directory, ".txt", files);

        for (File file : files) {
            System.out.println(file.getName());
        }
    }

    private static void getAllFiles(File directory, String extension, ArrayList<File> files) {
        File[] listOfFiles = directory.listFiles();

        if (listOfFiles != null) {
            for (File file : listOfFiles) {
                if (file.isFile() && file.getName().endsWith(extension)) {
                    files.add(file);
                } else if (file.isDirectory()) {
                    getAllFiles(file, extension, files);
                }
            }
        }
    }
}