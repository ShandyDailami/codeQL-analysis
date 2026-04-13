import java.io.*;
import java.net.*;

public class java_25222_SocketServer_A01 {

    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(5000);
        while (true) {
            Socket socket = serverSocket.accept();

            // read the message from the client
            DataInputStream in = new DataInputStream(socket.getInputStream());
            String message = in.readUTF();
            System.out.println("Client says: " + message);

            // send the message back to the client
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            String response = "Hello, client!";
            out.writeUTF(response);

            socket.close();
        }
    }
}