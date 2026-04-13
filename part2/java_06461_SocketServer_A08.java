import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_06461_SocketServer_A08 {

    private static final int PORT = 9876; // Change this port number

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(PORT);
            System.out.println("Server started at port " + PORT);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected at " + socket.getRemoteSocketAddress());

                // Here we create a new thread for each client.
                // In a real server, you would want to use a ThreadPoolExecutor.
                new EchoHandler(socket).start();
            }
        } catch (IOException ex) {
            System.out.println("Error accepting client connection at port " + PORT);
            ex.printStackTrace();
            System.exit(-1);
       
        } finally {
            serverSocket.close();
        }
    }
}

class EchoHandler extends Thread {
    private Socket socket;

    public java_06461_SocketServer_A08(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            // Here we read from the socket.
            // For a real server, we would want to use a BufferedReader and PrintWriter.
            // But this example is only handling simple text transfers.
            // In a real server, you would want to use SSL/TLS for secure communication.
            // But it is too complex to handle SSL/TLS here.
            // So, for simplicity, we just print the received message.
            socket.getInputStream().read();
            System.out.println("Received: " + socket.getInputStream().read());

            // Here we write back to the socket.
            // For a real server, we would want to use a BufferedWriter and PrintWriter.
            // But this example is only handling simple text transfers.
            // In a real server, you would want to use SSL/TLS for secure communication.
            // But it is too complex to handle SSL/TLS here.
            // So, for simplicity, we just print the message.
            socket.getOutputStream().write("Hello, World!\n".getBytes());
            socket.getOutputStream().flush();
            System.out.println("Sent: Hello, World!");
        } catch (IOException ex) {
            System.out.println("Error handling client at " + socket.getRemoteSocketAddress());
            ex.printStackTrace();
        } finally {
            socket.close();
        }
    }
}