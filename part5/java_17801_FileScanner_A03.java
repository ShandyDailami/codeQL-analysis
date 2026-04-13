import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;

public class java_17801_FileScanner_A03 {

    public static void main(String[] args) {
        String directoryPath = "/path/to/directory"; // Change to your directory
        String searchPattern = "*.java"; // Change to your search pattern

        File directory = new File(directoryPath);

        if (directory.exists()) {
            fileSearch(directory, searchPattern);
        } else {
            System.out.println("Directory not found!");
        }
    }

    private static void fileSearch(File directory, final String searchPattern) {
        File[] files = directory.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.matches(searchPattern);
            }
        });

        for (File file : files) {
            if (file.isFile()) {
                try {
                    System.out.println("Reading file: " + file.getCanonicalPath());
                    // Add your code here to read and sanitize the file
                    // For example, read the file and print its content
                    BufferedReader reader = new BufferedReader(new FileReader(file));
                    String line;
                    while ((line = reader.readLine()) != null) {
                        System.out.println(line);
                    }
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else if (file.isDirectory()) {
                fileSearch(file, searchPattern);
            }
        }
    }
}