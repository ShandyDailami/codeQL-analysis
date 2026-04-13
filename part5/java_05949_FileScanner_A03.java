import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_05949_FileScanner_A03 {
    public static void main(String[] args) {
        try {
            File file = new File(".");
            File[] listOfFiles = file.listFiles();
            if (listOfFiles != null) {
                for (File listOfFile : listOfFiles) {
                    if (listOfFile.isFile()) {
                        Scanner fileScanner = new Scanner(listOfFile);
                        while (fileScanner.hasNextLine()) {
                            System.out.println(fileScanner.nextLine());
                        }
                        fileScanner.close();
                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}