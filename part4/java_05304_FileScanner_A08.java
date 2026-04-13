import java.io.File;
import java.io.FileFilter;
import java.io.IOException;

public class java_05304_FileScanner_A08 {
    public static void main(String[] args) {
        String directoryPath = "/path/to/directory"; // replace with your directory path
        File directory = new File(directoryPath);

        if (directory.exists() && directory.isDirectory()) {
            File[] allFiles = directory.listFiles(new FileFilter() {
                @Override
                public boolean accept(File pathname) {
                    return pathname.isFile() && pathname.getName().endsWith(".txt");
                }
            });

            if (allFiles != null) {
                for (File file : allFiles) {
                    try {
                        System.out.println("Reading file: " + file.getAbsolutePath());
                        readFile(file);
                    } catch (IOException e) {
                        System.out.println("Error reading file: " + file.getAbsolutePath());
                    }
                }
            } else {
                System.out.println("No files found in directory.");
            }
        } else {
            System.out.println("Directory does not exist or is not a directory.");
        }
    }

    private static void readFile(File file) throws IOException {
        if (file.canRead()) {
            byte[] data = new byte[(int) file.length()];
            FileInputStream fis = new FileInputStream(file);
            fis.read(data);
            fis.close();

            String content = new String(data, "UTF-8");
            System.out.println(content);
        } else {
            System.out.println("Error reading file: " + file.getAbsolutePath());
        }
    }
}