import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class java_29617_FileScanner_A01 {
    public static void main(String[] args) throws IOException {
        String directoryPath = "/path/to/directory"; // replace with your directory
        String fileExtension = ".txt"; // replace with your file extension

        secureFileScan(directoryPath, fileExtension);
    }

    private static void secureFileScan(String directoryPath, String fileExtension) throws IOException {
        File directory = new File(directoryPath);
        for (File file : directory.listFiles()) {
            if (file.isFile() && file.getName().endsWith(fileExtension)) {
                printFileContents(file);
            } else if (file.isDirectory()) {
                secureFileScan(file.getAbsolutePath(), fileExtension);
            }
        }
    }

    private static void printFileContents(File file) throws IOException {
        Path path = Paths.get(file.getAbsolutePath());
        byte[] bytes = Files.readAllBytes(path);
        String content = new String(bytes, "UTF-8");
        System.out.println("File contents: " + content);
    }
}