import java.net.*;
import java.io.*;
import java.security.*;

public class java_02647_SocketServer_A08 {
    public static void main(String[] args) throws Exception {
        ServerSocket server = null;
        SSLServerSocket sslServer = null;
        Socket socket = null;

        // Create a SSLServerSocket
        sslServer = (SSLServerSocket) new SSLServerSocket(5000);

        while (true) {
            // Accept a connection
            socket = sslServer.accept();

            // Create a new thread for each connection
            Handler handler = new Handler(socket);
            new Thread(handler).start();
        }
    }
}

class Handler implements Runnable {
    private Socket socket;

    public java_02647_SocketServer_A08(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            SSLServerSocket server = (SSLServerSocket) socket.getSocket();

            // Get the input and output streams
            InputStream input = socket.getInputStream();
            OutputStream output = socket.getOutputStream();

            // Read a message from the client
            DataInputStream dis = new DataInputStream(input);
            DataOutputStream dos = new DataOutputStream(output);
            String clientMessage = dis.readUTF();

            // Process the message (this is just echoing the message)
            String serverMessage = clientMessage;

            // Send the response back to the client
            dos.writeUTF(serverMessage);

            // Close the connection
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}