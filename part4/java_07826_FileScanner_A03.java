import java.io.File;
import java.util.Scanner;

public class java_07826_FileScanner_A03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String path = scanner.nextLine();

        File directory = new File(path);
        File[] listOfFiles = directory.listFiles();

        if (listOfFiles != null) {
            for (File file : listOfFiles) {
                if (file.isFile()) {
                    detectInjection(file);
                } else if (file.isDirectory()) {
                    detectInjection(file);
                }
            }
        }
    }

    public static void detectInjection(File file) {
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.contains(";") || line.contains("'") || line.contains("\"")) {
                    System.out.println("File: " + file.getPath() + ", Line: " + line);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}