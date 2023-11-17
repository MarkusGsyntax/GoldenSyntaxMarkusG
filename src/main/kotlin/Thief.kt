class Thief(name: String, hp: Int, maxHp: Int) : Hero(name, hp, maxHp) {


    private fun daggerAttack(damage: Int = 25) {
        if (isMinionSummoned && MINION.isAlive) {
            println("$name greift ${MINION.name} mit seinem Dolch an.")
            MINION.takeDamage(damage)
        } else {
            println("$name greift ${DRAGON.name} mit seinem Dolch an.")
            DRAGON.takeDamage(damage)
        }
    }

    private fun slashAttack(damage: Int = 40) {
        if (isMinionSummoned && MINION.isAlive) {
            println("$name greift mit einem mächtigen Hieb ${MINION.name} an.")
            MINION.takeDamage(damage)
            println("${MINION.name} hat nun noch ${MINION.hp} Lebenspunkte übrig!")
        } else {
            println("$name greift mit einem mächtigen Hieb ${DRAGON.name} an.")
            DRAGON.takeDamage(damage)
        }

    }

    private fun deception(damage: Int = 40) {
        if (isMinionSummoned && MINION.isAlive) {
            println("$name täuscht ${MINION.name} und stiehlt ihm 40 Lebenspunkte!")
            MINION.takeDamage(damage)
            this.hp += 40
        } else {
            println("$name täuscht ${DRAGON.name} und stiehlt ihm 40 Lebenspunkte!")
            DRAGON.takeDamage(damage)
            this.hp += 40
        }
    }

    private fun sneakAttack(damage: Int = 60) {
        if (isMinionSummoned && MINION.isAlive) {
            println("$name schleicht sich leise an ${MINION.name} heran und führt einen hinterhältigen Dolchstoß aus.")
            MINION.takeDamage(damage)
        } else {
            println("$name schleicht sich leise an ${DRAGON.name} heran und führt einen hinterhältigen Dolchstoß aus.")
            DRAGON.takeDamage(damage)
        }
    }

    fun thiefActions() {
        println("1. Dolchangriff")
        println("2. Hieb")
        println("3. Täuschung")
        println("4. Hinterhältiger Dolchstoß")
        try {
            when (readln().toInt()) {
                1 -> THIEF.daggerAttack()
                2 -> THIEF.slashAttack()
                3 -> THIEF.deception()
                4 -> THIEF.sneakAttack()
                else -> {
                    println("Ungültige Auswahl. Bitte 1-4 wählen.")
                    thiefActions()
                }
            }
        } catch (e: NumberFormatException) {
            println("Falsche Auswahl, bitte gültige ZAHL von 1-4 auswählen!")
            thiefActions()
        }
    }
}

