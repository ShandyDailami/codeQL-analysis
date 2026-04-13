import java.io.*;

public class java_34090_FileScanner_A03 {

    public static void main(String[] args) {
        File file = new File("./src/main/resources/");
        String[] fileList = file.list();

        if (fileList != null) {
            for (String filename : fileList) {
                File newFile = new File(file, filename);

                if (newFile.isFile() && newFile.getName().endsWith(".txt")) {
                    try {
                        FileReader fileReader = new FileReader(newFile);
                        BufferedReader bufferedReader = new BufferedReader(fileReader);
                        String line;

                        while ((line = bufferedReader.readLine()) != null) {
                            System.out.println("Content in file: " + line);
                       
                        }
                        bufferedReader.close();

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}