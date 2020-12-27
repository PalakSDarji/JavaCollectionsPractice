import kotlin.math.ceil
import kotlin.math.sqrt

fun main(){

    val list = findPrimeNumbers(300)
    println(list)
}

fun findPrimeNumbers(number : Int): List<Int>{

    var n = number
    var list = mutableListOf<Int>()

    list.add(1)

    while (n % 2 == 0){

        list.add(2)
        n /= 2
    }

    //now, number must be odd.
    for(i in 3 until ceil(sqrt(n.toDouble())).toInt() step 2){

        while(n % i == 0){

            list.add(i)
            n /= i
        }
    }

    if(n > 2) list.add(n)

    return list
}