/*
 * 
*/
package Karazhan.android;

import android.widget.TextView;
import java.net.URL;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;

public abstract class AbstractRoom implements RoomInterface
{
    protected Document doc;
    protected Player player;
    protected TextView RoomName;
    protected TextView description;

    //Getter and Setter
    public Document getDoc() {
        return this.doc;
    }

    public void setDoc(Document doc) {
        this.doc = doc;
    }

    public Player getPlayer() {
        return this.player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public TextView getRoom_name() {
        return RoomName;
    }

    public void setRoom_name(TextView RoomName) {
        this.RoomName = RoomName;
    }

    public TextView getDescription() {
        return this.description;
    }

    public void setDescription(TextView textview) {
        this.description = textview;
    }

    //other function
    protected void loadDoors() {
    }

    public void loadRoom() {
    }

    //Try to connect and get xml data
    protected Document URLRoom(String source) {
        URL url;
        try {
            if (source != null) {
                url = new URL("http://www.geektest.org/bundles/mioreygeektest/karazhan/" + source + ".xml");
            }
            else {
                url = new URL("http://www.geektest.org/bundles/mioreygeektest/karazhan/couloir.xml");
            }
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            return (db.parse(new InputSource(url.openStream())));
        }
        catch (Exception e)
        {
            return null;
        }
    }
}