import java.util.HashMap;

public class Game {
    HashMap<String, Player> registered = new HashMap<>();

    public void register(Player player) {
        if (registered.containsKey(player.getName())) {
            throw new AlreadyExistException("Игрок с именем " + player.getName() + " уже зарегистрирован");
        } else {
            registered.put(player.getName(), player);
        }
    }

    public HashMap<String, Player> getAllRegistered() {
        return registered;
    }

    public int round(String playerName1, String playerName2) {
        Player player1;
        Player player2;
        if (registered.containsKey(playerName1)) {
            player1 = registered.get(playerName1);
        } else {
            throw new NotRegisteredException("Игрок с именем " + playerName1 + " не зарегистрирован");
        }
        if (registered.containsKey(playerName2)) {
            player2 = registered.get(playerName2);
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