using System;


namespace Lab1.Classes
{
    public class Game
    {
        public GameAccount gamer;
        public GameAccount oponent;
        public int raiting;
        public Boolean isWin;
        public static int id = 1234567890;
        public int gameid;

        public Game(GameAccount gamer, GameAccount oponent, int raiting, Boolean isWin)
        {
            this.gamer = gamer;
            this.oponent = oponent;
            this.raiting = raiting;
            this.isWin = isWin;
            id++;
            gameid = id;
        }
        
    }
}