/*
 * Classe principale
*/

package Karazhan.android;

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.widget.AbsListView.LayoutParams;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Karazhan extends Activity
{    
    private TextView RoomName = null;
    private TextView description = null;
    private Bundle source;
    private LinearLayout ButtonDoor;
    private Room room;
    private Player player;


    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        try {
            // Try to connect to Internet
            ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo netInfo = cm.getActiveNetworkInfo();
            //Set basic data
            this.player = new Player(this);
            this.player.setLife(20);
            this.player.setName("JO");
            this.player.setType("humain");
            this.player.setPp(3);
            this.player.setSpeed(5);
            this.player.setRoom(new Room(this.player, null));
        }
        catch(Exception e)
        {
            //MSG for connectivity failure to internet
            LinearLayout ll = (LinearLayout)findViewById(R.id.Door);
            LayoutParams bp = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
            TextView error = new TextView(this);
            error.setText("INTERNET = " + e + "\nPlease, verify you're connectivity and authorization for this application and restart it");
            ll.addView(error, bp);
        }
    }
}