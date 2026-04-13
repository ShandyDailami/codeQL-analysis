import java.io.File;
import java.util.Scanner;

public class java_03351_FileScanner_A01 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the path of the directory:");
        String path = scanner.nextLine();

        File directory = new File(path);
        if (directory.isDirectory()) {
            System.out.println("Scanning all files in: " + directory.getAbsolutePath());
            String[] files = directory.list();
            if (files != null) {
                for (String fileName : files) {
                    File file = new File(directory.getAbsolutePath() + "/" + fileName);
                    if (file.isFile() && file.canRead()) {
                        System.out.println("Reading: " + file.getAbsolutePath());
                        // This is where you would add your FileReader for the file
                        // e.g. FileReader reader = new FileReader(file);
                        // e.g. BufferedReader reader = new BufferedReader(reader);
                        // e.g. String line = reader.readLine();
                    }
                }
            }
        } else {
            System.out.println(directory.getAbsolutePath() + " is not a directory!");
        }

        scanner.close();
    }
}