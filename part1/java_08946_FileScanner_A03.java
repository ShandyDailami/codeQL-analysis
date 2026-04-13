import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_08946_FileScanner_A03 {

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File(".");
        String absolutePath = file.getAbsolutePath();
        File directory = new File(absolutePath + "/../");
        String parentDirectory = directory.getAbsolutePath();

        System.out.println("Enter the directory to scan:");
        Scanner scanner = new Scanner(System.in);
        String dir = scanner.next();
        String path = parentDirectory + "/" + dir;

        File folder = new File(path);
        File[] listOfFiles = folder.listFiles();

        for (int i = 0; i < listOfFiles.length; i++) {
            if (listOfFiles[i].isFile() && listOfFiles[i].getName().endsWith(".txt")) {
                Scanner fileScanner = new Scanner(listOfFiles[i]);
                while (fileScanner.hasNextLine()) {
                    String line = fileScanner.nextLine();
                    System.out.println(line);
                }
                fileScanner.close();
            }
        }
    }
}