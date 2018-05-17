
fun main(args: Array<String>) {
    println(whatShouldIDoToday("happy", "Sunny"))
    println(whatShouldIDoToday("sad"))
    print("How do you feel?")
    println(whatShouldIDoToday(readLine()!!))
}

fun isVeryHot (temperature: Int) = temperature > 35

fun isSadRainyCold (mood: String, weather: String, temperature: Int) =
        mood.toLowerCase() == "sad" && weather.toLowerCase() == "rainy" && temperature == 0

fun isHappySunny (mood: String, weather: String) = mood.toLowerCase() == "happy" && weather.toLowerCase() == "sunny"

fun whatShouldIDoToday(mood: String, weather: String = "Sunny", temperature: Int = 24) : String {
    return when {
        isVeryHot(temperature) -> "Go swimming."
        isSadRainyCold(mood, weather, temperature) -> "Stay in bed."
        isHappySunny(mood, weather) -> "Go for a walk."
        else -> "Stay home and read."
    }
}

// region old

//fun main(args: Array<String>) {
//
//    val mood = readLine()
//    println(whatShouldIDoToday(mood!!))
//
//    println(whatShouldIDoToday("sad"))                                              // ---> Listen some music
//    println(whatShouldIDoToday("bored"))                                            // ---> Watch a movie
//    println(whatShouldIDoToday("mad", "Rainy"))                             // ---> Make a Cheese Cake
//    println(whatShouldIDoToday("sad", "Rainy", 0))               // ---> Stay in bed
//    println(whatShouldIDoToday("happy", "Sunny", 32))            // ---> Go for a walk
//    println(whatShouldIDoToday("tired", weather = "cloudy", temperature = 22))       // ---> Stay home and read
//    println(whatShouldIDoToday("hungry", temperature = -12))                         // ---> Watch a movie
//    println(whatShouldIDoToday("sad", temperature = 36))                             // ---> Go swimming
//}
//
//fun whatShouldIDoToday(mood: String, weather: String = "Sunny", temperature: Int = 24): String {
//    return when {
//        mood == "sad" && weather == "Rainy" && temperature == 0 -> "Stay in bed."
//        mood == "bored" || temperature < 5 -> "Watch a movie."
//        mood == "happy" && weather == "Sunny" -> "Go for a walk."
//        mood == "sad"  && temperature < 30 -> "Listen some music."
//        temperature > 35 -> "Go swimming."
//        weather == "Rainy" -> "Make a Cheese Cake."
//        else -> "Stay home and read."
//    }
//}

// endregion old
