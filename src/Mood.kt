fun main(args: Array<String>) {

    val mood = readLine()
    println(whatShouldIDoToday(mood!!))

    println(whatShouldIDoToday("sad"))                                              // ---> Listen some music
    println(whatShouldIDoToday("bored"))                                            // ---> Watch a movie
    println(whatShouldIDoToday("mad", "Rainy"))                             // ---> Make a Cheese Cake
    println(whatShouldIDoToday("sad", "Rainy", 0))               // ---> Stay in bed
    println(whatShouldIDoToday("happy", "Sunny", 32))            // ---> Go for a walk
    println(whatShouldIDoToday("tired", weather = "cloudy", temperature = 22))       // ---> Stay home and read
    println(whatShouldIDoToday("hungry", temperature = -12))                         // ---> Watch a movie
    println(whatShouldIDoToday("sad", temperature = 36))                             // ---> Go swimming
}

fun whatShouldIDoToday(mood: String, weather: String = "Sunny", temperature: Int = 24): String {
    return when {
        mood == "sad" && weather == "Rainy" && temperature == 0 -> "Stay in bed."
        mood == "bored" || temperature < 5 -> "Watch a movie."
        mood == "happy" && weather == "Sunny" -> "Go for a walk."
        mood == "sad"  && temperature < 30 -> "Listen some music."
        temperature > 35 -> "Go swimming."
        weather == "Rainy" -> "Make a Cheese Cake."
        else -> "Stay home and read."
    }
}