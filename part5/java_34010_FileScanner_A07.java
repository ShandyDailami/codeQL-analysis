import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_34010_FileScanner_A07 {

    public static void main(String[] args) throws FileNotFoundException {
        File directory = new File(".");
        String[] fileList = directory.list();

        for (String fileName : fileList) {
            File file = new File(fileName);
            if (file.isFile() && fileName.endsWith(".txt")) {
                Scanner fileScanner = new Scanner(file);
                while (fileScanner.hasNextLine()) {
                    System.out.println(fileScanner.nextLine());
                }
                fileScanner.close();
            }
        }
    }
}