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
            var isAttackerAbleToDamage = atk.Force + dice > def.armorClass;
            return isAttackerAbleToDamage ? DamageDealt(atk, dice) : 0;
        }


        private int DamageDealt(Character atk, int dice)
        {
            switch (dice)
            {
                case 1:
                    return 0;
                case 20:
                    return atk.damageDealt * 2;
                default:
                    return atk.damageDealt;
            }
        }
    }
}
