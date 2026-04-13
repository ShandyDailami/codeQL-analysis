import java.io.*;

public class java_35767_FileScanner_A07 {
    public static void main(String[] args) {
        File directory = new File("path/to/directory");
        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    checkFileName(file);
                }
            }
        }
    }

    private static void checkFileName(File file) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.contains("sensitive")) {
                    System.out.println("Found sensitive word in file: " + file.getName());
                }
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}