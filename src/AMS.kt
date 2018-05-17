import java.util.*

fun main(args: Array<String>) {
    feedTheFish()
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