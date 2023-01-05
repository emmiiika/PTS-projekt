package sk.uniba.fmph.dcs;

import java.util.*;

public class GameAdaptor implements GamePlayerInterface {

    int lastPlayerIdx;
    private Map<String, Integer> players;
    private Game game;
    private List<Player> playerList;
    private DrawingPileType drawingPileType;
    private DrawingAndTrashPile drawingAndTrashPile;

    public GameAdaptor(DrawingPileType drawingPileType) {
        Scanner scanner = new Scanner(System.in);

        this.players = new HashMap<>();
        this.lastPlayerIdx = 0;
        this.drawingPileType = drawingPileType;
        this.drawingAndTrashPile = new DrawingAndTrashPile(drawingPileType, new Random());
        this.game = new Game(drawingAndTrashPile);
        System.out.println("New has game started.");

        System.out.println("How many players?");
        int numberOfPlayers = Integer.parseInt(scanner.nextLine());
        this.playerList = new ArrayList<>(numberOfPlayers);

        int i = 0;
        while (i != numberOfPlayers) {
            System.out.println("Insert players name:");
            String username = scanner.nextLine();
            if (players.containsKey(username)) {
                System.out.println("Username already taken, choose another one.");
            } else {
                players.put(username, lastPlayerIdx);
                Player player = new Player(lastPlayerIdx, game);
                playerList.add(player);
                lastPlayerIdx++;
                i++;
            }
            game.setPlayerList(playerList);
        }
    }

    @Override
    public String play(String player, String cards) {
//        String[] cardsSplit = cards.split(" ");
////        System.out.println(Arrays.toString(cardsSplit));
//        List<String> commands = new ArrayList<>();
//        commands.addAll(Arrays.asList(cardsSplit));
//
//        String cardPlayed = commands.get(0);

        int playerIdx = players.get(player);

//        List<Position> positions = new ArrayList<>();
//        List<HandPosition> handPos = new ArrayList<>();
//        for (int i = 1; i < cardPlayed.length(); i++) {
//            int cardIdx = Character.getNumericValue(cardPlayed.charAt(i));
//            HandPosition handPosition = new HandPosition(cardIdx, playerIdx);
//            handPos.add(handPosition);
//
//            positions.add(handPosition);
//        }

//        playerList.get(playerIdx).play(handPos);
        List<Position> positions = parser(playerIdx, cards);

        Optional<GameState> gameStateOptional = game.play(playerIdx, positions);
        StringBuilder stringBuilder = new StringBuilder();

        assert gameStateOptional.isPresent();
        GameState gameState = gameStateOptional.get();
        gameState.onTurn = playerIdx;
        stringBuilder.append("Number of players: ").append(gameState.numberOfPlayers).append("\n");
        stringBuilder.append("On turn: ").append(players.get(gameState.onTurn)).append("\n");

        stringBuilder.append("Sleeping queens: ");
        for (SleepingQueenPosition sleepingQueenPosition : gameState.sleepingQueens) {
            stringBuilder.append(sleepingQueenPosition.getCardIndex()).append(", ");
        }
        stringBuilder.append("\n");


//        stringBuilder.append("Your cards: ");
//        List<Card> playersCards = playerList.get(playerIdx).getPlayersCards();
////        stringBuilder.append(playersCards).append("\n");
////        Set<HandPosition> handPositions = gameState.cards.keySet();
//        for (int i = 0; i < playersCards.size(); i++) {
//            Card card = playersCards.get(i);
//            stringBuilder.append(i).append(": ");
//            stringBuilder.append(card.type).append("(");
//            stringBuilder.append(card.value).append(")");
//            stringBuilder.append(", ");
//        }
//        stringBuilder.append("\n");

        stringBuilder.append("Awoken queens: ");//.append(gameState.awokenQueens).append("\n");
        Set<AwokenQueenPosition> awokenQueenPositions = gameState.awokenQueens.keySet();
        for (AwokenQueenPosition awokenQueenPosition : awokenQueenPositions) {
            stringBuilder.append(awokenQueenPosition.getCardIndex()).append(", ");
        }
        stringBuilder.append("\n");
        stringBuilder.append("Cards discarded last turn: ").append(gameState.cardsDiscardedLastTurn).append("\n");

        return stringBuilder.toString();
    }

    public Optional<Integer> isFinished() {
        GameFinishedPlayers gameFinishedPlayers = new GameFinishedPlayers(game);
        GameFinishedNoQueensLeft gameFinishedNoQueensLeft = new GameFinishedNoQueensLeft(game);

        Optional<Integer> playersStrategy = game.isFinished(gameFinishedPlayers);
        Optional<Integer> queenStrategy = game.isFinished(gameFinishedNoQueensLeft);

        if (playersStrategy.isPresent()) {
            return playersStrategy;
        } else if (queenStrategy.isPresent()) {
            return queenStrategy;
        } else return Optional.empty();
    }

    public List<Card> getPlayersCards(){
        return game.getPlayersList().get(game.playerOnTurn()).getPlayersCards();
    }

    private List<Position> parser(int playerIdx, String command){
        List<Position> positions = new ArrayList<>();
        command = command.toLowerCase().strip();
        String[] commands = command.split(" ");
        if(commands.length > 0){
            if(commands[0].charAt(0) != 'h'){
                throw new IllegalArgumentException();
            }
            for(int i=1; i<commands[0].length(); i++){
                positions.add(new HandPosition(Integer.parseInt(Character.toString(commands[0].charAt(i))), playerIdx));
            }

            if(commands.length == 2){
                if(commands[1].charAt(0) == 'a'){
                    int targetPlayerIdx = Integer.parseInt(Character.toString(commands[1].charAt(1)));
                    int targetIdx = Integer.parseInt(Character.toString(commands[1].charAt(2)));
                    Position targetAwokenQueen = new AwokenQueenPosition(targetIdx, targetPlayerIdx);
                    positions.add(targetAwokenQueen);
                }
                else if(commands[1].charAt(0) == 's'){
                    Position targetSleepingQueen = new SleepingQueenPosition(Integer.parseInt(Character.toString(commands[1].charAt(1))));
                    positions.add(targetSleepingQueen);
                }
            }
        }

        return positions;
    }
}

