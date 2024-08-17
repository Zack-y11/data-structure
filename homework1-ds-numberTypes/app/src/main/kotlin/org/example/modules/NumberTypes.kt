package org.example.modules

class PrimeNumber(override val value: Int): IBaseNumber{
    override fun printValue() {
        println("is Prime number: $value")
    }
}

class OddNumber(override val value: Int): IBaseNumber{
    val divisorList: MutableList<Int> = mutableListOf()

    override fun printValue(){
        println("is Odd number: $value")
        println("Divisor List: ${divisorList.joinToString(", ")}")
    }
}

class EvenNumber(override val value: Int): IBaseNumber{
    val divisorList: MutableList<Int> = mutableListOf()
    
    override fun printValue() {
        println("is Even number: $value")
        println("Divisor List: ${divisorList.joinToString(", ")}")

    }
}

//extension excercise
class PerfectionNumber(override val value: Int): IBaseNumber{

    val divisorList: MutableList<Int> = mutableListOf()
    override fun printValue() {
        println("is Perfect number: $value")
        println("Divisor List: ${divisorList.joinToString(", ")}")
    }
}

class PalindromeNumber(override val value: Int): IBaseNumber{
    val divisorList: MutableList<Int> = mutableListOf()
    override fun printValue() {
        println("is Palindrome number: $value")
        println("Divisor List: ${divisorList.joinToString(", ")}")
    }
}