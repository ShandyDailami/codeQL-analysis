import java.io.*;

public class java_20117_FileScanner_A03 {
    public static void main(String[] args) {
        File file = new File(".");
        try {
            File[] list = file.listFiles();
            for (int i = 0; i < list.length; i++) {
                if (list[i].isFile() && list[i].canRead()) {
                    System.out.println("File: " + list[i].getName());
                    // Add code here to perform security-sensitive operations related to A03_Injection
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}