
package socket.based.communication.client;

/**
 *
 * @author unrealWombat
 */
public class SocketBasedCommunicationClient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Client client = new Client();
        client.sendData("Hello world!");
    }
   
}
