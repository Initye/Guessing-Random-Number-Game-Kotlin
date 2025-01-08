import kotlin.random.Random
import java.util.Scanner


var score = 0 //made it global

fun main() {
    var keepPlaying = true
    val difficultyLevel = difficulty()

    while (keepPlaying){ //while keepPlaying == true, loop the game
        val value = randomNumber(difficultyLevel)
        val integer = selectedNumber()

        logic(integer, value)
        keepPlaying = askToKeepPlaying()
    }
    
}


fun randomNumber(difficultyLevel: Int): Int {
    val range = when(difficultyLevel) {
        1 -> 1..5 
        2 -> 1..10
        3 -> 1..15
        else -> 1..10
    }
    val value = Random.nextInt(range.first, range.last + 1) //Makes The number from list an Int
    println("Generated value: $value") //No need to print this, made it only to debug thats why it's commented, if you want to know the generated number uncomments this
    //println("Number range: $range") //No need to print this, made it only to debug thats why it's commented, if you want to see the range of numbers uncomments this
    return value
}

fun difficulty(): Int  { 
    var level: Int? = null
    val reader = Scanner(System.`in`)
    print("Please select difficulty: Easy/Normal/Hard: ")
    
    val response = reader.nextLine().lowercase()

    if (response == "easy"){
        level = 1
    } 
    else if (response == "normal") {
        level = 2
    } 
    else if (response == "hard") {
        level = 3
    } else { 
        println("Invalid input. Setting difficulty to 'Normal'. ")
        level = 2
    }

    //println("Value of selected difficulty: $level") //No need to print this, made it only to debug thats why it's commented, if you want to know the value of level uncomments this
    return level
}

fun selectedNumber(): Int {
    val reader = Scanner(System.`in`) 
    print("Enter number: ")
    var integer: Int = reader.nextInt() 
    println("You've entered: $integer")

    return integer
}

fun logic(integer: Int, value: Int) {
    if (integer == value) {
        score++
        println("Correct")
    } else {
        score = 0
        println("No, not this one")
    } 

    println("Your score: $score")
}



fun askToKeepPlaying(): Boolean {
    var decision: Boolean

    val reader = Scanner(System.`in`)
    print("Do you want to play again? yes/no: ")
    val response = reader.nextLine().lowercase() //lower case since when user enters "Yes" instead of "yes" the program will stop

    if (response == "yes"){
        decision = true
    } else {
        decision = false
    }

    return decision 
}
