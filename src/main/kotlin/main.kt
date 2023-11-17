val MAGICIAN: Magician = Magician("Merlin", 150, 150)
val THIEF: Thief = Thief("Parzival", 110, 110)
val WARRIOR: Warrior = Warrior("Artus", 200, 200)

val MINION = Minion("Grisu", 150)
val DRAGON: Dragon = Dragon("Messoria", 500)

var heroes: MutableList<Hero> = mutableListOf(MAGICIAN, THIEF, WARRIOR)
var bosses: MutableList<Boss> = mutableListOf(DRAGON)

var isMinionSummoned = false
var isPoisoned = false

fun main() {

    println("Willkommen zu Golden Syntax")

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
                    println("\n${MAGICIAN.name} ist am Zug.")
                    MAGICIAN.magicianActions()
                }

                is Thief -> {
                    println("\n${THIEF.name} ist am Zug.")
                    THIEF.thiefActions()
                }

                is Warrior -> {
                    println("\n${WARRIOR.name} ist am Zug.")
                    WARRIOR.warriorActions()
                }
            }
        }
        if (bosses.none { it.isAlive }) {
            println("\n--- Alle Bosse sind gestorben. Die Helden gewinnen! ---")
            break
        }

        println("\n--- Bossezug ---")

        if (isMinionSummoned && MINION.isAlive) {
            DRAGON.dragonActions()
            MINION.minionAction(isMinionSummoned)

        } else {
            DRAGON.dragonActions()
        }
        if (heroes.none { it.isAlive }) {
            println("\n--- Alle Helden sind gestorben. Die Bosse gewinnen! ---")
            break
        }
    }
}