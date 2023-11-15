open class Dragon(name: String, hp: Int) : Boss(name, hp) {
    var hasSummonedMinion = false
    override var isAlive = true

    fun dragonActions() {
        val randomNumber = if (!hasSummonedMinion) {
            (1..5).random()
        } else {
            (2..6).random()
        }

        println("$name hat die Zufallszahl $randomNumber erhalten.")

        when (randomNumber) {
            1 -> summonMinion()
            2 -> fireBreath(heroes)
            3 -> thunderStrike(heroes)
            4 -> heal()
            5 -> shield()
            6 -> regenerate()
            else -> println("Keine gültige Aktion für Zufallszahl $randomNumber")
        }
    }

    fun summonMinion() {
        if (!hasSummonedMinion) {
            println("$name ruft Unterboss herbei!")
            hasSummonedMinion = true
            bosses.add(minion)
        }
    }

    fun fireBreath(heroes: List<Hero>, damage: Int = 40) {
        val livingHeroes = heroes.filter { it.isAlive }
        println("$name schickt seinen Feueratem und verursacht an allen lebenden Helden $damage Lebenspunkte Schaden!")
        for (hero in livingHeroes) {
            hero.takeDamage(damage)
        }
    }

    private fun thunderStrike(heroes: List<Hero>, damage: Int = 40) {
        val livingHeroes = heroes.filter { it.isAlive }
        println("$name ruft einen Blitzschlag herab und trifft einen zufälligen lebenden Helden.")
        if (livingHeroes.isNotEmpty()) {
            val randomHero = livingHeroes.random()
            randomHero.takeDamage(damage)
        }
    }

    private fun heal() {
        println("$name heilt sich selbst um 50 Lebenspunkte!")
        hp += 50
    }

    private fun regenerate() {
        println("$name regeneriert ${minion.name} um 25 Lebenspunkte!")
        minion.hp + 25
    }
}

