class Magician(name: String, hp: Int, maxHp: Int) : Hero(name, hp, maxHp) {

    var shieldRound = 0

    private fun fireball(damage: Int = 25) {
        if (isMinionSummoned && minion.isAlive) {
            println("$name wirft einen Feuerball auf ${minion.name} und fügt ihm $damage Lebenspunkte Schaden zu!")
            minion.takeDamage(damage)
        } else {
            println("$name wirft einen Feuerball auf ${dragon.name} und fügt ihm $damage Lebenspunkte Schaden zu!")
            dragon.takeDamage(damage)
        }
    }

    private fun healAllHeroes(heroes: List<Hero>) {
        println("$name wirkt einen Heilzauber auf das Heldenteam und stärkt alle noch lebenden Helden um 40 Lebenspunkte!.")
        for (hero in heroes) {
            if (hero.isAlive) {
                hero.hp += 40
                println("${hero.name} hat nun ${hero.hp} Lebenspunkte.")
            }
        }
    }

    private fun protectHeroes(heroes: List<Hero>) {
        println("$name wirkt einen Schutzzauber auf das Heldenteam.")
        for (hero in heroes) {
            if (hero.isAlive && shieldRound == 0) {
                hero.protect()
            }
        }
    }

    private fun firestorm(damage: Int = 25) {
        if (isMinionSummoned && minion.isAlive) {
            println("$name entfacht einen Feuersturm und fügt ${dragon.name} und ${minion.name} $damage Lebenspunkte Schaden zu!")
            dragon.takeDamage(damage)
            minion.takeDamage(damage)
        } else {
            println("$name entfacht einen Feuersturm und fügt ${dragon.name} $damage Lebenspunkte Schaden zu!")
            dragon.takeDamage(damage)
        }
    }

    fun magicianActions() {
        println("1. Feuerball")
        println("2. Feuersturm")
        println("3. Heilzauber")
        println("4. Schutzzauber")

        try {
            when (readln().toInt()) {

                1 -> magician.fireball()
                2 -> magician.firestorm()
                3 -> magician.healAllHeroes(heroes)
                4 -> magician.protectHeroes(heroes)
                else -> {
                    println("Ungültige Auswahl, bitte 1-4 auswählen!")
                    magicianActions()
                }
            }
        } catch (e: NumberFormatException) {
            println("Falsche Auswahl, bitte gültige Zahl von 1-4 auswählen!")
            magicianActions()
        }
    }
}