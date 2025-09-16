package com.example.myapplication
//BAI1
fun main() {
    println("Hello, world!")
    println("This is the text to print!")

    // Biến
    // Assign once, cannot change.
    val age = 5
    val name = "Rover"

    // In biến có các mẫu chuỗi
    var roll = 6
    var rolledValue: Int = 4

    println("You are already ${age}!")
    println("You are already ${age} days old, ${name}!")

    // Gọi function
    printHello()
    printBorder("-", 10)

    val randomNumber = (1..6).random()
    println("Random number: $randomNumber")

    println("Roll result: ${roll()}")

    printBorder()
    printCakeBottom(age, 3)

    val num = 4
    if (num > 4) {
        println("The variable is greater than 4")
    } else if (num == 4) {
        println("The variable is equal to 4")
    } else {
        println("The variable is less than 4")
    }

    // Câu lệnh có điều kiện với when
    val rollResult = roll()
    val luckyNumber = 4
    when (rollResult) {
        luckyNumber -> println("You won!")
        1 -> println("So sorry! You rolled a 1. Try again!")
        2 -> println("Sadly, you rolled a 2. Try again!")
        3 -> println("Unfortunately, you rolled a 3. Try again!")
        4 -> println("No luck! You rolled a 4. Try again!")
        5 -> println("Don't cry! You rolled a 5. Try again!")
        6 -> println("Apologies! you rolled a 6. Try again!")
    }

    // Tạo dice và roll
    val myFirstDice = Dice(6)
    println("My first dice rolled: ${myFirstDice.roll()}")
}

fun printHello() {
    println("Hello Kotlin")
}

fun printBorder(border: String, timesToRepeat: Int) {
    repeat(timesToRepeat) { print(border) }
    println()
}

fun roll(): Int {
    val randomNumber = (1..6).random()
    return randomNumber
}

fun printBorder() {
    repeat(23) { print("=") }
    println()
}

fun printCakeBottom(age: Int, layers: Int) {
    repeat(layers) {
        repeat(age + 2) { print("@") }
        println()
    }
}

class Dice(val numSides: Int) {
    fun roll(): Int {
        val randomNumber = (1..numSides).random()
        return randomNumber
    }
}
