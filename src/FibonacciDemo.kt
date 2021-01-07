fun main(){
    val range = 10
    var firstNumber = 0
    var secNumber = 1

    for(i in 0..range){

        print("$firstNumber ")
        val sum = firstNumber + secNumber
        firstNumber = secNumber
        secNumber = sum
    }
}