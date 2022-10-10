using System;
using System.Collections.Generic;

namespace Lab1.Classes
{
    public class GameAccount
    {
        public string UserName;

        public int CurrentRating;

        public int GamesCount = 0;

        private List<Game> historyGames = new List<Game>();

        public GameAccount(string UserName, int CurrentRating)
        {
            this.UserName = UserName;
            if (CurrentRating < 0)
            {
                throw new ArgumentOutOfRangeException("The current rating cannot be less than zero");
            }
            else
            {
                this.CurrentRating = CurrentRating;
            }
            
        }

        public void Game(GameAccount opponentName, int raiting)
        {
            Random rnd = new Random();
            Boolean isWin = rnd.Next(2) == 1;
            if (isWin)
            {
                WinGame(opponentName, raiting);
            }
            else
            {
                LoseGame(opponentName, raiting);
            }
            GamesCount++;
            opponentName.GamesCount++;
            historyGames.Add(new Game(this, opponentName, raiting, isWin));
            opponentName.historyGames.Add(new Game(opponentName, this, raiting, !isWin));
        }

        private void WinGame(GameAccount opponentName, int rating)
        {
            if (rating > 0)
            {
                CurrentRating += rating;
                if (opponentName.CurrentRating - rating < 1)
                {
                    opponentName.CurrentRating = 1;
                }
                else
                {
                    opponentName.CurrentRating -= rating;
                }
                
            }
            else
            {
                throw new ArgumentOutOfRangeException("The game rating cannot be less than zero");
            }
            
        }
        private void LoseGame(GameAccount opponentName, int rating)
        {
            if (rating > 0)
            {
                opponentName.CurrentRating += rating;
               
                if (CurrentRating - rating < 1)
                {
                    CurrentRating = 1;
                    
                }
                else
                {
                    CurrentRating -= rating;
                }
                
            }
            else
            {
                throw new ArgumentOutOfRangeException("The game rating cannot be less than zero");
            }
            
        }

        public void GetStatus()
        {
            Console.WriteLine("History of games player " + UserName);
            string status;
            foreach (var game in historyGames)
            {
                if (game.isWin)
                {
                    status = "win";
                }
                else
                {
                    status = "lose";
                }
                Console.WriteLine(" VS " + game.oponent.UserName + " " + status + 
                                  " raiting: " + game.raiting + " index of game: " + game.gameid );
            }
        }

        public void ShowInfo()
        {
            Console.WriteLine("Player:" + UserName + "\nNumber of games played: " + GamesCount + "\nCurrent rating: " + CurrentRating);
        }
    }
}