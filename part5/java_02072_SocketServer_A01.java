import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class java_02072_SocketServer_A01 {
    public static void main(String[] args) throws IOException {
        int port = 6000;
        Socket socket = new Socket("localhost", port);

        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

        out.println("Connected to server, please enter your password:");

        String password = in.readLine();

        if (password.equals("securepassword")) {
            out.println("Welcome!");
        } else {
            out.println("Incorrect password, please try again.");
        }

        socket.close();
    }
}