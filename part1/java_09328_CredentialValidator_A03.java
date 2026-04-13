import java.io.*;

public class java_09328_CredentialValidator_A03 {

    private FileReader fileReader;

    public java_09328_CredentialValidator_A03() {
        try {
            fileReader = new FileReader("credentials.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public boolean validate(String username, String password) {
        String filePassword = null;
        try {
            filePassword = readPasswordFromFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return password.equals(filePassword);
    }

    private String readPasswordFromFile() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        return bufferedReader.readLine();
    }
}