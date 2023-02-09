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
            var defendor = new Character(22, 10, "dwarf", 0);

            var attackCalculator = new AttackCalculator();
            var result = attackCalculator.CalculateDamage(attacker, defendor);

            Assert.Equal(0, result);
        }

        [Fact]
        public void AttackerIsStrongerEnoughToDoDamangeButDiceIsOne_MeansNoDamage()
        {
            var attacker = new Character(0, 10, "elf", 80);
            var defendor = new Character(1, 10, "dwarf", 0);

            var attackCalculator = new AttackCalculator();
            var result = attackCalculator.CalculateDamage(attacker, defendor, 1);

            Assert.Equal(0, result);
        }

        [Fact]
        public void AttackerIsStrongerEnoughToDoDamangeAndDiceIsTwenty_MeansDoubleDamage()
        {
            var attackerWeaponDamange = 10;
            var attacker = new Character(0, attackerWeaponDamange, "elf", 80);
            var defendor = new Character(1, 10, "dwarf", 0);

            var attackCalculator = new AttackCalculator();
            var result = attackCalculator.CalculateDamage(attacker, defendor, 20);

            Assert.Equal(attackerWeaponDamange * 2, result);
        }

        [Fact]
        public void AttackerIsStrongerEnoughToDoDamangeAndDiceIsNotOneAndTwenty_MeansDefaultDamange()
        {
            var attackerWeaponDamange = 10;
            var attacker = new Character(0, attackerWeaponDamange, "elf", 80);
            var defendor = new Character(1, 10, "dwarf", 0);

            var attackCalculator = new AttackCalculator();
            var result = attackCalculator.CalculateDamage(attacker, defendor, 2);

            Assert.Equal(attackerWeaponDamange, result);
        }
    }
}
