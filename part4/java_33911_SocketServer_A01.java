import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class java_33911_SocketServer_A01 {
    private static ExecutorService executor;

    public static void main(String[] args) {
        int port = 1234;
        ServerSocket serverSocket = null;

        try {
            serverSocket = new ServerSocket(port);
            System.out.println("Server is listening on port " + port);
            executor = Executors.newFixedThreadPool(10);
            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected");
                ServerHandler serverHandler = new ServerHandler(socket);
                executor.execute(serverHandler);
            }
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

class ServerHandler implements Runnable {
    private Socket socket;

    public java_33911_SocketServer_A01(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        try {
            InputStream inputStream = socket.getInputStream();
            DataInputStream dataInputStream = new DataInputStream(inputStream);
            String message = dataInputStream.readUTF();
            System.out.println("Received message: " + message);

            OutputStream outputStream = socket.getOutputStream();
            DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
            dataOutputStream.writeUTF("Server received the message");
            dataOutputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}