import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    @Test
    public void shouldThrowExceptionWhenRegisteringIfAlreadyExist() {
        Game game = new Game();
        Player player1 = new Player(1, "fighter", 10);
        Player player2 = new Player(2, "warrior", 2);
        Player player3 = new Player(3, "topgun10", 4);
        Player player4 = new Player(4, "alex1", 15);
        Player player5 = new Player(5, "vasya", 12);
        Player player6 = new Player(6, "warrior", 7);

        game.register(player1);
        game.register(player2);
        game.register(player3);
        game.register(player4);
        game.register(player5);

        assertThrows(AlreadyExistException.class, () -> game.register(player6));
    }

    @Test
    public void shouldWinPlayer1() {
        Game game = new Game();
        Player player1 = new Player(1, "fighter", 10);
        Player player2 = new Player(2, "warrior", 2);
        Player player3 = new Player(3, "topgun10", 4);
        Player player4 = new Player(4, "alex1", 15);
        Player player5 = new Player(5, "vasya", 12);
        Player player6 = new Player(6, "hero1993", 7);

        game.register(player1);
        game.register(player2);
        game.register(player3);
        game.register(player4);
        game.register(player5);
        game.register(player6);

        int expected = 1;
        int actual = game.round("alex1", "warrior");

        assertEquals(expected, actual);
    }

    @Test
    public void shouldWinPlayer2() {
        Game game = new Game();
        Player player1 = new Player(1, "fighter", 10);
        Player player2 = new Player(2, "warrior", 2);
        Player player3 = new Player(3, "topgun10", 4);
        Player player4 = new Player(4, "alex1", 15);
        Player player5 = new Player(5, "vasya", 12);
        Player player6 = new Player(6, "hero1993", 7);

        game.register(player1);
        game.register(player2);
        game.register(player3);
        game.register(player4);
        game.register(player5);
        game.register(player6);

        int expected = 2;
        int actual = game.round("topgun10", "hero1993");

        assertEquals(expected, actual);
    }

    @Test
    public void shouldEndInDraw() {
        Game game = new Game();
        Player player1 = new Player(1, "fighter", 10);
        Player player2 = new Player(2, "warrior", 2);
        Player player3 = new Player(3, "topgun10", 4);
        Player player4 = new Player(4, "alex1", 15);
        Player player5 = new Player(5, "vasya", 10);
        Player player6 = new Player(6, "hero1993", 7);

        game.register(player1);
        game.register(player2);
        game.register(player3);
        game.register(player4);
        game.register(player5);
        game.register(player6);

        int expected = 0;
        int actual = game.round("vasya", "fighter");

        assertEquals(expected, actual);
    }

    @Test
    public void shouldThrowExceptionBadFirstPlayer() {
        Game game = new Game();
        Player player1 = new Player(1, "fighter", 10);
        Player player2 = new Player(2, "warrior", 2);
        Player player3 = new Player(3, "topgun10", 4);
        Player player4 = new Player(4, "alex1", 15);
        Player player5 = new Player(5, "vasya", 10);
        Player player6 = new Player(6, "hero1993", 7);

        game.register(player1);
        game.register(player2);
        game.register(player3);
        game.register(player4);
        game.register(player5);
        game.register(player6);

        assertThrows(NotRegisteredException.class, () -> game.round("vasyaaa", "fighter"));
    }

    @Test
    public void shouldThrowExceptionBadSecondPlayer() {
        Game game = new Game();
        Player player1 = new Player(1, "fighter", 10);
        Player player2 = new Player(2, "warrior", 2);
        Player player3 = new Player(3, "topgun10", 4);
        Player player4 = new Player(4, "alex1", 15);
        Player player5 = new Player(5, "vasya", 10);
        Player player6 = new Player(6, "hero1993", 7);

        game.register(player1);
        game.register(player2);
        game.register(player3);
        game.register(player4);
        game.register(player5);
        game.register(player6);

        assertThrows(NotRegisteredException.class, () -> game.round("topgun10", "topfighter"));
    }
}