package xboxapi;

import xboxapi.Root.Setup.POST;

import static xboxapi.Root.Setup.Setup.isOnline;

public class Main {

    public static void main(String[] args) throws Exception {

        System.out.println("Sending GET request to Xbox for gamertag...");

        //POST.Message("Your Message", "TargetXuid");


        Endpoints root = new Endpoints();

        String xuid = root.XUID("Ventralkillakam");
        System.out.println("XUID of user is: " + xuid);

        String profileJson = root.Profile(xuid);
        String gamercardJson = root.Gamercard(xuid);
        String presenceJson = root.Presence(xuid);

        //System.out.println("Gamercard JSON: " + gamercardJson);
        //System.out.println("Profile JSON: " + profileJson);
        System.out.println("Presence JSON: " + presenceJson);

        Profile profileInfo = new Profile();
        String allProfile = profileInfo.All(profileJson);
        System.out.println(allProfile);

        Gamercard gamercardInfo = new Gamercard();
        String allGamercard = gamercardInfo.All(gamercardJson);
        System.out.println(allGamercard);

        Presence presenceInfo = new Presence();
        Boolean isOnline = isOnline(presenceJson);
        String allPresence = presenceInfo.All(presenceJson, isOnline);
        System.out.println(allPresence);


    }
}