import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class java_18201_FileScanner_A07 {
    public static void main(String[] args) throws FileNotFoundException {
        String directoryPath = "."; // Set to the current directory
        String fileName = "A07_AuthFailure";

        File dir = new File(directoryPath);

        File[] listOfFiles = dir.listFiles();

        if(listOfFiles != null) {
            for(File file : listOfFiles) {
                if(file.getName().equals(fileName)) {
                    Scanner scanner = new Scanner(file);
                    while(scanner.hasNextLine()) {
                        String line = scanner.nextLine();
                        System.out.println(line);
                   
                        // Add your security-sensitive operations related to A07_AuthFailure here
                   
                    }
                    scanner.close();
                }
            }
        }
    }
}