package Aquarium

abstract class AquariumFish {
    abstract val color: String
}

class Shark : AquariumFish(), FishAction {

    override val color = "gray"

    override fun eat() {
        println("hunt and eat fish")
    }
}

//class Plecostomus : AquariumFish(), FishAction,
//        FishColor by GoldColor {
//
//    override fun eat() {
//        println("munch on algae")
//    }
//}

class Plecostomus(fishColor: FishColor = GoldColor) :
        FishAction by PrintFishAction("a lot of algae"),
        FishColor by GoldColor

interface FishAction {
    fun eat()
}

interface FishColor {
    val color: String
}

// Doesn't make sense to create multiple instance of GoldColor since it always return "gold",
// so it is declared as object instead of class
object GoldColor : FishColor {
    override val color: String
        get() = "gold"
}

object RedColor : FishColor {
    override val color: String
        get() = "red"
}

class PrintFishAction(val food: String) : FishAction {
    override fun eat() {
        println(food)
    }
}