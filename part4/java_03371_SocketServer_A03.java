import java.io.*;
import java.net.*;

public class java_03371_SocketServer_A03 {
    public static void main(String[] args) {
        int port = 6666;
        ServerSocket serverSocket = null;
        Socket socket = null;
        DataInputStream dis = null;
        DataOutputStream dos = null;
        String inputLine = null;

        try {
            serverSocket = new ServerSocket(port);
            System.out.println("Server is listening on port " + port);

            socket = serverSocket.accept();
            System.out.println("Client " + socket.getRemoteSocketAddress() + " has connected.");

            dis = new DataInputStream(socket.getInputStream());
            dos = new DataOutputStream(socket.getOutputStream());

            inputLine = dis.readUTF();
            System.out.println("Client says: " + inputLine);

            // A03_Injection: Echo back the input string in uppercase
            String upperCaseInput = inputLine.toUpperCase();
            dos.writeUTF("ECHO: " + upperCaseInput);

            socket.close();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}