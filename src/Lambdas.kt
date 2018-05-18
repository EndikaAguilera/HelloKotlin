import java.util.*

fun main(args: Array<String>) {
    gamePlay(rollDice1())
    gamePlay(rollDice2(6))
    gamePlay(rollDice3(6))
    gamePlay(rollDice4(6))
}

fun gamePlay(diceRoll: Int){
    // do something with the dice roll
    println(diceRoll)
}

// has a lambda assigned at compile time, and the lambda is executed every time the variable is referenced,
// returning a different value.
val rollDice1 = { Random().nextInt(12) + 1}

val rollDice2 = { sides: Int -> Random().nextInt(sides) + 1 }

val rollDice3 = { sides: Int -> if (sides == 0) 0 else Random().nextInt(sides) + 1 }

val rollDice4 : (Int) -> Int = { sides -> if (sides == 0) 0 else Random().nextInt(sides) + 1 }
