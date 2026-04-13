import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class java_27480_FileScanner_A03 {
    public static void main(String[] args) {
        // Define the directory to scan
        String directory = "/path/to/directory";

        // Define the regex to match .txt files
        String regex = ".*\\.txt$";
        Pattern pattern = Pattern.compile(regex);

        // Scan the directory
        File dir = new File(directory);
        File[] listOfFiles = dir.listFiles();
        for (File file : listOfFiles) {
            if (file.isFile() && pattern.matcher(file.getName()).matches()) {
                try (Scanner scanner = new Scanner(file)) {
                    while (scanner.hasNextLine()) {
                        System.out.println(scanner.nextLine());
                    }
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}