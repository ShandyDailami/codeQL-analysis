import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_27785_FileScanner_A08 {
    public static void main(String[] args) {
        File file = new File(".");
        if (file.isDirectory()) {
            String[] list = file.list();
            if (list != null) {
                for (String name : list) {
                    File nFile = new File(name);
                    if (nFile.isFile()) {
                        try {
                            Scanner scanner = new Scanner(nFile);
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
        }
    }
}