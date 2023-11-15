class Thief(name: String, hp: Int) : Hero(name, hp) {


    fun daggerAttack(bosses: List<Boss>, damage: Int = 25) {
        if (bosses.contains(minion)) {
            println("$name greift ${minion.name} mit seinem Dolch an.")
            minion.takeDamage(damage)
        } else {
            println("$name greift ${dragon.name} mit seinem Dolch an.")
            dragon.takeDamage(damage)
        }
    }

    fun slashAttack(bosses: List<Boss>, damage: Int = 40) {
        if (bosses.contains(minion)) {
            println("$name greift mit einem mächtigen Hieb ${minion.name} an.")
            minion.takeDamage(damage)
            println("${minion.name} hat nun noch ${minion.hp} Lebenspunkte übrig!")
        } else {
            println("$name greift mit einem mächtigen Hieb ${dragon.name} an.")
            dragon.takeDamage(damage)
        }

    }

    fun decieve (bosses: List<Boss>, damage: Int = 40) {
        if (bosses.contains(minion)) {
            println("$name täuscht ${minion.name} und stiehlt ihm 40 Lebenspunkte!")
            minion.takeDamage(damage)
            this.hp += 40
        } else {
            println("$name täuscht ${dragon.name} und stiehlt ihm 40 Lebenspunkte!")
            dragon.takeDamage(damage)
            this.hp += 40
        }
    }
        fun sneakAttack(bosses: List<Boss>, damage: Int = 60) {
            if (bosses.contains(minion)) {
                println("$name schleicht sich leise an ${minion.name} heran und führt einen hinterhältigen Dolchstoß aus.")
                minion.takeDamage(damage)
            } else {
                println("$name schleicht sich leise an ${dragon.name} heran und führt einen hinterhältigen Dolchstoß aus.")
                dragon.takeDamage(damage)
            }
        }

        fun thiefAction() {
            println("1. Dolchangriff")
            println("2. Hieb")
            println("3. Täuschung")
            println("4. Hinterhältiger Dolchstoß")

            when (readLine()?.toIntOrNull()) {
                1 -> thief.daggerAttack(bosses)
                2 -> thief.slashAttack(bosses)
                3 -> thief.decieve(bosses)
                4 -> thief.sneakAttack(bosses)
                else -> println("Ungültige Auswahl. Normale Attacke wird ausgeführt.")
            }
        }
    }

