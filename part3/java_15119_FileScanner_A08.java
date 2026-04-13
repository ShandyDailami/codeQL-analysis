import java.io.*;

public class java_15119_FileScanner_A08 {
    public static void main(String[] args) {
        File file = new File("src/main/resources");
        File[] listFiles = file.listFiles();

        if (listFiles != null) {
            for (File f : listFiles) {
                if (f.isFile()) {
                    printFile(f);
                } else if (f.isDirectory()) {
                    System.out.println("Directory: " + f.getPath());
                }
            }
        }
    }

    private static void printFile(File file) {
        try {
            FileReader reader = new FileReader(file);
            int data;

            while ((data = reader.read()) != -1) {
                System.out.print((char) data);
            }

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}