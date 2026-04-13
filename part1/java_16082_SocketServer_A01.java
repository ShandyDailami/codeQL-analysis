import java.io.*;
import java.net.*;

public class java_16082_SocketServer_A01 {
    public static void main(String[] args) {
        try {
            // create a server socket
            ServerSocket serverSocket = new ServerSocket(12345);

            System.out.println("Server is listening on port 12345");

            while (true) {
                // accept a client connection
                Socket socket = serverSocket.accept();

                // create input stream and output stream
                DataInputStream inputStream = new DataInputStream(socket.getInputStream());
                DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());

                // read a message from the client
                String message = inputStream.readUTF();

                // send a message back to the client
                outputStream.writeUTF("Server received: " + message);
                outputStream.flush();

                // close the connection
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}