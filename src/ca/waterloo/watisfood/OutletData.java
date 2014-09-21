package ca.waterloo.watisfood;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.math.BigDecimal;
import java.util.List;

@Root(name = "response")
public class OutletData {

    public static final String API_URL = "https://api.uwaterloo.ca/v2/foodservices/locations.xml?key=f41a069b66774984b6e9d1c406432122";

    @Element(name="meta", required = false)
    Meta meta;


    @ElementList(name = "data", required = false)
    List<Item> data;



    public Meta getMeta() { return this.meta; }
    public void setMeta(Meta _value) { this.meta = _value; }


    public List<Item> getData() { return this.data; }
    public void setData(List<Item> _value) { this.data = _value; }



    public static class Meta {

        @Element(name="requests", required = false)
        String requests;


        @Element(name="timestamp", required = false)
        String timestamp;


        @Element(name="status", required = false)
        String status;


        @Element(name="message", required = false)
        String message;


        @Element(name="method_id", required = false)
        String method_id;


        @Element(name="method", required = false)
        String method;


        public String getRequests() { return this.requests; }
        public void setRequests(String _value) { this.requests = _value; }


        public String getTimestamp() { return this.timestamp; }
        public void setTimestamp(String _value) { this.timestamp = _value; }


        public String getStatus() { return this.status; }
        public void setStatus(String _value) { this.status = _value; }


        public String getMessage() { return this.message; }
        public void setMessage(String _value) { this.message = _value; }


        public String getMethod_id() { return this.method_id; }
        public void setMethod_id(String _value) { this.method_id = _value; }

        public String getMethod() { return this.method; }
        public void setMethod(String _value) { this.method = _value; }
    }

    public static class Item {

        @Element(name="outlet_id", required = false)
        String outlet_id;


        @Element(name="outlet_name", required = false)
        String outlet_name;


        @Element(name="building", required = false)
        String building;


        @Element(name="logo", required = false)
        String logo;


        @Element(name="latitude", required = false)
        String latitude;


        @Element(name="longitude", required = false)
        String longitude;

        @Element(name="description", required = false)
        String description;

        @Element(name="notice", required = false)
        String notice;

        @Element(name="is_open_now", required = false)
        String is_open_now;

        @Element(name="opening_hours", required = false)
        Opening_hours opening_hours;


        @ElementList(name = "special_hours", required = false)
        List<String> special_hours;


        @Element(name="date", required = false)
        String date;


        @Element(name="opening_hour", required = false)
        String opening_hour;


        @Element(name="closing_hour", required = false)
        String closing_hour;


        @ElementList(name = "dates_closed", required = false)
        List<String> dates_closed;


        @Element(name="additional", required = false)
        Additional additional;



        public String getOutlet_id() { return this.outlet_id; }
        public void setOutlet_id(String _value) { this.outlet_id = _value; }


        public String getOutlet_name() { return this.outlet_name; }
        public void setOutlet_name(String _value) { this.outlet_name = _value; }


        public String getBuilding() { return this.building; }
        public void setBuilding(String _value) { this.building = _value; }


        public String getLogo() { return this.logo; }
        public void setLogo(String _value) { this.logo = _value; }


        public String getLatitude() { return this.latitude; }
        public void setLatitude(String _value) { this.latitude = _value; }


        public String getLongitude() { return this.longitude; }
        public void setLongitude(String _value) { this.longitude = _value; }


        public String getDescription() { return this.description; }
        public void setDescription(String _value) { this.description = _value; }


        public String getNotice() { return this.notice; }
        public void setNotice(String _value) { this.notice = _value; }


        public String getIs_open_now() { return this.is_open_now; }
        public void setIs_open_now(String _value) { this.is_open_now = _value; }


        public Opening_hours getOpening_hours() { return this.opening_hours; }
        public void setOpening_hours(Opening_hours _value) { this.opening_hours = _value; }


        public List<String> getSpecial_hours() { return this.special_hours; }
        public void setSpecial_hours(List<String> _value) { this.special_hours = _value; }


        public String getDate() { return this.date; }
        public void setDate(String _value) { this.date = _value; }


        public String getOpening_hour() { return this.opening_hour; }
        public void setOpening_hour(String _value) { this.opening_hour = _value; }


        public String getClosing_hour() { return this.closing_hour; }
        public void setClosing_hour(String _value) { this.closing_hour = _value; }


        public List<String> getDates_closed() { return this.dates_closed; }
        public void setDates_closed(List<String> _value) { this.dates_closed = _value; }


        public Additional getAdditional() { return this.additional; }
        public void setAdditional(Additional _value) { this.additional = _value; }


    }

    public static class Opening_hours {

        @Element(name="sunday", required = false)
        Sunday sunday;


        @Element(name="monday", required = false)
        Monday monday;


        @Element(name="tuesday", required = false)
        Tuesday tuesday;


        @Element(name="wednesday", required = false)
        Wednesday wednesday;


        @Element(name="thursday", required = false)
        Thursday thursday;


        @Element(name="friday", required = false)
        Friday friday;


        @Element(name="saturday", required = false)
        Saturday saturday;



        public Sunday getSunday() { return this.sunday; }
        public void setSunday(Sunday _value) { this.sunday = _value; }


        public Monday getMonday() { return this.monday; }
        public void setMonday(Monday _value) { this.monday = _value; }


