﻿using System;
using Lab2.Accounts;

namespace Lab2.Games
{
    public class TraningGame: Game
    {
        public TraningGame(GameAccount gamer, GameAccount opponent, int rating, Boolean isWin) 
            : base(gamer, opponent, rating, isWin)
        {
            Rating = 0;
            RatingForOpponent = 0;
        }
    }
}