import java.util.*

fun main(args: Array<String>) {

    feedTheFish()

    // repeat (function from standard library)
    repeat(2) {
        println("A fish is swimming")
    }

//    println(canAddFish(10.0, listOf(3, 3, 3)))                                    // ---> false
//    println(canAddFish(8.0, listOf(2, 2, 2), hasDecorations = false))             // ---> true
//    println(canAddFish(9.0, listOf(1, 1, 3), 3))                                  // ---> false
//    println(canAddFish(10.0, listOf(), 7, true))                                  // ---> true

}


fun swim() {

}

fun shouldChangeWater(day: String, temperature: Int = 22, dirty: Int = 20): Boolean {
//    val isTooHot = temperature > 30
//    val isDirty = dirty > 30
//    val isSunday = day == "Sunday"
    return when {
        isTooHot(temperature) -> true
        isDirty(dirty) -> true
        isSunday(day) -> true
        else -> false
    }
}

var dirty = 20

val waterFilter: (Int) -> Int = { dirty -> dirty / 2 }
fun feedFish(dirty: Int) = dirty + 10

fun updateDirty(dirty: Int, operation: (Int) -> Int): Int {
    return operation(dirty)
}

fun dirtyProcessor() {
    dirty = updateDirty(dirty, waterFilter)
    dirty = updateDirty(dirty, ::feedFish)
    dirty = updateDirty(dirty, { dirty -> dirty + 50 })
}

fun isTooHot(temperature: Int) = temperature > 30

fun isDirty(dirty: Int) = dirty > 30

fun isSunday(day: String) = day == "Thursday"

fun feedTheFish() {
    val day = randomDay()
    val food = fishFood(day)
    println("Today is $day and the fish eats $food")
    shouldChangeWater(day, 20, 50)
    shouldChangeWater(day)
    shouldChangeWater(day, dirty = 50)

    if (shouldChangeWater(day)) println("Change water today")

    // call the processor
    dirtyProcessor()
}

fun randomDay(): String {
    val weekDays = listOf("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday")
    return weekDays[Random().nextInt(weekDays.size)]
}


fun fishFood(day: String): String {
    return when (day) {
        "Monday" -> "flakes"
        "Tuesday" -> "pellets"
        "Wednesday" -> "redworms"
        "Thursday" -> "granules"
        "Friday" -> "mosquitoes"
        "Saturday" -> "lettuce"
        "Sunday" -> "plankton"
        else -> "fasting"
    }
}

fun canAddFish(tankSize: Double, currentFish: List<Int>, fishSize: Int = 2, hasDecorations: Boolean = true): Boolean {
    return (tankSize * if (hasDecorations) 0.8 else 1.0) >= (currentFish.sum().plus(fishSize))
//    return (tankSize.times(if (hasDecorations) 0.8 else 1.0)) >= (currentFish.sum().plus(fishSize))
}


// region unused

fun fishFoodV2(day: String): String {

    var food = "fasting"

    when (day) {
        "Monday" -> food = "flakes"
        "Tuesday" -> food = "pellets"
        "Wednesday" -> food = "redworms"
        "Thursday" -> food = "granules"
        "Friday" -> food = "mosquitoes"
        "Saturday" -> food = "lettuce"
        "Sunday" -> food = "plankton"
    }

    return food
}

fun dayOfWeek() {

    println("What day is it today?")

    val day = Calendar.getInstance().get(Calendar.DAY_OF_WEEK)

    println(when (day) {
        1 -> "Today is Sunday"
        2 -> "Today is Monday"
        3 -> "Today is Tuesday"
        4 -> "Today is Wednesday"
        5 -> "Today is Thursday"
        6 -> "Today is Friday"
        7 -> "Today is Saturday"
        else -> "Time has stopped"
    })


}

fun canAddFishV2(tankSize: Double, currentFish: List<Int>, fishSize: Int = 2, hasDecorations: Boolean = true): Boolean {

    val fishesPerGallon = if (hasDecorations) 0.8f else 1f
    val maxFishesAllowed = fishesPerGallon.times(tankSize)

    val tankFishesSize = currentFish.sum()
//    for (item: Int in currentFish) tankFishesSize = tankFishesSize.plus(item)

    return tankFishesSize.plus(fishSize) <= maxFishesAllowed
}

// endregion unused
