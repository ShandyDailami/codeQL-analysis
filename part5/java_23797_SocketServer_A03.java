import java.io.*;
import java.net.*;

public class java_23797_SocketServer_A03 {
    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(8080); // assign a port number
            System.out.println("Server is listening on port 8080");
            while(true) {
                Socket socket = serverSocket.accept(); // waiting for client connection
                System.out.println("A client has connected");
                // start a new thread to handle communication
                new ClientHandler(socket).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class ClientHandler extends Thread {
    private Socket socket;
    public java_23797_SocketServer_A03(Socket socket) {
        this.socket = socket;
    }
    public void run() {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            DataOutputStream writer = new DataOutputStream(socket.getOutputStream());
            String clientMessage;
            while((clientMessage = reader.readLine()) != null) { // read from client
                System.out.println("Received message from client: " + clientMessage);
                // send response back to client
                writer.writeBytes("Server received: " + clientMessage + '\n');
                writer.flush();
            }
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}