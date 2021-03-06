import com.bawarchef.Broadcast.BroadcastEngine;
import com.bawarchef.Communication.Listener;
import com.bawarchef.DBConnect;
import com.bawarchef.Preferences;
import com.bawarchef.TrackEngine;

public class Main {

    static Preferences p=null;

    public static void main(String[] args){
        System.out.println("STARTING...");
        BroadcastEngine.getInstance();

        p = Preferences.getInstance();
        DBConnect.getInstance();

        Listener l = new Listener(p.PORT0);

        l.setOnStartListeningListener(new Listener.OnStartListeningListener() {
            @Override
            public void onStartListening() {
                System.out.println("Started Listening on port. "+l.getPort_no());
            }
        });

        l.setOnStopListeningListener(new Listener.OnStopListeningListener() {
            @Override
            public void onStopListening() {
                System.out.println("ListeningStopped");
            }
        });

        l.startListening();
    }


}
