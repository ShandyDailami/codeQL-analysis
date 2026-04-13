import java.beans.XMLDecoder;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class java_18429_XMLParser_A01 {
    public static void main(String[] args) {
        try {
            XMLDecoder decoder = new XMLDecoder(new FileInputStream("broken_access_control.xml"));
            BrokenAccessControl brokenAccessControl = (BrokenAccessControl) decoder.readObject();
            decoder.close();

            System.out.println("User: " + brokenAccessControl.getUser());
            System.out.println("Password: " + brokenAccessControl.getPassword());
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
    }
}

class BrokenAccessControl {
    private String user;
    private String password;

    public java_18429_XMLParser_A01(String user, String password) {
        this.user = user;
        this.password = password;
    }

    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }
}