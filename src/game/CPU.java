/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Fall 2019
 * Instructor: Prof. Brian King
 *
 * Name: Michael Heller
 * Section: 11 am
 * Date: 11/26/19
 * Time: 9:01 PM
 *
 * Project: King's Disciples
 * Package: main
 * Class: CPU
 *
 * Description:
 * CPU class to lay out the rules of poker
 *
 * ****************************************
 */

package game;

import game.*;

import java.util.Random;

/**
 * CPU class play against any user player
 * @author Michael Heller
 * @version 0.1
 */
public class CPU extends Player {

    /** integer to determine the level of risk the CPU player takes **/
    private int riskLevel;

    /** universal random object **/
    Random rand = new Random();

    /**
     * Constructor for the Player class
     *
     * @param playerChips
     * @param roundHand
     * @param pot
     */
    public CPU(PlayerChips playerChips, Hand roundHand, GamePot pot) {
        super(playerChips, roundHand, pot);
        this.riskLevel = rand.nextInt((5 - 1) + 1) + 1;
    }

    /**
     * manual setter function for the CPU player's risk level
     * @param riskLevel
     */
    public void setRiskLevel (int riskLevel) {
        this.riskLevel = riskLevel;
    }

    /**
     * manual getter function for the riskLevel of the CPU
     * @return riskLevel
     */
    public int getRiskLevel() {
        return riskLevel;
    }

    /**
     * manually command CPU to make a raise
     * @param raiseAmount
     */
    @Override
    public void makeRaise(int raiseAmount) {
        super.makeRaise(raiseAmount);
    }

    /**
     * makes a raise based on the ranges from the
     */
    public void cpuMakeRaise() {
        int randVal = 0;
        if(riskLevel == 1) {
            randVal = rand.nextInt((10 - 1) + 1) + 1;
            getPot().addPlayerBets(randVal);
            getPlayerChips().removeChips(randVal);
        }
        if(riskLevel == 2) {
            randVal = rand.nextInt((15 - 8) + 1) + 8;
            getPot().addPlayerBets(randVal);
            getPlayerChips().removeChips(randVal);
        }
        if(riskLevel == 3) {
            randVal = rand.nextInt((25 - 10) + 1) + 10;
            getPot().addPlayerBets(randVal);
            getPlayerChips().removeChips(randVal);
        }
        if(riskLevel == 4) {
            randVal = rand.nextInt((50 - 25) + 1) + 25;
            getPot().addPlayerBets(randVal);
            getPlayerChips().removeChips(randVal);
        }
        if(riskLevel == 5) {
            randVal = rand.nextInt((100 - 50) + 1) + 50;
            getPot().addPlayerBets(randVal);
            getPlayerChips().removeChips(randVal);
        }
    }

    /**
     * takes in factor of risk level and either makes the call or not
     * @param callAmount
     */
    public void cpuMakeCall(int callAmount) {
        //remove value from player
        int randomLevel = rand.nextInt((100 - 1) + 1) + 1;
        if(riskLevel == 1) {
            if(randomLevel <= 15) {
                getPot().addPlayerBets(callAmount);
                getPlayerChips().removeChips(callAmount);
            }
        }
        if(riskLevel == 2) {
            if(randomLevel <= 25) {
                getPot().addPlayerBets(callAmount);
                getPlayerChips().removeChips(callAmount);
            }
        }
        if(riskLevel == 3) {
            if(randomLevel <= 50) {
                getPot().addPlayerBets(callAmount);
                getPlayerChips().removeChips(callAmount);
            }
        }
        if(riskLevel == 4) {
            if(randomLevel <= 75) {
                getPot().addPlayerBets(callAmount);
                getPlayerChips().removeChips(callAmount);
            }
        }
        if(riskLevel == 5) {
            if(randomLevel <= 90) {
                getPot().addPlayerBets(callAmount);
                getPlayerChips().removeChips(callAmount);
            }
        }
    }

    /**
     * main method for the CPU class
     * @param args
     */
    public static void main(String[] args) { }

}
