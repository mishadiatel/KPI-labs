using System;
using System.Collections.Generic;

namespace Lab1.Classes
{
    public class GameAccount
    {
        public string UserName;

        public int CurrentRating;

        public int GamesCount = 0;

        private static int gameid = 1234567890;

        private List<Game> historyGames = new List<Game>();


        public GameAccount(string UserName, int CurrentRating)
        {
            this.UserName = UserName;
            this.CurrentRating = CurrentRating;
        }

        public void Game(GameAccount opponentName, int raiting)
        {
            gameid++;
            GamesCount++;
            opponentName.GamesCount++;
            Random rnd = new Random();
            Boolean gameStatus = rnd.Next(2) == 1;
           
            if (gameStatus)
            {
                WinGame(opponentName, raiting);
            }
            else
            {
                LoseGame(opponentName, raiting);
                
            }
            historyGames.Add(new Game(this, opponentName, raiting, gameStatus));
            opponentName.historyGames.Add(new Game(opponentName, this, raiting, !gameStatus));
        }

        public int GetGameId()
        {
            return gameid;
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
                if (game.gameStatus)
                {
                    status = "win";
                }
                else
                {
                    status = "lose";
                }
                Console.WriteLine(" VS " + game.oponent.UserName + " " + status + 
                                  " raiting: " + game.raiting + " index of game: " + game.GetIndex() );
            }
        }

        public void ShowInfo()
        {
            Console.WriteLine("Player:" + UserName + "\nNumber of games played: " + GamesCount + "\nCurrent rating: " + CurrentRating);
        }
        
        
        
        
    }
}