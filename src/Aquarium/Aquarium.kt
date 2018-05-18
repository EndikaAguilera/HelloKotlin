package Aquarium

import kotlin.math.PI


open class Aquarium(var width: Int = 20, var height: Int = 40, var length: Int = 100) {

//    fun volume1(): Int {
//        return width * height * length / 1000
//    }
//
//    fun volume2() = width * height * length / 1000
//
//    val volume1: Int
//        get() {
//            return width * height * length / 1000
//        }

    open var volume: Int
        get() = width * height * length / 1000
        set(value) {
            height = (value * 1000) / (width * length)
        }

    open var water = volume * 0.9

    constructor(numberOfFish: Int) : this() {

        val water: Int = numberOfFish * 2000 // cm3
        val tank: Double = water + water * 0.1
        height = (tank / (length * width)).toInt()

    }
}


// Aquarium must be declared as open
class TowerTank() : Aquarium() {

    // water must be declared as open in super (Aquarium)
    override var water = volume * 0.8

    // volume must be declared as open in super (Aquarium)
    override var volume: Int
        get() = (width * height * length / 1000 * PI).toInt()
        set(value) {
            height = (value * 1000) / (width * length)
        }
}
