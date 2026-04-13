import java.io.*;
import java.net.*;

public class java_26397_SocketServer_A01 {
    private static final String QUIT = "quit";

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8189);
        System.out.println("Waiting for client on port " + serverSocket.getLocalPort() + "...");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected!");

            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());

            String message;
            while (!(message = dataInputStream.readUTF()).equals(QUIT)) {
                System.out.println("Received message: " + message);
                dataOutputStream.writeUTF(message);
                dataOutputStream.flush();
            }

            dataInputStream.close();
            dataOutputStream.close();
            socket.close();

            System.out.println("Client disconnected!");
        }
    }
}