import java.io.*;
import java.net.*;

public class java_20213_SocketServer_A03 {

    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        Socket socket = null;

        try {
            // create a server socket at port 1234
            serverSocket = new ServerSocket(1234);
            System.out.println("Server listening on port 1234");

            while (true) {
                // wait for a client to connect
                socket = serverSocket.accept();
                System.out.println("Client connected");

                // get an output stream from the socket
                DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());

                // send a "Hello, Client!" message to the client
                outputStream.writeUTF("Hello, Client!");

                // close the connection
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // always close the server socket
            if (serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}