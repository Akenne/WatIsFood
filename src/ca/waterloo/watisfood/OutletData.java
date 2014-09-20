package ca.waterloo.watisfood;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.List;

/**
 * Created by Kevin on 20/09/2014.
 */

@Root(strict = false)
public class OutletData {

    public static final String API_URL = "https://api.uwaterloo.ca/v2/foodservices/locations.xml?key=f41a069b66774984b6e9d1c406432122";

    @ElementList(name = "item, inline = true")
    List<Item> item;

    public static class Item {
        @Element(name = "outlet_id")
        String id;

        @Element(name = "outlet_name")
        String name;

        @Element(name = "description")
        String description;
    }
}

