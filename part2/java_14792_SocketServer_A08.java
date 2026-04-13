import java.io.*;
import java.net.*;

public class java_14792_SocketServer_A08 {
    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        Socket socket = null;

        try {
            serverSocket = new ServerSocket(8189);
            System.out.println("Server is listening on port 8189");

            while (true) {
                socket = serverSocket.accept();

                System.out.println("Client connected");

                // Here, we are making sure that the connection is secure
                // We are encrypting and decrypting data using SSLSocket
                SSLSocket sslSocket = (SSLSocket) socket.createChannel(socket.getInetAddress());
                sslSocket.setNeedClientAuth(true);

                sslSocket.startHandshake();

                if (sslSocket.getState().equals(Channel.State.CLOSED)) {
                    sslSocket.close();
                    continue;
                }

                // Here, we are making sure that the data sent is secure
                // We are encrypting and decrypting data using SSL
                SSL ssl = sslSocket.getSSLSocket();

                InputStream input = ssl.getInputStream();
                OutputStream output = ssl.getOutputStream();

                // Send data to client
                output.write("Hello, Client!".getBytes());
                output.flush();

                byte[] buffer = new byte[256];
                int bytesRead = input.read(buffer);
                String message = new String(buffer, 0, bytesRead);
                System.out.println("Message from client: " + message);

                ssl.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (serverSocket != null) serverSocket.close();
                if (socket != null) socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}