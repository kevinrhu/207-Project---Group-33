package main.java.use_case.player_comparison_remove;

public class PlayerComparisonRemoveInputData {

    final private int playerId;

    public PlayerComparisonRemoveInputData(int playerId){
        this.playerId = playerId;
    }

    public int getPlayerId(){
        return this.playerId;
    }

}