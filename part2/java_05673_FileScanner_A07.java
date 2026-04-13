import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_05673_FileScanner_A07 {
    public static void main(String[] args) {
        String currentDir = System.getProperty("user.dir");
        File dir = new File(currentDir);

        if (dir.exists() && dir.isDirectory()) {
            File[] files = dir.listFiles();

            if (files != null) {
                for (File file : files) {
                    if (file.isFile()) {
                        try {
                            Scanner scanner = new Scanner(file);

                            while (scanner.hasNextLine()) {
                                String line = scanner.nextLine();
                                System.out.println(line);
                            }

                            scanner.close();

                        } catch (FileNotFoundException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        } else {
            System.out.println("The specified directory does not exist or is not a directory.");
        }
    }
}