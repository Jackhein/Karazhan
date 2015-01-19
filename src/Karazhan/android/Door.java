/*
 * Classe pour les portes
 */

package Karazhan.android;

import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.AbsListView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import org.w3c.dom.NamedNodeMap;

public class Door extends AbstractDoor {
    
    public Door(Player player, NamedNodeMap DoorNNM) {
        this.DoorNNM = DoorNNM;
        this.player = player;

        this.door = new Button(this.player.getActivity());
        this.viewDoor();
        this.door.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View V)
            {
                clickDoor();
            }
        });
        LinearLayout ll = (LinearLayout)this.player.getActivity().findViewById(R.id.Door);
        ll.addView(this.door, this.bp);
        bp = new AbsListView.LayoutParams(
        AbsListView.LayoutParams.WRAP_CONTENT,
        AbsListView.LayoutParams.WRAP_CONTENT);
        TextView Door_name = new TextView(this.player.getActivity());
        Door_name.setTextColor(Color.parseColor("#550000"));
        Door_name.setTypeface(Typeface.SERIF);
        Door_name.setText(DoorNNM.item(1).getNodeValue());
        ll.addView(Door_name, bp);
    }

    protected void viewDoor() {
        try
        {
            URL img_url = new URL("http://www.worldofmunchkin.com/icons/img/m6.gif");
            InputStream img_is = (InputStream) img_url.getContent();
            Drawable img_d = Drawable.createFromStream(img_is, "img");
            //setBackgroundDrawable is only for API below API16
            //For API below 16, use : "setBackground"
            this.door.setBackgroundDrawable(img_d);
            this.bp = new AbsListView.LayoutParams(50, 50);
        }
        catch (IOException e)
        {
            this.door.setText(DoorNNM.item(1).getNodeValue());
            this.bp = new AbsListView.LayoutParams(
                    AbsListView.LayoutParams.WRAP_CONTENT,
                    AbsListView.LayoutParams.WRAP_CONTENT);
        }
    }

    protected void clickDoor() {
        this.player.getActivity().setContentView(R.layout.main);
        this.player.setRoom(new Room(this.player, DoorNNM.item(0).getNodeValue()));
    }
}
