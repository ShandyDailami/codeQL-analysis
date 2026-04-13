import javax.management.AuthenticationFailedException;
import java.io.*;
import java.net.Socket;
import java.util.ArrayList;

public class java_18368_SessionManager_A07 {

    private ArrayList<Socket> sockets = new ArrayList<>();
    private ArrayList<String> passwords = new ArrayList<>();

    public java_18368_SessionManager_A07() {
        // Load sockets and passwords from file here
    }

    public void addSocket(Socket socket) {
        sockets.add(socket);
    }

    public void addPassword(String password) {
        passwords.add(password);
    }

    public boolean isValid(Socket socket, String password) throws AuthenticationFailedException {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);

            writer.println("Enter Password:");
            writer.flush();

            String inputPassword = reader.readLine();

            if (!inputPassword.equals(password)) {
                throw new AuthenticationFailedException("Invalid Password");
            }

            writer.println("Login Successful");
            writer.flush();
        } catch (IOException e) {
            throw new AuthenticationFailedException("Failed to authenticate", e);
        }

        return true;
    }
}