class Magician(name: String, hp: Int) : Hero(name, hp) {


    fun fireball(bosses: List<Boss>, damage: Int = 25) {
        if (bosses.contains(minion)) {
            println("$name wirft einen Feuerball auf ${minion.name} und fügt ihm $damage Lebenspunkte Schaden zu!")
            minion.takeDamage(damage)
        } else if(!bosses.contains(minion))
            println("$name wirft einen Feuerball auf ${dragon.name} und fügt ihm $damage Lebenspunkte Schaden zu!")
            dragon.takeDamage(damage)

    }

    fun healAllHeroes(heroes: List<Hero>) {
        println("$name wirkt einen Heilzauber auf das Heldenteam und stärkt alle noch lebenden Helden um 40 Lebenspunkte!.")
        for (hero in heroes) {
            if (hero.isAlive) {
                hero.hp += 40
                println("${hero.name} hat nun ${hero.hp} Lebenspunkte.")
            }
        }
    }


    fun protectHeroes(heroes: List<Hero>) {
        println("$name wirkt einen Schutzzauber auf das Heldenteam.")
        for (hero in heroes) {
            if (hero.isAlive) {
                hero.protect()
            }
        }
    }

    fun firestorm(bosses: List<Boss>, damage: Int = 25) {
        if (dragon.hasSummonedMinion && minion.isAlive) {
            println("$name entfacht einen Feuersturm und fügt ${dragon.name} und ${minion.name} $damage Lebenspunkte Schaden zu!")
            dragon.takeDamage(damage)
            minion.takeDamage(damage)
        } else if (!dragon.hasSummonedMinion) {
            println("$name entfacht einen Feuersturm und fügt ${dragon.name} $damage Lebenspunkte Schaden zu!")
            dragon.takeDamage(damage)
        }
    }
    fun magicianAction() {
        println("1. Feuerball")
        println("2. Feuersturm")
        println("3. Heilzauber")
        println("4. Schutzzauber")

        when (readLine()?.toIntOrNull()) {
            1 -> magician.fireball(bosses)
            2 -> magician.firestorm(bosses)
            3 -> magician.healAllHeroes(heroes)
            4 -> magician.protectHeroes(heroes)
            else -> println("Ungültige Auswahl. Normale Attacke wird ausgeführt.")
        }
    }


}