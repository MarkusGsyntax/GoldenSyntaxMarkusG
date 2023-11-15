val magician: Magician = Magician("Merlin", 150)
val warrior: Warrior = Warrior("Artus", 200)
val minion = Minion("Grisu", 100)
val dragon: Dragon = Dragon("Messoria", 350)
val thief: Thief = Thief("Parzival", 110)
var heroes = mutableListOf(magician, thief, warrior)
var bosses = mutableListOf(dragon)

fun main() {
    var isMinionSummoned = false
    val playBosses = ArrayList(bosses)
    val playHeroes = ArrayList(heroes)
    while (heroes.any { it.isAlive } && bosses.any { it.isAlive }) {
        println("\n--- Heldenzug ---")

        if (magician.isAlive) {
            println("Der Magier ist am Zug")
            magician.magicianAction()
        }
        if (thief.isAlive){
            println("der Dieb ist am Zug")
            thief.thiefAction()
        }


        println("\n--- Bossezug ---")

        if (minion.isAlive && dragon.isAlive) {
            for (boss in playBosses) {
                if (boss.isAlive) {
                    dragon.dragonActions()
                    if (!minion.isAlive && !dragon.isAlive) {
                        break
                    }
                }
            }
        }
    }
    println("\n--- Spiel beendet ---")

    if (heroes.all { !it.isAlive }) {
        println("Die Bosse haben gewonnen!")
    } else if (bosses.all { !it.isAlive }) {
        println("Die Helden haben gewonnen!")
    } else {
        println("Ungültiges Spielende. Kein klarer Gewinner.")
    }
}

