import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class java_39873_SocketServer_A07 {

    private static final Logger logger = Logger.getLogger(SocketServer.class.getName());

    public static void main(String[] args) {

        int port = 1234;
        ServerSocket server = null;
        try {
            server = new ServerSocket(port);
            logger.info("Server started at port: " + port);

            while (true) {
                Socket socket = server.accept();
                new Thread(new ServerThread(socket)).start();
            }

        } catch (IOException ex) {
            logger.log(Level.SEVERE, "IOException in main", ex);
       
        } finally {
            try {
                if (server != null)
                    server.close();
            } catch (IOException ex) {
                logger.log(Level.SEVERE, "IOException in closing", ex);
            }
        }
    }

}

class ServerThread implements Runnable {

    private Socket socket;

    public java_39873_SocketServer_A07(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {

        // here you can implement your server logic
        // for example, you can create a new thread for each client,
        // and handle the client's request and response
    }

}