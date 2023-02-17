package game

import kotlin.random.Random
import kotlin.random.nextInt

open class AttackCalculator {
    private val random = Random

    fun calculateDamage(atk: Character, def: Character): Int {
        val defaultAttack = atk.force
        val dice = rollDice()
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

    open fun rollDice(): Int {
        return random.nextInt(1..20)
    }
}