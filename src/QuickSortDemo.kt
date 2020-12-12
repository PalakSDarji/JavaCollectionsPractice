fun main(){

    val list = mutableListOf<Int>(6,3,7,2,1,8)

    QuickSortDemo().sort(list,0,list.size-1);

    print("sorted : $list")

}

class QuickSortDemo {

    fun partition(list: MutableList<Int>, low : Int, high : Int) : Int{

        println("partition : $list, low : $low, high : $high")
        val pivotIndex = low
        var pivot = list[pivotIndex]
        var start = low
        var end = high

        while(start < end){

            while(list[start] <= pivot){
                start++
            }

            while(pivot < list[end]){
                end--
            }

            if(start < end){
                swap(list, start, end)
            }
        }

        println("in partition got start big $start, $end")

        swap(list, pivotIndex, end)

        return end;
    }

    fun sort(list : MutableList<Int>, lb : Int, ub : Int){
        println("sort : $list, lb : $lb, ub : $ub")
        if(lb < ub){
            val partitionIndex = partition(list, lb, ub)
            println("got partitionIndex : $partitionIndex")
            sort(list, lb,partitionIndex-1)
            sort(list,partitionIndex+1, ub)
        }
    }

    private fun swap(list: MutableList<Int>, start: Int, end: Int) {
        println("swap : $list, start : $start, end : $end")
        val temp = list[start]
        list[start] = list[end]
        list[end] = temp
    }
}