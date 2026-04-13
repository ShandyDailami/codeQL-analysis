import java.io.*;

public class java_19184_FileScanner_A01 {
    public static void main(String[] args) {
        String directory = "/path/to/directory";
        String extension = ".txt";

        File folder = new File(directory);
        File[] listOfFiles = folder.listFiles((dir, name) -> name.endsWith(extension));

        if (listOfFiles != null) {
            for (File file : listOfFiles) {
                if (file.isFile()) {
                    printFile(file);
                } else if (file.isDirectory()) {
                    System.out.println("Directory: " + file.getPath());
                }
            }
        }
    }

    private static void printFile(File file) {
        System.out.println("File: " + file.getPath());
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println("Line: " + line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}