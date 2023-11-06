open class Hero(open var name: String, open var hp: Int) {
    var isAlive = true
    private var isProtected = false

    fun protect() {
        println("$name ist geschützt und wird vor Angriffen in der nächsten Runde bewahrt.")
        isProtected = true
    }

    open fun isHeroAlive(): Boolean {
        return this.hp > 0
    }

    fun takeDamage(damage: Int) {
        if (isProtected) {
            println("$name ist geschützt und erleidet keinen Schaden in dieser Runde.")
            isProtected = false
        } else {
            hp -= damage
            if (hp <= 0) {
                isAlive = false
            }
            println("$name erleidet $damage Schaden.")
        }
    }

    open fun useBagItem(item: BagItem) {
        // Verwende einen Gegenstand aus dem Beutel
        item.applyEffect(this)
    }
}