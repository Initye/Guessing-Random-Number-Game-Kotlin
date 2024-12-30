import kotlin.random.Random
import java.util.Scanner


var score = 0 //made it global

fun main() {
    var keepPlaying = true
    
    while (keepPlaying){ //while keepPlaying == true, loop the game
        val value = randomNumber()
        val integer = selectedNumber()

        logic(integer, value)
        keepPlaying = askToKeepPlaying()
    }
    
}


fun randomNumber(): Int {
    val randomValues =  List(1) {Random.nextInt(1, 11)} //Generate random number and put it into list (thats not most efficient way but i did this to train (you can just use Random.nextInt without List))
    val value  = randomValues[0] //Makes The number from list an Int
    // println("Generated value: $value") //No need to print this, made it only to debug thats why it's commented, if you want to know the generated number uncomments this

    return value
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
        println("Nope, not that one, try again")
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
