import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_03250_FileScanner_A03 {
    public static void main(String[] args) {
        File directory = new File("."); // point to the current directory
        String searchString = "A03_Injection";
        
        System.out.println("Searching for: " + searchString);
        
        if (directory.isDirectory()) {
            String[] children = directory.list();
            for (int i = 0; i < children.length; i++) {
                File file = new File(directory, children[i]);

                if (file.isFile() && file.getName().contains(searchString)) {
                    try (Scanner scanner = new Scanner(file)) {
                        System.out.println("File contains: " + searchString);
                        
                        while (scanner.hasNextLine()) {
                            String line = scanner.nextLine();
                            System.out.println(line);
                        }
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}