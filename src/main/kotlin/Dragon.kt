open class Dragon(name: String, hp: Int) : Boss(name, hp) {
    private var isDragonSummonedMinion = false

    private fun summonMinion() {
        if (!isMinionSummoned) {
            println("$name ruft Unterboss herbei!")
            isMinionSummoned = true
            isDragonSummonedMinion = true
            bosses.add(minion)
        }
    }

    private fun fireBreath(damage: Int = 40) {
        val livingHeroes = heroes.filter { it.isAlive }
        println("$name schickt seinen Feueratem und verursacht an allen lebenden Helden $damage Lebenspunkte Schaden!")
        for (hero in livingHeroes) {
            hero.takeDamage(damage)
        }
    }

    private fun thunderStrike(damage: Int = 40) {
        val livingHeroes = heroes.filter { it.isAlive }
        if (livingHeroes.isNotEmpty()) {
            val randomHero = livingHeroes.random()
            println("$name ruft einen Blitzschlag herab und trifft ${randomHero.name}.")
            randomHero.takeDamage(damage)
        }
    }

    private fun heal() {
        println("$name heilt sich selbst um 50 Lebenspunkte!")
        hp += 50
    }

    private fun regenerate() {
        println("$name regeneriert ${minion.name} um 25 Lebenspunkte!")
        minion.hp += 25
    }

    fun dragonActions() {
        val randomNumber = if (!isMinionSummoned) {
            (1..5).random()
        } else if (!isDragonSummonedMinion && minion.isAlive) {
            (2..6).random()
        } else {
            (2..5).random()
        }

        when (randomNumber) {
            1 -> summonMinion()
            2 -> fireBreath()
            3 -> thunderStrike()
            4 -> heal()
            5 -> shield()
            6 -> regenerate()
            else -> println("Keine gültige Aktion für Zufallszahl $randomNumber")
        }
    }
}


