import java.io.*;
import java.net.*;

public class java_28148_SocketServer_A08 {
    private ServerSocket serverSocket;

    public java_28148_SocketServer_A08(int port) throws IOException {
        serverSocket = new ServerSocket(port);
    }

    public void startServer() throws IOException {
        while (true) {
            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected");
            handleClient(clientSocket);
        }
    }

    private void handleClient(Socket clientSocket) {
        try {
            InputStream input = clientSocket.getInputStream();
            DataInputStream dis = new DataInputStream(input);
            String message = dis.readUTF();
            System.out.println("Received: " + message);
            OutputStream output = clientSocket.getOutputStream();
            DataOutputStream dos = new DataOutputStream(output);
            dos.writeUTF("Message received: " + message);
            clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        SocketServer server = new SocketServer(8080);
        server.startServer();
    }
}