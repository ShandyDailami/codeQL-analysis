import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class java_37321_FileScanner_A08 {

    public static void main(String[] args) {
        try {
            FileScanner(new File("."));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void FileScanner(File directory) throws IOException {
        File[] foundFiles = directory.listFiles();

        if (foundFiles != null) {
            for (File file : foundFiles) {
                if (file.isFile()) {
                    if (file.canRead()) {
                        System.out.println("File: " + file.getAbsolutePath());

                        // Write file names to a file
                        FileWriter writer = new FileWriter("file_names.txt", true);
                        writer.write(file.getAbsolutePath() + System.lineSeparator());
                        writer.close();
                    } else {
                        System.out.println("The file " + file.getAbsolutePath() + " cannot be read.");
                    }
                } else if (file.isDirectory()) {
                    System.out.println("Directory: " + file.getAbsolutePath());
                    FileScanner(file);
                }
            }
        }
    }
}