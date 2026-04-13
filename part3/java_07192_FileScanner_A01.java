import java.io.*;

public class java_07192_FileScanner_A01 {

    private static String filePath = "src/main/resources/brokenAccessControlFile.txt";

    public static void main(String[] args) {
        FileScanner fileScanner = new FileScanner();
        fileScanner.scan(filePath);
    }

    private static class FileScanner {

        public void scan(String filePath) {
            File file = new File(filePath);

            try {
                if (file.canRead()) {
                    BufferedReader reader = new BufferedReader(new FileReader(file));
                    String line;
                    while ((line = reader.readLine()) != null) {
                        System.out.println(line);
                    }
                    reader.close();
                } else {
                    System.out.println("Unable to read file: " + file.getPath());
                }
            } catch (IOException e) {
                System.out.println("IOException was caught: " + e.getMessage());
            }
        }
    }
}