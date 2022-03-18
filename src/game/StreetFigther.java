/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package game;

import apgc.gamedev2d.PlaySound;

/**
 *
 * @author Denizia Fernanda
 */
public class StreetFigther {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        MyGame game=new MyGame("StreetFight",600,500,false,false);
        game.start();
        PlaySound.playMusic(game.getSound(), 0);
    }
    
}
