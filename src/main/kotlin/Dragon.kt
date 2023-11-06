class Dragon(name: String, hp: Int, magician: Magician, thief: Thief, warrior: Warrior) :
    Boss(name, hp, magician, thief, warrior) {
    private var hasSummonedMinion = false
    private var minion = Minion("Grisu", 100, magician, thief, warrior)
    override var isAlive = true
    private val heroes = mutableListOf<Hero>(magician, thief, warrior)

    fun dragonActions() {
        val randomNumber = (1..5).random()
        if (!hasSummonedMinion && randomNumber == 1) {
            summonMinion()
        } else if (randomNumber == 2) {
            fireBreath(heroes, 25)
        } else if (randomNumber == 3) {
            thunderStrike(heroes, 30)
        } else if (hp < 300 && randomNumber == 4) {
            heal()
        } else if (!isShieldActive && randomNumber == 5) {
            shield()
        } else if (hasSummonedMinion && randomNumber == 6) {
            regenerate()
        }
    }

    fun isDragonAlive(): Boolean {
        return if (super.isAlive) {
            true
        } else {
            minion.isMinionAlive()
        }
    }

    fun summonMinion() {
        if (!hasSummonedMinion) {
            println("$name ruft Unterboss herbei!")
            val bosses = mutableListOf(this, minion)
            hasSummonedMinion = true
        }
    }

    private fun fireBreath(heroes: List<Hero>, damage: Int) {
        val livingHeroes = heroes.filter { it.isHeroAlive() }
        println("$name schickt seinen Feueratem und verursacht $damage an allen lebenden Helden Schaden.")
        for (hero in livingHeroes) {
            hero.takeDamage(damage)
        }
    }

    private fun thunderStrike(heroes: List<Hero>, damage: Int) {
        val livingHeroes = heroes.filter { it.isHeroAlive() }
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

    fun regenerate() {
        println("$name regeneriert ${minion.name} um 25 Lebenspunkte!")
        minion.hp + 25
    }
}

