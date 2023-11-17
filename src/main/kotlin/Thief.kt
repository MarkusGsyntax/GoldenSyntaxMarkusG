class Thief(name: String, hp: Int, maxHp: Int) : Hero(name, hp, maxHp) {


    private fun daggerAttack(damage: Int = 25) {
        if (isMinionSummoned && minion.isAlive) {
            println("$name greift ${minion.name} mit seinem Dolch an.")
            minion.takeDamage(damage)
        } else {
            println("$name greift ${dragon.name} mit seinem Dolch an.")
            dragon.takeDamage(damage)
        }
    }

    private fun slashAttack(damage: Int = 40) {
        if (isMinionSummoned && minion.isAlive) {
            println("$name greift mit einem mächtigen Hieb ${minion.name} an.")
            minion.takeDamage(damage)
            println("${minion.name} hat nun noch ${minion.hp} Lebenspunkte übrig!")
        } else {
            println("$name greift mit einem mächtigen Hieb ${dragon.name} an.")
            dragon.takeDamage(damage)
        }

    }

    private fun deception(damage: Int = 40) {
        if (isMinionSummoned && minion.isAlive) {
            println("$name täuscht ${minion.name} und stiehlt ihm 40 Lebenspunkte!")
            minion.takeDamage(damage)
            this.hp += 40
        } else {
            println("$name täuscht ${dragon.name} und stiehlt ihm 40 Lebenspunkte!")
            dragon.takeDamage(damage)
            this.hp += 40
        }
    }

    private fun sneakAttack(damage: Int = 60) {
        if (isMinionSummoned && minion.isAlive) {
            println("$name schleicht sich leise an ${minion.name} heran und führt einen hinterhältigen Dolchstoß aus.")
            minion.takeDamage(damage)
        } else {
            println("$name schleicht sich leise an ${dragon.name} heran und führt einen hinterhältigen Dolchstoß aus.")
            dragon.takeDamage(damage)
        }
    }

    fun thiefActions() {
        println("1. Dolchangriff")
        println("2. Hieb")
        println("3. Täuschung")
        println("4. Hinterhältiger Dolchstoß")
        try {
            when (readln().toInt()) {
                1 -> thief.daggerAttack()
                2 -> thief.slashAttack()
                3 -> thief.deception()
                4 -> thief.sneakAttack()
                else -> {
                    println("Ungültige Auswahl. Bitte 1-4 wählen.")
                    thiefActions()
                }
            }
        } catch (e: NumberFormatException) {
            println("Bitte eine Zahl zwischen 1-4 wählen.")
            thiefActions()
        }
    }
}

