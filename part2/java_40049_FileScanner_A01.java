import java.io.*;

public class java_40049_FileScanner_A01 {

    private static final String DIRECTORY = "C:\\path\\to\\directory"; // replace with your directory path

    public static void main(String[] args) {
        scanDirectory(DIRECTORY);
    }

    public static void scanDirectory(String directoryPath) {
        File directory = new File(directoryPath);

        if (!directory.exists()) {
            System.out.println("Directory does not exist.");
            return;
        }

        File[] files = directory.listFiles();
        if (files == null) {
            System.out.println("Error getting files from directory.");
            return;
        }

        for (File file : files) {
            if (file.isFile()) {
                try {
                    scanFile(file);
                } catch (IOException e) {
                    System.out.println("Error scanning file: " + file.getPath());
                    e.printStackTrace();
                }
            } else if (file.isDirectory()) {
                scanDirectory(file.getPath());
            }
        }
    }

    public static void scanFile(File file) throws IOException {
        FileReader reader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(reader);

        String line;
        while ((line = bufferedReader.readLine()) != null) {
            // process line here
            System.out.println(line);
        }

        bufferedReader.close();
    }
}