open class Boss(val name: String, var hp: Int) {
    protected var isShieldActive = false
    open var isAlive = true
    open var shieldRound = 0

    open fun shield() {
        if (!isShieldActive && shieldRound == 0) {
            println("$name beschwört einen mächtigen Schutzschild.")
            isShieldActive = true
            shieldRound = 1
        }
    }
    open fun takeDamage(damage: Int) {
        if (isShieldActive && shieldRound > 0) {
            shieldRound = 0
            println("$name ist durch den Schutzschild geschützt und erleidet keinen Schaden.")
        } else {
            hp -= damage
            Thread.sleep(1500)
            println("${this.name} hat noch ${this.hp} Lebenspunkte!")
            if (this.hp <= 0) {
                println("${this.name} ist gestorben!")
                isAlive = false
                bosses.remove(this)
            }
        }
    }
}
