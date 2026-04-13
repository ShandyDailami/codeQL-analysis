import java.io.*;

public class java_28246_FileScanner_A01 {
    public static void main(String[] args) throws IOException {
        String directory = "/path/to/directory"; // replace with your directory
        File dir = new File(directory);

        if (dir.exists() && dir.isDirectory()) {
            File[] files = dir.listFiles();

            if (files != null) {
                for (File file : files) {
                    if (file.isFile()) {
                        printFileContent(file);
                    }
                }
            }
        } else {
            System.out.println("Directory not found!");
        }
    }

    public static void printFileContent(File file) throws IOException {
        FileReader reader = new FileReader(file);

        int c;
        while ((c = reader.read()) != -1) {
            System.out.print((char) c);
        }

        reader.close();
    }
}