using System;

namespace Game
{
    public class AttackCalculator
    {
        Random random = new Random();

        public int CalculateDamage(Character atk, Character def)
        {
            var dice = random.Next(1, 20);
            return CalculateDamage(atk, def, dice);
        }

        public int CalculateDamage(Character atk, Character def, int dice)
        {
            if (atk.Force + dice > def.armorClass)
            {
                if (dice == 1)
                {
                    return 0;
                }

                if (dice == 20)
                {
                    return atk.damageDealt * 2;
                }

                return atk.damageDealt;
            }
            else
            {
                return 0;
            }
        }
    }
}
