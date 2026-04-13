import java.io.*;
import java.net.*;

public class java_28142_SocketServer_A07 {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080);

        while (true) {
            Socket socket = serverSocket.accept();

            // Create input and output streams
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            // Read the username and password
            String username = in.readUTF();
            String password = in.readUTF();

            // Check if the username and password are correct
            if (username.equals("admin") && password.equals("password")) {
                out.writeUTF("Login Successful");
            } else {
                out.writeUTF("Login Failed");
            }

            // Close the streams
            out.close();
            in.close();
            socket.close();
        }
    }
}