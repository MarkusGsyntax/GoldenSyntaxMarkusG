class Minion(name: String, hp: Int) : Boss(name, hp) {

    private fun fireAttack(damage: Int = 35) {
        val livingHeroes = heroes.filter { it.isAlive }
        if (livingHeroes.isNotEmpty()) {
            val randomTarget = livingHeroes.random()
            println("$name führt einen Feuerangriff auf ${randomTarget.name} aus.")
            randomTarget.takeDamage(damage)
        }
    }

    private fun poisonAttack() {
        val livingHeroes = heroes.filter { it.isAlive }
        if (livingHeroes.isNotEmpty()) {
            val randomHero = livingHeroes.random()
            println("$name hat ${randomHero.name} vergiftet.")
            isPoisoned = true
            if (randomHero.hp > randomHero.maxHP * 0.2 && isPoisoned) {
                val poisonDamage = (randomHero.maxHP * 0.1).toInt()
                randomHero.takeDamage(poisonDamage)
                println("${randomHero.name} erleidet $poisonDamage Giftschaden.")
            } else if (randomHero.hp <= randomHero.maxHp * 0.20 && isPoisoned) {
                isPoisoned = false
                println("${randomHero.name} hat 20% seiner Lebenspunkte erreicht. Vergiftung beendet!")
            }
        }
    }


    private fun lifeSteal(damage: Int = 25) {
        val livingHeroes = heroes.filter { it.isAlive }
        if (livingHeroes.isNotEmpty()) {
            val randomTarget = livingHeroes.random()
            println("$name stiehlt $damage Lebenspunkte von ${randomTarget.name}.")
            randomTarget.takeDamage(damage)
            this.hp += 25
            println("$name hat nun $hp Lebenspunkte!")
        }
    }

    private fun heal() {
        println("$name heilt sich selbst um 25 Lebenspunkte!")
        this.hp += 25
        println("$name hat nun $hp Lebenspunkte!")
    }

    fun minionAction(isMinionSummoned: Boolean) {
        if (isMinionSummoned) {
            val randomNumber = (1..4).random()

            when (randomNumber) {
                1 -> fireAttack()
                2 -> poisonAttack()
                3 -> lifeSteal()
                4 -> heal()
                else -> println("Keine gültige Aktion für Zufallszahl $randomNumber")
            }
        }
    }
}
