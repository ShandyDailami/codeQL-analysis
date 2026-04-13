import java.io.*;

public class java_03327_FileScanner_A07 {
    public static void main(String[] args) {
        String directoryPath = "/path/to/directory";
        String subDirectory = "/path/to/subdirectory";

        File directory = new File(directoryPath);

        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isDirectory() && file.getPath().contains(subDirectory)) {
                    continue;
                }

                if (file.canRead()) {
                    readFile(file);
                } else {
                    System.out.println("Unable to read file: " + file.getPath());
                }
            }
        }
    }

    private static void readFile(File file) {
        try (FileReader reader = new FileReader(file)) {
            int c;

            while ((c = reader.read()) != -1) {
                System.out.print((char) c);
            }

            System.out.println("\n---");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}