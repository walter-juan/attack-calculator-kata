package game

import kotlin.random.Random
import kotlin.random.nextInt

class AttackCalculator(private val diceRoller: DiceRoller = DefaultDiceRoller()) {
    fun calculateDamage(atk: Character, def: Character): Int {
        val defaultAttack = atk.force
        val dice = diceRoller.roll()
        val currentAttack = defaultAttack + dice
        var damage = atk.damageDealt

        if (atk.force + dice > def.armorClass) {
            if (dice == 1) {
                damage = 0
            }
            if (dice == 20) {
                damage = atk.damageDealt * 2
            }
            return damage
        } else {
            return 0
        }
    }
}

class DefaultDiceRoller: DiceRoller {
    private val random = Random
    override fun roll(): Int {
        return random.nextInt(1..20)
    }
}

interface DiceRoller {
    fun roll(): Int
}