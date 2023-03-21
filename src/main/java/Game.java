import java.util.ArrayList;
import java.util.List;

public class Game {
    List<Player> registered = new ArrayList<>();

    public void register(Player player) {
        if (findByName(player.getName()) == null) {
            registered.add(player);
        } else {
            throw new AlreadyExistException("Игрок с именем " + player.getName() + " уже зарегистрирован");
        }
    }

    public Player findByName(String name) {
        for (Player player : registered) {
            if (player.getName().equals(name)) {
                return player;
            }
        }
        return null;
    }

    public int round(String playerName1, String playerName2) {
        Player player1;
        Player player2;
        if (findByName(playerName1) != null) {
            player1 = findByName(playerName1);
        } else {
            throw new NotRegisteredException("Игрок с именем " + playerName1 + " не зарегистрирован");
        }
        if (findByName(playerName2) != null) {
            player2 = findByName(playerName2);
        } else {
            throw new NotRegisteredException("Игрок с именем " + playerName2 + " не зарегистрирован");
        }

        if (player1.getStrength() == player2.getStrength()) {
            return 0;
        } else if (player1.getStrength() > player2.getStrength()) {
            return 1;
        } else {
            return 2;
        }
    }
}