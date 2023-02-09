using System;
using Xunit;

using Game;

namespace Game.tests
{
    public class AttackCalculatorTests 
    {
       [Fact]
        public void DefenderIsStrongerEnoughToDefendFromDamange()
        {
            var attacker = new Character(0, 10, "elf", 1);
            var defendor = new Character(22, 10, "elf", 0);

            var attackCalculator = new AttackCalculator();
            var result = attackCalculator.CalculateDamage(attacker, defendor);

            Assert.Equal(0, result);
        }
    }
}
