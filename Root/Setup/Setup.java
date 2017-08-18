package xboxapi.Root.Setup;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import xboxapi.Presence;

import static xboxapi.Presence.State;

public class Setup {

    public static JSONObject JSONObject(String str, String get) {
        JSONParser parser = new JSONParser();
        JSONObject var = null;
        try {
            Object obj = parser.parse(str);
            JSONObject jObj = (JSONObject) obj;
            var = (JSONObject) jObj.get(get);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return var;
    }
    public static JSONObject jsonParse(String str) {
        JSONParser parser = new JSONParser();
        JSONObject var = null;
        try {
            Object obj = parser.parse(str);
            var = (JSONObject) obj;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return var;
    }
    public static String objString(JSONObject str, String get) {
        return (String) str.get(get);
    }

    public static String String(String str, String get) {
        JSONParser parser = new JSONParser();
        String var = null;
        try {
            Object obj = parser.parse(str);
            JSONObject jObj = (JSONObject) obj;
            var = (String) jObj.get(get);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return var;
    }

    public static Long Long(String str, String get) {
        JSONParser parser = new JSONParser();
        Long var = null;
        try {
            Object obj = parser.parse(str);
            JSONObject jObj = (JSONObject) obj;
            var = (Long) jObj.get(get);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return var;
    }

    public static Boolean Boolean(String str, String get) {
        JSONParser parser = new JSONParser();
        Boolean var = null;
        try {
            Object obj = parser.parse(str);
            JSONObject jObj = (JSONObject) obj;
            var = (Boolean) jObj.get(get);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return var;
    }
    public static Boolean isOnline(String json){
        Boolean isOnline = false;
        Presence presenceInfo = new Presence();
        String state = presenceInfo.State(json);
        if(state=="Online"){
            isOnline = true;
        }else if(state=="Offline"){
            isOnline =  false;
        }
        return isOnline;
    }
}
