import java.io.*;
import java.net.*;

public class java_40662_SocketServer_A07 {
    public static void main(String args[]) {
        ServerSocket serverSocket = null;
        Socket socket = null;
        try {
            serverSocket = new ServerSocket(8080);
            System.out.println("Waiting for client on port " + serverSocket.getLocalPort() + "...");
            socket = serverSocket.accept();
            System.out.println("Client accepted from " + socket.getRemoteSocketAddress());

            OutputStream outToClient = socket.getOutputStream();
            DataOutputStream out = new DataOutputStream(outToClient);
            out.writeUTF("Connection established");

            InputStream inFromClient = socket.getInputStream();
            DataInputStream in = new DataInputStream(inFromClient);
            String message = in.readUTF();
            System.out.println("Received: " + message);

            socket.close();
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}