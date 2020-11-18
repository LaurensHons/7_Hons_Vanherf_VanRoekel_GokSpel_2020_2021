package model.states;

import controller.GamblerController;
import model.gokstrategy.GokStrategy;

public class SecondThrowState implements RequestState{

    GamblerController gamblerController;

    public SecondThrowState(GamblerController gamblerController){
        this.gamblerController = gamblerController;
    }

    @Override
    public boolean logIn(String login) {
        return false;
    }

    @Override
    public void selectStrategy(GokStrategy gokStrategy) {
    }

    @Override
    public boolean startGame(int bet) {
        if (gamblerController.raiseBet(bet)) {
            gamblerController.setState(new PlayState(gamblerController));
            return true;
        }
        else return false;
    }

    @Override
    public int throwDice() {
        return 0;
    }
}