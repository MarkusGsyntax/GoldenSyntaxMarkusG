open class Warrior(name: String, hp: Int, maxHp: Int) : Hero(name, hp, maxHp) {

    private fun swordAttack(damage: Int = 25) {
        if (isMinionSummoned && MINION.isAlive) {
            println("$name greift ${MINION.name} mit seinem Schwert an.")
            MINION.takeDamage(damage)
        } else {
            println("$name greift ${DRAGON.name} mit seinem Schwert an.")
            DRAGON.takeDamage(damage)
        }
    }

    private fun SwordSwinger(damage: Int = 40) {
        if (isMinionSummoned && MINION.isAlive) {
            println("$name lässt sein Schwert in einer Pirouette schwingen und greift damit ${MINION.name} an.")
            MINION.takeDamage(damage)
            println("${MINION.name} hat nun noch ${MINION.hp} Lebenspunkte übrig!")
        } else {
            println("$name lässt sein Schwert in einer Pirouette schwingen und greift damit ${DRAGON.name} an.")
            DRAGON.takeDamage(damage)
        }
    }

    private fun BattleAxe(damage: Int = 60) {
        if (isMinionSummoned && MINION.isAlive) {
            println("$name greift mit seiner Streitaxt ${MINION.name} an!")
            MINION.takeDamage(damage)
        } else {
            println("$name greift mit seiner Streitaxt ${DRAGON.name} an!")
            DRAGON.takeDamage(damage)
        }
    }

    private fun bothHand(damage: Int = 80) {
        if (isMinionSummoned && MINION.isAlive) {
            println("$name greift beidhändig mit Schwert und Streitaxt ${MINION.name} an.")
            MINION.takeDamage(damage)
        } else {
            println("$name greift beidhändig mit Schwert und Streitaxt ${DRAGON.name} an.")
            DRAGON.takeDamage(damage)
        }
    }

    fun warriorActions() {
        println("1. Schwertattacke")
        println("2. Schwertschwinger")
        println("3. Streitaxt")
        println("4. beidhändiger Angriff")
        try {
            when (readln().toInt()) {
                1 -> WARRIOR.swordAttack()
                2 -> WARRIOR.SwordSwinger()
                3 -> WARRIOR.BattleAxe()
                4 -> WARRIOR.bothHand()
                else -> {
                    println("Ungültige Auswahl. Bitte 1-4 wählen!")
                    warriorActions()
                }
            }
        } catch (e: NumberFormatException) {
            println("Falsche Auswahl, bitte gültige ZAHL von 1-4 auswählen!")
            warriorActions()
        }
    }
}
