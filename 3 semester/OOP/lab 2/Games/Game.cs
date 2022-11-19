using System;
using System.ComponentModel;
using Lab2.Accounts;

namespace Lab2.Games
{
    public abstract class Game
    {
        public  GameAccount Gamer;
        public  GameAccount Opponent;
        public  int Rating;
        public  int RatingForOpponent;
        public  bool IsWin;
        private  static int _id = 1234567890;
        public  int Gameid;

        public Game(GameAccount gamer, GameAccount opponent, int rating, Boolean isWin)
        {
            Gamer = gamer;
            Opponent = opponent;
            IsWin = isWin;
            _id++;
            Gameid = _id;
            if (rating < 0)
            {
                var error = "The game rating cannot be less than zero";
                throw new ArgumentOutOfRangeException(error);
            }
        }
        
            
        
    }
}