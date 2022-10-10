using System;
using Lab1.Classes;

namespace Lab1
{
    internal class Program
    {
        public static void Main(string[] args)
        {
            
            try
            {
                GameAccount account1 = new GameAccount("Lolik", 25);
                GameAccount account2 = new GameAccount("Bolik", 20);
                account1.Game(account2, 9);
                account2.Game(account1, 15);
                account1.Game(account2, 10);
                account2.Game(account1, 6);
                account1.ShowInfo();
                account1.GetStatus();
                account2.ShowInfo();
                account2.GetStatus();
            }
            catch (Exception e)
            {
                Console.WriteLine(e);
                throw;
            }
            
        }
    }
}