package org.example.modules
import kotlin.math.sqrt
import org.example.modules.PrimeNumber

enum class NumberType{
    PRIME,
    ODD,
    EVEN,
    PERFECT, 
    PALINDROME
}

class EvaluationResult {
    val primes = mutableListOf<PrimeNumber>()
    val odds = mutableListOf<OddNumber>()
    val evens = mutableListOf<EvenNumber>()
    val perfects = mutableListOf<PerfectionNumber>()
    val palindromes = mutableListOf<PalindromeNumber>()
}

class PrimeNumberProcessor(private val range: IntRange) {
    
    fun processNumbers(): EvaluationResult {
        val result = EvaluationResult()
        
        for (number in range) {
            val numberTypes = NumType(number)
            
            numberTypes.forEach { numberType ->
                when (numberType) {
                    NumberType.PRIME -> result.primes.add(PrimeNumber(number))
                    NumberType.ODD -> {
                        val oddNumber = OddNumber(number)
                        oddNumber.divisorList.addAll(findDivisors(number))
                        result.odds.add(oddNumber)
                    }
                    NumberType.EVEN -> {
                        val evenNumber = EvenNumber(number)
                        evenNumber.divisorList.addAll(findDivisors(number))
                        result.evens.add(evenNumber)
                    }
                    //add perfect number
                    NumberType.PERFECT -> {
                        val perfectNumber = PerfectionNumber(number)
                        perfectNumber.divisorList.addAll(findDivisors(number))
                        result.perfects.add(perfectNumber)
                    }
                    NumberType.PALINDROME -> {
                        val palindromeNumber = PalindromeNumber(number)
                        palindromeNumber.divisorList.addAll(findDivisors(number))
                        result.palindromes.add(palindromeNumber)
                    }
                }
            }
        }
        
        return result
    }
    
    private fun NumType(number: Int): Set<NumberType> {
        val types = mutableSetOf<NumberType>()

        
        
        if (number > 1) {
            if (isPrime(number)) types.add(NumberType.PRIME)
        }
        if(isPerfectNumber(number)){
            types.add(NumberType.PERFECT)
        }
        if(palindromeNumber(number)){
            types.add(NumberType.PALINDROME)
        }
        if (number % 2 == 0) {
            types.add(NumberType.EVEN)
        } else {
            types.add(NumberType.ODD)
        }

        return types
    }
    
    private fun isPrime(number: Int): Boolean {
        if (number <= 1) return false
        if (number == 2) return true
        if (number % 2 == 0) return false
        
        for (i in 3..sqrt(number.toDouble()).toInt() step 2) {
            if (number % i == 0) return false
        }
        
        return true
    }
    
    private fun findDivisors(number: Int): List<Int> {
        return (1..number).filter { number % it == 0 }
    }

    private fun isPerfectNumber(number: Int): Boolean {
        if (number < 1) return false 
    
        var sum = 0
        for (i in 1 until number) {
            if (number % i == 0) {
                sum += i // 
            }
        }
        return sum == number
    }
    private fun palindromeNumber(number: Int): Boolean {
        return number == number.toString().reversed().toInt()
    }
}
