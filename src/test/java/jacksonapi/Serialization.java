package jacksonapi;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.FileWriter;

public class Serialization {

    public static void main(String [] args) throws JsonProcessingException {
        FootballPlayer player = new FootballPlayer();
        player.setLeague("La Liga");
        player.setClub("FC Barcelona");
        player.setPlayerName("Lionel Messi");
        player.setCountry("Argentina");
        player.setGoals(850);
        player.setPosition("Winger");

        FootballPlayer player1 = new FootballPlayer();
        player1.setLeague("Premier League");
        player1.setClub("Manchester United");
        player1.setPlayerName("Cristiano Ronaldo");
        player1.setCountry("Portugal");
        player1.setGoals(900);
        player1.setPosition("Striker");

        ObjectMapper objectMapper = new ObjectMapper();
        String convertedJson1 = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(player);
        System.out.println(convertedJson1);

        String convertedJson2 = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(player1);
        System.out.println(convertedJson2);

    }
}
