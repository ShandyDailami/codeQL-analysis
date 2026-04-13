import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_06932_SocketServer_A01 {
    public static void main(String[] args) throws IOException {
        // create a ServerSocket to listen on port 1234
        ServerSocket server = new ServerSocket(1234);

        while (true) {
            // accept a client connection
            Socket socket = server.accept();

            // here you would typically create a new thread for each client connection
            // however, for the sake of simplicity, this example only handles one client at a time
            new ClientHandler(socket).start();
        }
    }
}

class ClientHandler extends Thread {
    private Socket socket;

    public java_06932_SocketServer_A01(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        // here you would typically handle communication with the client
        // for the sake of simplicity, this example only reads and writes a single line of text
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                out.println("Echo: " + inputLine);
            }

            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}