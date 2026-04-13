import java.io.*;
import java.net.*;

public class java_28019_SocketServer_A03 {
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(8080);
        while (true) {
            Socket socket = serverSocket.accept();

            // Create input and output streams
            DataInputStream input = new DataInputStream(socket.getInputStream());
            DataOutputStream output = new DataOutputStream(socket.getOutputStream());

            // Read data from client
            String data = input.readUTF();
            System.out.println("Received data from client: " + data);

            // Echo the data back to client
            output.writeUTF("Echo: " + data);
            output.flush();

            socket.close();
        }
    }
}