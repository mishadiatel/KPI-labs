using System;
using Lab2.Games;

namespace Lab2.Accounts
{
    public class BaseAccount: GameAccount
    {
        /**
         * BaseAccount
         * знімається і додається така кількість балів яка задана при виклиці метода Play()
         */
        public  BaseAccount(string userName)
        {
            UserName = userName;
            CurrentRating = 0;
            AccountStatus = "Base";
        }

        private protected override void WinGame(Game game)
        {
            CurrentRating += game.Rating;
            if (game.Opponent.CurrentRating - game.Rating < 1)
            {
                game.Opponent.CurrentRating = 1;
            }
            else
            {
                game.Opponent.CurrentRating -= game.RatingForOpponent;
            }
            
        }

        private protected override void LoseGame(Game game)
        {
            game.Opponent.CurrentRating += game.RatingForOpponent;
            if (CurrentRating - game.Rating < 1)
            {
                CurrentRating = 1;
            }
            else
            {
                CurrentRating -= game.Rating;
            }
        }
    }
}