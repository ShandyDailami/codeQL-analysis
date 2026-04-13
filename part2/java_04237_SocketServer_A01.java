import java.io.*;
import java.net.*;

public class java_04237_SocketServer_A01 {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080);
        while (true) {
            Socket clientSocket = serverSocket.accept();
            System.out.println("New client connected: " + clientSocket.getRemoteSocketAddress());

            // Create a new thread for each client
            Thread thread = new Thread(new SocketHandler(clientSocket));
            thread.start();
        }
    }
}

class SocketHandler implements Runnable {
    private Socket socket;

    public java_04237_SocketServer_A01(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            String request = in.readLine();
            out.writeUTF("Hello, client. You sent: " + request);
            out.flush();

            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}