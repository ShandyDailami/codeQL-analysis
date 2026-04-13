import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_16893_SocketServer_A03 {

    private static final int PORT = 5000;

    public static void main(String[] args) {
        Socket socket;
        ServerSocket serverSocket;

        try {
            serverSocket = new ServerSocket(PORT);
            System.out.println("Server started at port " + PORT);

            while (true) {
                socket = serverSocket.accept();
                System.out.println("Client connected from " + socket.getRemoteSocketAddress());

                // Create new thread to handle client
                new ClientHandler(socket).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
       
        } finally {
            try {
                if (serverSocket != null) {
                    serverSocket.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}

class ClientHandler extends Thread {
    private Socket socket;

    public java_16893_SocketServer_A03(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        try {
            // Handle client here
            // Use InputStream to read from client and OutputStream to write to client
            // Use BufferedReader to read and write strings from and to client

            // Example:
            // BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            // BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            // out.write("Hello client, you connected!");
            // out.newLine();
            // out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}