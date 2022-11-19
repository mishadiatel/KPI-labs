using System;
using Lab2.Accounts;

namespace Lab2
{
    internal class Program
    {
        public static void Main(string[] args)
        {
            try
            {
                var account1 = new PremiumAccount("PremiumUser");
                var account2 = new BaseAccount("BaseUser");
                var account3 = new HackedAccount("HackedUser", 32);
                account1.Play(account2, 40, "Standart");
                account2.Play(account3, 20, "Traning");
                account3.Play(account1, 5, "SingleRating");
                account1.GetStats();
                account2.GetStats();
                account3.GetStats();
                account1.ShowInfo();
                account2.ShowInfo();
                account3.ShowInfo();
            }
            catch (Exception e)
            {
                Console.WriteLine(e);
                throw;
            }
            
            
        }
    }
}