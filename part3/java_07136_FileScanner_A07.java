import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_07136_FileScanner_A07 {
    private static final String DIR_PATH = "/path/to/directory"; // replace this with the directory you want to scan
    private static final String EXTENSION = ".txt"; // replace this with the file extension you want to scan
    private static final String HEADER = "Authorization"; // replace this with the header you want to look for in each file

    public static void main(String[] args) {
        File dir = new File(DIR_PATH);

        if (dir.exists() && dir.isDirectory()) {
            File[] files = dir.listFiles((dir2, name) -> name.endsWith(EXTENSION));

            if (files != null) {
                for (File file : files) {
                    try (Scanner scanner = new Scanner(file)) {
                        if (scanner.hasNext()) {
                            String header = scanner.nextLine();
                            if (header.contains(HEADER)) {
                                System.out.println("File " + file.getName() + " has valid header!");
                            } else {
                                System.out.println("File " + file.getName() + " has invalid header!");
                           
                            }
                        }
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                }
            } else {
                System.out.println("Directory does not exist or is not a directory!");
            }
        } else {
            System.out.println("Directory does not exist or is not a directory!");
        }
    }
}