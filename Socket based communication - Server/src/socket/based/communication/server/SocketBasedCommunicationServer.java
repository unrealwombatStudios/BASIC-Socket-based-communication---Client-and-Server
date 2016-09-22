
package socket.based.communication.server;

/**
 *
 * @author unrealWombat
 */
public class SocketBasedCommunicationServer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Server server = new Server();
        server.receiveData();
    }
    
}
