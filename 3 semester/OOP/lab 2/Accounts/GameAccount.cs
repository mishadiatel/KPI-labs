using System;
using System.Collections.Generic;
using System.ComponentModel;
using Lab2.Games;

namespace Lab2.Accounts
{
    public abstract class GameAccount
    {
        public string UserName { get; set; }

        public int CurrentRating;

        public String AccountStatus;
        
        private  List<Game> _historyGames = new List<Game>();
        
        public void Play(GameAccount opponent, int rating, string playFormat)
        {
            var rnd = new Random();
            var isWin = rnd.Next(2) == 1;
            var gameBuilder = new GameBuilder();
            Game game ;
            Game opponentGame;
            switch (playFormat)
            {
                case "Standart":
                    game = gameBuilder.StartStandartGame(this, opponent, rating, isWin);
                    opponentGame = gameBuilder.StartStandartGame(opponent, this, rating, !isWin);
                    break;
                case "Traning":
                    game = gameBuilder.StartTraningGame(this, opponent, rating, isWin);
                    opponentGame = gameBuilder.StartTraningGame(opponent, this, rating, !isWin);
                    break;
                case "SingleRating":
                    game = gameBuilder.StartSingleRatingGame(this, opponent, rating, isWin);
                    opponentGame = gameBuilder.StartSingleRatingGame(opponent, this, rating, !isWin);
                    break;
                default:
                    throw new InvalidEnumArgumentException("Wrong playFormat");
            }
            
            if (isWin)
            {
                WinGame(game);
            }
            else
            {
                LoseGame(game);
            }

            _historyGames.Add(game);
            opponent._historyGames.Add(opponentGame);
        }


        private protected abstract void WinGame(Game game);

        private protected abstract void LoseGame(Game game);

        public void GetStats()
        {
            Console.WriteLine("History of games player " + UserName);
            foreach (var game in _historyGames)
            {
                string status;
                if (game.IsWin)
                {
                    status = "win";
                }
                else
                {
                    status = "lose";
                }

                Console.WriteLine(" VS " + game.Opponent.UserName + " " + status +
                                  " rating: " + game.Rating + " index of game: " + game.Gameid);
            }
        }
        
        public void ShowInfo()
        {
            Console.WriteLine("Player:" + UserName + "\nNumber of games played: " + _historyGames.Count + "\nCurrent rating: " +
                              CurrentRating + "\nAccount status: " + AccountStatus);
        }
    }
}