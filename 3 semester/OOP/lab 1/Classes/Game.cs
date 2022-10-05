using System;
using System.Collections;


namespace Lab1.Classes
{
    public class Game
    {
        public GameAccount gamer;
        public GameAccount oponent;
        public int raiting;
        public Boolean gameStatus;
        private int gameid;

        public Game(GameAccount gamer, GameAccount oponent, int raiting, Boolean gameStatus)
        {
            this.gamer = gamer;
            this.oponent = oponent;
            this.raiting = raiting;
            this.gameStatus = gameStatus;
            gameid = gamer.GetGameId();
        }

        public int GetIndex()
        {
            return gameid;
        }
    }
}