        public Tuesday getTuesday() { return this.tuesday; }
        public void setTuesday(Tuesday _value) { this.tuesday = _value; }


        public Wednesday getWednesday() { return this.wednesday; }
        public void setWednesday(Wednesday _value) { this.wednesday = _value; }


        public Thursday getThursday() { return this.thursday; }
        public void setThursday(Thursday _value) { this.thursday = _value; }


        public Friday getFriday() { return this.friday; }
        public void setFriday(Friday _value) { this.friday = _value; }


        public Saturday getSaturday() { return this.saturday; }
        public void setSaturday(Saturday _value) { this.saturday = _value; }


    }

    public static class Sunday {

        @Element(name="opening_hour", required = false)
        String opening_hour;


        @Element(name="closing_hour", required = false)
        String closing_hour;


        @Element(name="is_closed", required = false)
        String is_closed;



        public String getOpening_hour() { return this.opening_hour; }
        public void setOpening_hour(String _value) { this.opening_hour = _value; }


        public String getClosing_hour() { return this.closing_hour; }
        public void setClosing_hour(String _value) { this.closing_hour = _value; }


        public String getIs_closed() { return this.is_closed; }
        public void setIs_closed(String _value) { this.is_closed = _value; }


    }

    public static class Monday {

        @Element(name="opening_hour", required = false)
        String opening_hour;


        @Element(name="closing_hour", required = false)
        String closing_hour;


        @Element(name="is_closed", required = false)
        String is_closed;



        public String getOpening_hour() { return this.opening_hour; }
        public void setOpening_hour(String _value) { this.opening_hour = _value; }


        public String getClosing_hour() { return this.closing_hour; }
        public void setClosing_hour(String _value) { this.closing_hour = _value; }


        public String getIs_closed() { return this.is_closed; }
        public void setIs_closed(String _value) { this.is_closed = _value; }


    }

    public static class Tuesday {

        @Element(name="opening_hour", required = false)
        String opening_hour;


        @Element(name="closing_hour", required = false)
        String closing_hour;


        @Element(name="is_closed", required = false)
        String is_closed;



        public String getOpening_hour() { return this.opening_hour; }
        public void setOpening_hour(String _value) { this.opening_hour = _value; }


        public String getClosing_hour() { return this.closing_hour; }
        public void setClosing_hour(String _value) { this.closing_hour = _value; }


        public String getIs_closed() { return this.is_closed; }
        public void setIs_closed(String _value) { this.is_closed = _value; }


    }

    public static class Wednesday {

        @Element(name="opening_hour", required = false)
        String opening_hour;


        @Element(name="closing_hour", required = false)
        String closing_hour;


        @Element(name="is_closed", required = false)
        String is_closed;



        public String getOpening_hour() { return this.opening_hour; }
        public void setOpening_hour(String _value) { this.opening_hour = _value; }


        public String getClosing_hour() { return this.closing_hour; }
        public void setClosing_hour(String _value) { this.closing_hour = _value; }


        public String getIs_closed() { return this.is_closed; }
        public void setIs_closed(String _value) { this.is_closed = _value; }


    }

    public static class Thursday {

        @Element(name="opening_hour", required = false)
        String opening_hour;


        @Element(name="closing_hour", required = false)
        String closing_hour;


        @Element(name="is_closed", required = false)
        String is_closed;



        public String getOpening_hour() { return this.opening_hour; }
        public void setOpening_hour(String _value) { this.opening_hour = _value; }


        public String getClosing_hour() { return this.closing_hour; }
        public void setClosing_hour(String _value) { this.closing_hour = _value; }


        public String getIs_closed() { return this.is_closed; }
        public void setIs_closed(String _value) { this.is_closed = _value; }


    }

    public static class Friday {

        @Element(name="opening_hour", required = false)
        String opening_hour;


        @Element(name="closing_hour", required = false)
        String closing_hour;


        @Element(name="is_closed", required = false)
        String is_closed;



        public String getOpening_hour() { return this.opening_hour; }
        public void setOpening_hour(String _value) { this.opening_hour = _value; }


        public String getClosing_hour() { return this.closing_hour; }
        public void setClosing_hour(String _value) { this.closing_hour = _value; }


        public String getIs_closed() { return this.is_closed; }
        public void setIs_closed(String _value) { this.is_closed = _value; }


    }

    public static class Saturday {

        @Element(name="opening_hour", required = false)
        String opening_hour;


        @Element(name="closing_hour", required = false)
        String closing_hour;


        @Element(name="is_closed", required = false)
        String is_closed;



        public String getOpening_hour() { return this.opening_hour; }
        public void setOpening_hour(String _value) { this.opening_hour = _value; }


        public String getClosing_hour() { return this.closing_hour; }
        public void setClosing_hour(String _value) { this.closing_hour = _value; }


        public String getIs_closed() { return this.is_closed; }
        public void setIs_closed(String _value) { this.is_closed = _value; }


    }

    public static class Special_hours {

        @Element(name="item", required = false)
        Item item;



        public Item getItem() { return this.item; }
        public void setItem(Item _value) { this.item = _value; }


    }

    public static class Additional {

        @Element(name="menu_url", required = false)
        String menu_url;

        public String getMenu_url() { return this.menu_url; }
        public void setMenu_url(String _value) { this.menu_url = _value; }


    }
}