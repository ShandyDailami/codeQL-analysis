import java.io.*;
import java.net.*;

public class java_30927_SocketServer_A01 {

    public static void main(String[] args) {
        int port = 6000; // default port
        try {
            ServerSocket serverSocket = new ServerSocket(port);
            System.out.println("Server is listening on port " + port);
            
            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client has connected");
                
                // Creating a new thread for each client
                Thread thread = new Thread(new SocketHandler(socket));
                thread.start();
           
            }

        } catch (IOException e) {
            System.out.println("Error establishing server");
            e.printStackTrace();
        }
    }

}

class SocketHandler implements Runnable {

    private Socket socket;

    public java_30927_SocketServer_A01(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        try {
            // Create input stream from the socket
            InputStream input = socket.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(input));

            // Create output stream from the socket
            OutputStream output = socket.getOutputStream();
            DataOutputStream writer = new DataOutputStream(output);

            String clientMessage;

            // Read the message from the client
            clientMessage = reader.readLine();
            System.out.println("Received: " + clientMessage);

            // Send a response back to the client
            String serverMessage = "Hello, Client!";
            writer.writeBytes(serverMessage + "\n");

            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}