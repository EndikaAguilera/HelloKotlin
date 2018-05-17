
fun main(args: Array<String>) {
    var fortune = ""
    while (!fortune.contains("Take it easy")) {
        fortune = getFortuneCookie(getBirthday())
        println("\nYour fortune is: $fortune")
    }
}

fun getFortuneCookie(birthday: Int): String {

    if (birthday <= 0 || birthday > 31) return "Incorrect birthday. Try again!"

    val fortunes = listOf(
            "You will have a great day!",
            "Things will go well for you today.",
            "Enjoy a wonderful day of success.",
            "Be humble and all will turn out well.",
            "Today is a good day for exercising restraint.",
            "Take it easy and enjoy life!",
            "Treasure your friends because they are your greatest fortune.")

    return when (birthday) {
        in 1..7 -> fortunes[0]
        in 28..31 -> fortunes[fortunes.size - 1]
        else -> fortunes[birthday.rem(fortunes.size)]
    }
}

fun getBirthday(): Int {
    print("Enter your birthday: ")
    return readLine()?.toIntOrNull() ?: 0
}