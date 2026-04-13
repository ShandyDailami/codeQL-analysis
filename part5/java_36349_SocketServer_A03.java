import java.io.*;
import java.net.*;

public class java_36349_SocketServer_A03 {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(6000);
        System.out.println("Server started at port 6000");

        while (true) {
            Socket client = server.accept();
            System.out.println("New client connected at " + client.getRemoteSocketAddress());

            // Handling client in new thread
            new HandleClient(client).start();
        }
   
    }
}

class HandleClient extends Thread {
    Socket client;

    public java_36349_SocketServer_A03(Socket client) {
        this.client = client;
    }

    public void run() {
        try {
            // Input stream for reading client data
            DataInputStream in = new DataInputStream(client.getInputStream());

            // Output stream for writing response
            DataOutputStream out = new DataOutputStream(client.getOutputStream());

            // Read client data
            String clientData = in.readUTF();

            // Perform security sensitive operation (here, it's just printing the received data)
            System.out.println("Received: " + clientData);

            // Send back a response
            out.writeUTF("Data received successfully");

            // Close streams and the socket
            in.close();
            out.close();
            client.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}