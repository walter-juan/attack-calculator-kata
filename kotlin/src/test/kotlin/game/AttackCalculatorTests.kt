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
})