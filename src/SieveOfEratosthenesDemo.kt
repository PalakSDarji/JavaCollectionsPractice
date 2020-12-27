fun main(){
    val list = findPrimeNumbersUntilGivenNumber(30)
    println(list)
}

fun findPrimeNumbersUntilGivenNumber(number : Int) : List<Int>{

    val list = mutableListOf<Int>()
    val isPrimeBoolList = MutableList(number+1) {
        true
    }

    isPrimeBoolList[0] = false
    isPrimeBoolList[1] = false

    for(i in 2..number){

        if(isPrimeBoolList[i]){
            for(j in i*i.. number step i){
                isPrimeBoolList[j] = false
            }
        }
    }

    for(i in 1 until isPrimeBoolList.size){
        if(isPrimeBoolList[i]) list.add(i)
    }
    return list
}