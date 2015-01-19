/*
 * 
 */
package Karazhan.android;

import android.widget.AbsListView;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.net.URL;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

public class Room extends AbstractRoom {

    @Override
    public void loadRoom() {
        this.RoomName = (TextView) this.player.getActivity().findViewById(R.id.Room_Name);
        this.description = (TextView) this.player.getActivity().findViewById(R.id.Description);
        this.doc.getDocumentElement().normalize();
        NodeList piece_nl = this.doc.getElementsByTagName("piece");
        Node piece_n = (Node) piece_nl.item(0);
        NamedNodeMap piece_nnm = piece_n.getAttributes();
        this.RoomName.setText(piece_nnm.item(0).getNodeValue());
        this.description.setText(piece_nnm.item(1).getNodeValue());
    }

    @Override
    protected void loadDoors()
    {
        int i = 0;

        NodeList piece_nl = this.doc.getElementsByTagName("piece").item(0).getChildNodes();
        //Get root for every door
        while(!"portes".equals(piece_nl.item(i).getNodeValue())
            && i < (piece_nl.getLength() - 1)) {
            i++;
        }
        NodeList door_nl = piece_nl.item(i).getChildNodes();
        for (int j = 1; j < door_nl.getLength(); j++)
        {
            NamedNodeMap door_nnm = door_nl.item(j).getAttributes();
            Door door = new Door(this.player, door_nnm);
        }
    }

    @Override
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
            LinearLayout ll = (LinearLayout)this.player.getActivity().findViewById(R.id.Door);
            AbsListView.LayoutParams bp = new AbsListView.LayoutParams(
                    AbsListView.LayoutParams.WRAP_CONTENT,
                    AbsListView.LayoutParams.WRAP_CONTENT);
            TextView error = new TextView(this.player.getActivity());
            error.setText("XML Pasing Excpetion = " + e + "\nPlease, verify you're connectivity and restart this application");
            ll.addView(error, bp);
            return null;
        }
    }

    public Room(Player player , String source) {
        this.player = player;
        this.doc = URLRoom(source);
        this.loadRoom();
        this.loadDoors();
    }
}
