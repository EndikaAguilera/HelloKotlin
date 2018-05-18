package Aquarium

// it is recommended to use one primary constructor and init just once,
// when you need more flexibility consider adding helper functions like makeDefaultFish()
class Fish(val friendly: Boolean = true, volumeNeeded: Int) {

    val size: Int = if (friendly) {
        volumeNeeded
    } else {
        volumeNeeded * 2
    }

}

fun makeDefaultFish() = Fish(true, 50) // optimal way

fun fishExample () {
    val fish = makeDefaultFish()
    println("Is the fish friendly? ${fish.friendly}. It needs volume ${fish.size}")
}

// example class with constructor and multiple init (not recommended)
//class FishExampleWithConstructors(val friendly: Boolean = true, volumeNeeded: Int) {
//
//    val size: Int
//
//    init {
//        println("first init block")
//    }
//
//    constructor() : this(true, 9) {
//        println("running secondary constructor")
//    }
//
//    init {
//        if (friendly) {
//            size = volumeNeeded
//        } else {
//            size = volumeNeeded * 2
//        }
//    }
//
//    init {
//        println("constructed fish of size $volumeNeeded final size ${this.size}")
//    }
//
//    init {
//        println("last init block")
//    }
//}
