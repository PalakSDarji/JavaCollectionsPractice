fun main(){
    var list : List<Int> = (1..20).toList()
    println(list)

    var list1 = list.filter {
        i -> i%2 == 0
    }

    var list2 : List<Int> = list.myCustomFilter{
        item, index ->
        val b = item % 2 == 0 && (item == 2 || item == 4)
        return@myCustomFilter b
    }

    println(list2)
}

fun <T> List<T>.myCustomFilter(predicate: (item : T,index : Int) -> Boolean) : List<T>{
    println("inside myCustomFilter")
    var newList = arrayListOf<T>()
    this.forEachIndexed {
        index, item ->
        var shouldAdd : Boolean = predicate(item,index)
        if(shouldAdd) newList.add(item)
    }
    return newList
}