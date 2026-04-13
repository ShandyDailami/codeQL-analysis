import java.net.*;
import java.io.*;

public class java_38482_SocketServer_A03 {
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(8189);
        System.out.println("Waiting for client on port " + 
                            serverSocket.getLocalPort() + "...");

        Socket socket = serverSocket.accept();
        System.out.println("Just connected to " + socket.getRemoteSocketAddress());

        OutputStream outToClient = socket.getOutputStream();
        DataOutputStream out = new DataOutputStream(outToClient);

        // Now to receive data from the client
        InputStream inFromClient = socket.getInputStream();
        DataInputStream in = new DataInputStream(inFromClient);

        String clientMessage, serverMessage;
        clientMessage = in.readUTF();
        System.out.println("Client says: " + clientMessage);

        serverMessage = "Hello, you are connected to " + socket.getLocalSocketAddress() + "!";
        out.writeUTF(serverMessage);

        socket.close();
    }
}