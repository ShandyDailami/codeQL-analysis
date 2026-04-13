import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_14005_SocketServer_A03 {
    private ServerSocket serverSocket;

    public java_14005_SocketServer_A03(int port) throws IOException {
        serverSocket = new ServerSocket(port);
    }

    public void startServer() {
        System.out.println("Server started.");
        while (true) {
            try {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected.");
                SocketThread socketThread = new SocketThread(clientSocket);
                socketThread.start();
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("Error while accepting client connection.");
            }
        }
    }

    public static void main(String[] args) {
        try {
            SocketServer server = new SocketServer(1234);
            server.startServer();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class SocketThread extends Thread {
    private Socket socket;
    private DataInputStream inputStream;
    private DataOutputStream outputStream;

    public java_14005_SocketServer_A03(Socket socket) {
        this.socket = socket;
        try {
            inputStream = new DataInputStream(socket.getInputStream());
            outputStream = new DataOutputStream(socket.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        try {
            String message = inputStream.readUTF();
            System.out.println("Received message: " + message);
            outputStream.writeUTF("Message received.");
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}