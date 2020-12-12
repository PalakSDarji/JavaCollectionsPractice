fun main(){

    val list = mutableListOf<Int>(99,8,3,9,2)
    BubbleSortDemo().sort(list, BubbleSortDemo.SortingOrder.Asc)
    BubbleSortDemo().sort(list, BubbleSortDemo.SortingOrder.Dsc)
}

class BubbleSortDemo {

    sealed class SortingOrder{
        object Asc : SortingOrder()
        object Dsc : SortingOrder()
    }

    fun sort(list: MutableList<Int>, sortingOrder: SortingOrder) {

        //pass loop
        for (i in 0 until list.size) {

            var swapped = false

            //internal iteration over element on ith pass.
            for (j in 0 until list.size - 1 - i) {

                if(sortingOrder.equals(SortingOrder.Asc)){
                    if(list[j] > list[j+1]){
                        //do swap them.
                        val temp = list[j]
                        list[j] = list[j+1]
                        list[j+1] = temp

                        swapped = true
                    }
                }
                else{
                    if(list[j] < list[j+1]){
                        //do swap them.
                        val temp = list[j]
                        list[j] = list[j+1]
                        list[j+1] = temp

                        swapped = true
                    }
                }

            }

            if(!swapped){
                //time to stop the pass loop.
                break;
            }
        }

        println("sorted list : $list")
    }
}