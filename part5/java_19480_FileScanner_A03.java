import java.io.*;

public class java_19480_FileScanner_A03 {
    public static void main(String[] args) {
        String directory = "/path/to/directory"; // replace with actual directory path
        String filePattern = "*.txt"; // replace with actual file pattern
        String filter = "Filter text"; // replace with actual filter text

        File dir = new File(directory);
        File[] matchingFiles = dir.listFiles((File dir, String name) -> name.endsWith(filePattern));

        if (matchingFiles != null) {
            for (File file : matchingFiles) {
                if (file.getName().contains(filter)) {
                    try (FileReader reader = new FileReader(file)) {
                        int character;
                        while ((character = reader.read()) != -1) {
                            System.out.print((char) character);
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}