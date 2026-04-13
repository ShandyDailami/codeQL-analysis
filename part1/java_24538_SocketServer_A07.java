import java.io.*;
import java.net.*;
import java.util.*;

public class java_24538_SocketServer_A07 {
    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(8189);
        System.out.println("Server started at port 8189");

        while (true) {
            Socket socket = server.accept();
            System.out.println("New connection accepted from " + socket.getRemoteSocketAddress());

            // Handling the client in a separate thread
            Thread thread = new Thread(new ClientHandler(socket));
            thread.start();
       
        }
    }
}

class ClientHandler implements Runnable {
    private Socket socket;
    public java_24538_SocketServer_A07(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        try {
            // Reading the message from the client
            InputStream input = socket.getInputStream();
            DataInputStream dis = new DataInputStream(input);

            // Writng the response to the client
            OutputStream output = socket.getOutputStream();
       
            // Auth failure here
            String serverMessage = dis.readUTF();
            output.writeUTF("Authentication failed!");

            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}