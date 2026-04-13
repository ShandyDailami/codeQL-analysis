import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_19330_SocketServer_A07 {
    private static final int PORT = 54321;

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected");

                Thread clientHandler = new Thread(new SocketHandler(clientSocket));
                clientHandler.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class SocketHandler implements Runnable {
    private Socket socket;
    private String clientAddress;

    public java_19330_SocketServer_A07(Socket socket) {
        this.socket = socket;
        this.clientAddress = socket.getInetAddress().getHostAddress();
    }

    @Override
    public void run() {
        try {
            while (true) {
                byte[] buffer = new byte[1024];
                BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

                String message = reader.readLine();
                if (message == null || message.equals("exit")) {
                    break;
                }

                System.out.println("Received from client: " + message);
                String response = "Echo: " + message;

                byte[] bytes = response.getBytes();
                socket.getOutputStream().write(bytes);
                socket.getOutputStream().flush();
            }

            socket.close();
            System.out.println("Client disconnected from " + clientAddress);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}