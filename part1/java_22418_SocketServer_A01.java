import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_22418_SocketServer_A01 {

    private ServerSocket serverSocket;

    public java_22418_SocketServer_A01(int port) {
        try {
            serverSocket = new ServerSocket(port);
            System.out.println("Server is listening on port: " + port);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void startServer() {
        while (true) {
            try {
                Socket socket = serverSocket.accept();
                System.out.println("A new client has connected: " + socket.getInetAddress().getHostAddress());
                DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
                DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
                ClientHandler clientHandler = new ClientHandler(dataInputStream, dataOutputStream);
                Thread thread = new Thread(clientHandler);
                thread.start();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Server server = new Server(5454);
        server.startServer();
    }
}

class ClientHandler implements Runnable {

    private DataInputStream dataInputStream;
    private DataOutputStream dataOutputStream;

    public java_22418_SocketServer_A01(DataInputStream dataInputStream, DataOutputStream dataOutputStream) {
        this.dataInputStream = dataInputStream;
        this.dataOutputStream = dataOutputStream;
    }

    @Override
    public void run() {
        try {
            String message;
            while ((message = dataInputStream.readUTF()) != null) {
                System.out.println("Received: " + message);
                dataOutputStream.writeUTF("Server: " + message);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}