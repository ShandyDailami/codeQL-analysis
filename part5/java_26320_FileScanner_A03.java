import java.io.*;

public class java_26320_FileScanner_A03 {

    private static String DIRECTORY = "C:\\Windows\\";
    private static String FILE_EXTENSION = ".txt";

    public static void main(String[] args) {
        try {
            scanDirectory(DIRECTORY);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void scanDirectory(String directory) throws IOException {
        File file = new File(directory);
        File[] listOfFiles = file.listFiles();

        if (listOfFiles != null) {
            for (File f : listOfFiles) {
                if (f.isFile() && (f.getName().endsWith(FILE_EXTENSION))) {
                    readFile(f);
                } else if (f.isDirectory()) {
                    scanDirectory(f.getAbsolutePath());
                }
            }
        }
    }

    private static void readFile(File file) {
        try {
            FileReader reader = new FileReader(file);
            int character;

            while ((character = reader.read()) != -1) {
                System.out.print((char) character);
            }

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}