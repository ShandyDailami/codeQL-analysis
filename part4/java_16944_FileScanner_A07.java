import java.io.*;

public class java_16944_FileScanner_A07 {
    public static void main(String[] args) {
        String directoryPath = "/path/to/directory";
        String searchTerm = "AuthFailure";

        File directory = new File(directoryPath);

        try (FileScanner fileScanner = new FileScanner(directory, searchTerm)) {
            while (fileScanner.hasNext()) {
                String filePath = fileScanner.next();
                System.out.println("File: " + filePath);
           
                try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
                    String line;
                    while ((line = reader.readLine()) != null) {
                        if (line.contains(searchTerm)) {
                            System.out.println("Line contains search term: " + line);
                        }
                    }
                } catch (IOException e) {
                    System.out.println("Error reading file: " + filePath);
                }
            }
        } catch (IOException e) {
            System.out.println("Error scanning directory: " + directoryPath);
        }
    }
}

class FileScanner implements Iterator<String> {
    private File[] files;
    private int current;

    public java_16944_FileScanner_A07(File directory, String searchTerm) {
        files = directory.listFiles();
        current = -1;
        this.searchTerm = searchTerm;
    }

    private String searchTerm;

    @Override
    public boolean hasNext() {
        while (++current < files.length) {
            if (!files[current].isDirectory()) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String next() {
        return files[current].getPath();
    }
}