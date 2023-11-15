open class Hero(val name: String, var hp: Int) {
    var isAlive = true
    private var isProtected = false

    fun protect() {
        println("$name ist geschützt und wird vor Angriffen in der nächsten Runde bewahrt.")
        isProtected = true
    }

    fun takeDamage(damage: Int) {
        if (isProtected) {
            println("$name ist geschützt und erleidet keinen Schaden in dieser Runde.")
            isProtected = false
        } else {
            hp -= damage
            Thread.sleep(1500)
            println("${this.name} hat noch ${this.hp} Lebenspunkte!")
            if (this.hp <= 0) {
                this.isAlive = false
                println("${this.name} ist gestorben!")
                heroes.remove(this)
            }
        }
    }
}
