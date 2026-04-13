import java.io.*;

public class java_06330_FileScanner_A08 {

    public static void main(String[] args) throws IOException {
        String directoryPath = "/path/to/directory";
        String searchPattern = ".*\\.txt";

        File directory = new File(directoryPath);

        File[] matchingFiles = directory.listFiles((File dir, String name) -> name.matches(searchPattern));

        if (matchingFiles != null) {
            for (File file : matchingFiles) {
                System.out.println(file.getAbsolutePath());
            }
        } else {
            System.out.println("No files found!");
        }
    }
}