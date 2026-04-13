import java.io.*;
import java.net.*;

public class java_36049_SocketServer_A07 {
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(5000); // port number
        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client Connected");

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            // First, send the server's name and version
            out.writeUTF("Server");
            out.writeUTF(Double.toString(java.lang.Runtime.version()));

            // Then, receive the client's name and password, and check if they match
            String clientName = in.readUTF();
            String clientPassword = in.readUTF();

            if (clientName.equals("admin") && clientPassword.equals("password")) {
                // If the client's name and password match, send a welcome message
                out.writeUTF("Welcome, " + clientName + "!");
            } else {
                // If the client's name or password is incorrect, send an auth failure message
                out.writeUTF("Auth failure");
            }

            out.flush();
            socket.close();
        }
    }
}