using System;
using Lab2.Games;

namespace Lab2.Accounts
{
    /**
     * HackedAccount
     * Початковий рейтинг задається при створенні об'єкта
     * При програші рейтинг не знімається
     * якщо переміг то нараховується вдвічі більший рейтинг
     */
    public class HackedAccount: GameAccount
    {
        public  HackedAccount(String userName, int rating)
        {
            UserName = userName;
            AccountStatus = "Hacked";
            if (rating < 0)
            {
                String error = "Rating cannot be less than zero";
                throw new ArgumentOutOfRangeException(error);
            }

            CurrentRating = rating;
        }

        private protected override void WinGame(Game game)
        {
            CurrentRating += game.Rating*2;
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
            
        }
    }
}