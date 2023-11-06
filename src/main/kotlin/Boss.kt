open class Boss(
    val name: String,
    var hp: Int,
    val magician: Magician,
    val thief: Thief,
    val warrior: Warrior
) {
    protected var isShieldActive = false
    private var shieldRounds = 0
    open var isAlive = true

    fun takeDamage(damage: Int) {
        if (isShieldActive) {
            println("$name ist durch den Schutzschild geschützt und erleidet keinen Schaden.")
        } else {
            hp -= damage
            if (hp <= 0) {
                isAlive = false
            }
            println("$name erleidet $damage Schaden.")
        }
        if (!isAlive) {
            println("$name ist gestorben!")
        }
    }

    open fun shield() {
        if (!isShieldActive) {
            println("$name beschwört einen mächtigen Schutzschild.")
            isShieldActive = true
            shieldRounds = 1
        }
    }

    fun endShield() {
        if (isShieldActive) {
            println("$name beendet den Schutzschild.")
            isShieldActive = false
        } else {
            println("$name hat keinen Schutzschild aktiv.")
        }
    }

    private fun nextRound() {
        if (isShieldActive) {
            shieldRounds++
            if (shieldRounds > 1) {
                endShield()
            }
        }
    }
}