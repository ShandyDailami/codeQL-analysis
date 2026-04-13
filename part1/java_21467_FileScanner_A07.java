import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class java_21467_FileScanner_A07 {
    public static void main(String[] args) {
        File currentDir = new File(".");
        String[] list = currentDir.list();
        Arrays.sort(list);

        for(String name : list) {
            File file = new File(name);
            if(file.isFile()) {
                Scanner scanner = null;
                try {
                    scanner = new Scanner(file);
                    while(scanner.hasNextLine()) {
                        String line = scanner.nextLine();
                        System.out.println(line);
                    }
                    scanner.close();
                } catch(Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}