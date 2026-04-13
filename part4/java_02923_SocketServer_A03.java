import java.net.*;
import java.io.*;

public class java_02923_SocketServer_A03 {

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8080);
            System.out.println("Server started.");

            while(true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected.");

                DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
                DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());

                String clientMessage = dataInputStream.readUTF();
                System.out.println("Received from client: " + clientMessage);

                String serverMessage = "Hello, client!";
                dataOutputStream.writeUTF(serverMessage);
                System.out.println("Sent to client: " + serverMessage);

                socket.close();
            }
        } catch(IOException ex) {
            ex.printStackTrace();
        }
    }
}