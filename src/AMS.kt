import java.util.*

fun main(args: Array<String>) {
    feedTheFish()

    println(canAddFish(10.0, listOf(3, 3, 3)))                                   // ---> false
    println(canAddFish(8.0, listOf(2, 2, 2), hasDecorations = false))            // ---> true
    println(canAddFish(9.0, listOf(1, 1, 3), 3))                         // ---> false
    println(canAddFish(10.0, listOf(), 7, true))           // ---> true
}

fun feedTheFish() {
    val day = randomDay()
    val food = fishFood(day)
    println("Today is $day and the fish eas $food")
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
