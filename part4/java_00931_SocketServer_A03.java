import java.io.*;
import java.net.*;

public class java_00931_SocketServer_A03 {
    private static final int PORT = 8080;
    private static final String INET_ADDRESS = null;

    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket();
            server.bind(new InetSocketAddress(PORT));

            System.out.println("Server started at port " + PORT + "...");

            while (true) {
                Socket client = server.accept();
                System.out.println("New client connected: " + client.getRemoteSocketAddress());

                Thread thread = new Thread(new ClientHandler(client));
                thread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class ClientHandler implements Runnable {
    private Socket client;

    public java_00931_SocketServer_A03(Socket client) {
        this.client = client;
    }

    @Override
    public void run() {
        try {
            InputStream input = client.getInputStream();
            DataInputStream dis = new DataInputStream(input);

            String msg = dis.readUTF();
            System.out.println("Received: " + msg);

            OutputStream output = client.getOutputStream();
            DataOutputStream dos = new DataOutputStream(output);

            String response = "Server: Hello, client!";
            dos.writeUTF(response);
            dos.flush();

            client.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}