using System;
using Lab2.Accounts;

namespace Lab2.Games
{
    public class GameBuilder
    {
        public Game StartStandartGame(GameAccount gamer, GameAccount opponent, int rating, Boolean isWin)
        {
            return new StandartGame(gamer, opponent, rating, isWin);
        }

        public Game StartTraningGame(GameAccount gamer, GameAccount opponent, int rating, Boolean isWin)
        {
            return new TraningGame(gamer, opponent, rating, isWin);
        }

        public Game StartSingleRatingGame(GameAccount gamer, GameAccount opponent, int rating, Boolean isWin)
        {
            return new SingleRatingGame(gamer, opponent, rating, isWin);
        }
    }
}