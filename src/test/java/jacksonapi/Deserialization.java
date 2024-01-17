package jacksonapi;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Deserialization {
    public static void main(String [] args) throws JsonProcessingException {

        String playerData = "{\n" +
                "  \"league\" : \"La Liga\",\n" +
                "  \"club\" : \"FC Barcelona\",\n" +
                "  \"playerName\" : \"Lionel Messi\",\n" +
                "  \"country\" : \"Argentina\",\n" +
                "  \"goals\" : 850,\n" +
                "  \"position\" : \"Winger\"\n" +
                "}";

        ObjectMapper objectMapper = new ObjectMapper();
        FootballPlayer player = objectMapper.readValue(playerData, FootballPlayer.class);

        String league = player.getLeague();
        String club = player.getClub();
        String playerName = player.getPlayerName();
        String country = player.getCountry();
        int goals = player.getGoals();
        String position = player.getPosition();

        System.out.println(" --- Player Info ---");
        System.out.println("league: "+league);
        System.out.println("Club: "+club);
        System.out.println("PlayerName: "+playerName);
        System.out.println("country: "+ country);
        System.out.println("Total Goals : "+goals);
        System.out.println("Position : "+position);

    }
}
