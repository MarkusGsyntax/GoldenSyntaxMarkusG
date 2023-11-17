open class Warrior(name: String, hp: Int, maxHp: Int) : Hero(name, hp, maxHp) {

    private fun swordAttack(damage: Int = 25) {
        if (isMinionSummoned && minion.isAlive) {
            println("$name greift ${minion.name} mit seinem Schwert an.")
            minion.takeDamage(damage)
        } else {
            println("$name greift ${dragon.name} mit seinem Schwert an.")
            dragon.takeDamage(damage)
        }
    }

    private fun SwordSwinger(damage: Int = 40) {
        if (isMinionSummoned && minion.isAlive) {
            println("$name lässt sein Schwert in einer Pirouette schwingen und greift damit ${minion.name} an.")
            minion.takeDamage(damage)
            println("${minion.name} hat nun noch ${minion.hp} Lebenspunkte übrig!")
        } else {
            println("$name lässt sein Schwert in einer Pirouette schwingen und greift damit ${dragon.name} an.")
            dragon.takeDamage(damage)
        }

    }

    private fun BattleAxe(damage: Int = 60) {
        if (isMinionSummoned && minion.isAlive) {
            println("$name greift mit seiner Streitaxt ${minion.name} an!")
            minion.takeDamage(damage)
        } else {
            println("$name greift mit seiner Streitaxt ${dragon.name} an!")
            dragon.takeDamage(damage)
        }
    }

    private fun bothHand(damage: Int = 80) {
        if (isMinionSummoned && minion.isAlive) {
            println("$name greift beidhändig mit Schwert und Streitaxt ${minion.name} an.")
            minion.takeDamage(damage)
        } else {
            println("$name greift beidhändig mit Schwert und Streitaxt ${dragon.name} an.")
            dragon.takeDamage(damage)
        }
    }

    fun warriorActions() {
        println("1. Schwertattacke")
        println("2. Schwertschwinger")
        println("3. Streitaxt")
        println("4. beidhändiger Angriff")
        try {
            when (readln().toInt()) {
                1 -> warrior.swordAttack()
                2 -> warrior.SwordSwinger()
                3 -> warrior.BattleAxe()
                4 -> warrior.bothHand()
                else -> {
                    println("Ungültige Auswahl. Bitte 1-4 wählen.")
                    warriorActions()
                }
            }
        } catch (e: NumberFormatException) {
            println("Bitte eine Zahl zwischen 1-4 wählen.")
            warriorActions()
        }
    }
}
