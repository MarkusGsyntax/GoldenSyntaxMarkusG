val magician: Magician = Magician("Merlin", 150, 150)
val thief: Thief = Thief("Parzival", 110, 110)
val warrior: Warrior = Warrior("Artus", 200, 200)

val minion = Minion("Grisu", 150)
val dragon: Dragon = Dragon("Messoria", 350)

var heroes : MutableList<Hero> = mutableListOf(magician, thief, warrior)
var bosses : MutableList<Boss> = mutableListOf(dragon)

var isMinionSummoned = false
var isPoisoned = false

fun main() {
    for (rounds in 1..1000) {
        println("\n--- Runde $rounds ---")
        println("Die Helden haben jetzt:")
        heroes.forEach { hero ->
            println("${hero.name} -> ${hero.hp} Lebenspunkte")
        }

        println()
        println()

        println("Die Gegner haben jetzt:")
        bosses.forEach { boss ->
            println("${boss.name} -> ${boss.hp} Lebenspunkte")
        }

        for (hero in heroes) {
            if (!hero.isAlive) {
                continue
            }

            when (hero) {
                is Magician -> {
                    println("\n${magician.name} ist am Zug.")
                    magician.magicianActions()
                }

                is Thief -> {
                    println("\n${thief.name} ist am Zug.")
                    thief.thiefActions()
                }
                // Füge hier weitere Heldentypen hinzu, falls benötigt
            }
            if (bosses.none { it.isAlive })
                println("\n--- Alle Bosse sind gestorben. Die Helden gewinnen! ---")
            break
        }

        println("\n--- Bossezug ---")

        if (isMinionSummoned && minion.isAlive) {
            dragon.dragonActions()
            minion.minionAction(isMinionSummoned)

        } else {
            dragon.dragonActions()
        }
        if (heroes.none { it.isAlive }) {
            println("\n--- Alle Helden sind gestorben. Die Bosse gewinnen! ---")
            break
        }
    }
}

