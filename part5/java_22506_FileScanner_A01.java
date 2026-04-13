import java.io.File;
import java.util.Arrays;

public class java_22506_FileScanner_A01 {
    public static void main(String[] args) {
        File file = new File(".");

        if (file.isDirectory()) {
            File[] listFiles = file.listFiles();

            if (listFiles != null) {
                Arrays.stream(listFiles).forEach(f -> {
                    if (f.isFile()) {
                        System.out.println(f.getName());
                    } else if (f.isDirectory()) {
                        System.out.println("Directory: " + f.getName());
                        listFiles = f.listFiles();

                        if (listFiles != null) {
                            Arrays.stream(listFiles).forEach(file1 -> {
                                if (file1.isFile()) {
                                    System.out.println("File: " + file1.getName());
                                }
                            });
                        }
                    }
                });
            }
        }
    }
}