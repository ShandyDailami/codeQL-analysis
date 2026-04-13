import java.io.File;
import java.util.Scanner;

public class java_18233_FileScanner_A03 {
    public static void main(String[] args) {
        String extension = ".txt";
        File dir = new File(".");
        String[] list = dir.list();

        if (list != null) {
            for (int i = 0; i < list.length; i++) {
                String name = list[i];
                if (name.endsWith(extension)) {
                    File file = new File(name);
                    if (file.canRead()) {
                        Scanner reader = new Scanner(file);
                        while (reader.hasNextLine()) {
                            String data = reader.nextLine();
                            System.out.println(data);
                       
                        }
                        reader.close();
                    }
                }
            }
        }
    }
}