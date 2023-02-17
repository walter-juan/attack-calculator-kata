package game

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class AttackCalculatorTests : StringSpec({
    "defender is stronger enough to defend from damage" {
        val attacker = Character(armorClass = 0, weaponDamage = 10, race = "elf", force = 1)
        val defender = Character(armorClass = 22, weaponDamage = 10, race = "dwarf", force = 0)

        val attackCalculator = AttackCalculator()
        val damage = attackCalculator.calculateDamage(atk = attacker, def = defender)
        damage shouldBe 0
    }

    "attacker is stronger enough to do damage but dice is one means no damage" {
        val attacker = Character(armorClass = 0, weaponDamage = 10, race = "elf", force = 1)
        val defender = Character(armorClass = 22, weaponDamage = 10, race = "dwarf", force = 0)

        val diceRoller = object : DiceRoller {
            override fun roll(): Int = 1
        }
        var attackCalculator = AttackCalculator(diceRoller = diceRoller)
        var result = attackCalculator.calculateDamage(attacker, defender)

        result shouldBe 0
    }

    "attacker is stronger enough to do damage and dice is twenty means double damage" {
        var attackerWeaponDamage = 10
        var attacker = Character(0, attackerWeaponDamage, "elf", 80)
        var defender = Character(1, 10, "dwarf", 0)

        val diceRoller = object : DiceRoller {
            override fun roll(): Int = 20
        }
        var attackCalculator = AttackCalculator(diceRoller = diceRoller)
        var result = attackCalculator.calculateDamage(attacker, defender)

        result shouldBe (attackerWeaponDamage * 2)
    }

    "attacker is stronger enough to do damage and dice is not one and twenty means default damage" {
        var attackerWeaponDamage = 10
        var attacker = Character(0, attackerWeaponDamage, "elf", 80)
        var defender = Character(1, 10, "dwarf", 0)

        val diceRoller = object : DiceRoller {
            override fun roll(): Int = 2
        }
        var attackCalculator = AttackCalculator(diceRoller = diceRoller)
        var result = attackCalculator.calculateDamage(attacker, defender)

        result shouldBe (attackerWeaponDamage)
    }
})