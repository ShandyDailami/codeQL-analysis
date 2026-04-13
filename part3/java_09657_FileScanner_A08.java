import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_09657_FileScanner_A08 {

    public static void main(String[] args) throws FileNotFoundException {

        String fileName = "File.txt";
        String currentDir = System.getProperty("user.dir");

        File file = new File(currentDir + "/" + fileName);
        Scanner scanner = new Scanner(file);

        if (file.exists()) {
            if (file.isFile() && file.canRead() && file.length() < 1000) {
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    System.out.println(line);
                }
            } else {
                System.out.println("File is not in the same directory as the Java file or is not a readable file or it's larger than 1000 bytes");
            }
        } else {
            System.out.println("File does not exist");
        }

        scanner.close();
    }
}