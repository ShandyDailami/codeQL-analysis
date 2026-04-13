import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_24139_FileScanner_A01 {

    public static void main(String[] args) {
        String directory = "/path/to/directory";
        String extension = "txt";

        File dir = new File(directory);

        if (dir.exists() && dir.isDirectory()) {
            File[] listOfFiles = dir.listFiles((dir1, name) -> name.endsWith(extension));

            if (listOfFiles != null) {
                for (File file : listOfFiles) {
                    if (!file.canRead()) {
                        System.out.println("Access to file " + file.getPath() + " is denied.");
                    } else {
                        Scanner fileScanner = null;
                        try {
                            fileScanner = new Scanner(file);
                            while (fileScanner.hasNextLine()) {
                                String line = fileScanner.nextLine();
                                System.out.println(line);
                            }
                        } catch (FileNotFoundException e) {
                            e.printStackTrace();
                        } finally {
                            if (fileScanner != null) {
                                fileScanner.close();
                            }
                        }
                    }
                }
            } else {
                System.out.println("Directory is empty.");
            }
        } else {
            System.out.println("The provided path is not a directory.");
        }
    }
}