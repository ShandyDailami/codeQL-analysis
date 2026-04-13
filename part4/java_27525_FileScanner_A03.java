import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;

public class java_27525_FileScanner_A03 {

    public static void main(String[] args) {
        String directory = "/path/to/directory"; // replace with your directory

        File directoryFile = new File(directory);
        if (directoryFile.exists()) {
            String[] files = directoryFile.list(new FilenameFilter() {
                public boolean accept(File dir, String name) {
                    return name.toLowerCase().endsWith(".txt"); // filter files with .txt extension
                }
            });

            if (files != null) {
                Arrays.sort(files);

                for (String file : files) {
                    File fileToRead = new File(directory, file);
                    readFile(fileToRead);
                }
            }
        }
    }

    private static void readFile(File file) {
        try {
            if (file.canRead()) {
                FileReader fileReader = new FileReader(file);
                int character;
                while ((character = fileReader.read()) != -1) {
                    System.out.print((char) character);
                }
                fileReader.close();
            } else {
                System.out.println("Cannot read file " + file.getPath());
            }
        } catch (Exception e) {
            System.out.println("Error reading file " + file.getPath());
        }
    }
}