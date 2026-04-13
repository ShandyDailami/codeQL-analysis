import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.List;

public class java_14435_FileScanner_A08 {
    public static final String FILE_EXTENSIONS = "txt, java";

    public static void main(String[] args) throws FileNotFoundException {
        String dirPath = System.getProperty("user.dir");
        File dir = new File(dirPath);
        File[] files = dir.listFiles(new FileFilter() {
            public boolean accept(File pathname) {
                return pathname.isFile() &&
                        FILE_EXTENSIONS.contains("." + pathname.getName().substring(pathname.getName().lastIndexOf(".") + 1));
            }
        });

        if (files != null) {
            List<File> txtFiles = Arrays.asList(files);
            for (File txtFile : txtFiles) {
                if (checkFileIntegrity(txtFile)) {
                    System.out.println("File " + txtFile.getName() + " is okay.");
                } else {
                    System.out.println("File " + txtFile.getName() + " has integrity failures.");
                    deleteFile(txtFile);
                }
            }
        } else {
            System.out.println("No files found in " + dirPath);
        }
    }

    private static boolean checkFileIntegrity(File file) throws FileNotFoundException {
        FileReader reader = new FileReader(file);
        long length = file.length();
        long readerLength = 0;
        int read;
        while ((read = reader.read()) != -1 && readerLength < length) {
            readerLength++;
        }
        reader.close();
        return readerLength == length;
    }

    private static void deleteFile(File file) {
        if (!file.delete()) {
            System.out.println("Failed to delete file " + file.getName());
        }
    }
}