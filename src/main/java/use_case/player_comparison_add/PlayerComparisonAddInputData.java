package main.java.use_case.player_comparison_add;

import main.java.entity.Player;

public class PlayerComparisonAddInputData {

    final private Player player;

    public PlayerComparisonAddInputData(Player player){
        this.player = player;
    }

    public Player getPlayer(){
        return this.player;
    }
}