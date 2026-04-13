import java.io.*;

public class java_27856_FileScanner_A01 {
    private String filePath;
    private File file;

    public java_27856_FileScanner_A01(String filePath) {
        this.filePath = filePath;
        this.file = new File(filePath);
    }

    public void readFile() {
        try {
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
            br.close();
            fr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeToFile(String data) {
        try {
            FileWriter fw = new FileWriter(file, true);
            fw.write(data + System.lineSeparator());
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        BrokenAccessControlExample example = new BrokenAccessControlExample("test.txt");
        example.writeToFile("This is a test");
        example.readFile();
    }
}