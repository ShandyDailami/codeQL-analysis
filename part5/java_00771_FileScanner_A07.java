import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_00771_FileScanner_A07 {
    public static void main(String[] args) {
        File directory = new File(".");
        String searchName = "A07_AuthFailure";
        String searchExtension = ".java";

        File[] results = directory.listFiles((File pathname) ->
                pathname.getName().endsWith(searchExtension) && pathname.getName().contains(searchName)
        );

        if (results != null) {
            for (File file : results) {
                try (Scanner scanner = new Scanner(file)) {
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