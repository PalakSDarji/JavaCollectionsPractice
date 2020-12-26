fun main(){
    val insertionSort = InsertionSort()
    //val list = mutableListOf(4,7,2,6)
    val list = mutableListOf(44,27,12,66,50,1,755,34,1000)
    insertionSort.sort(list)
    println(list)
}

class InsertionSort {

    internal fun sort(arr : MutableList<Int>){

        var temp : Int

        for(j in 1 until arr.size){

            temp = arr[j]

            for(i in j-1 downTo 0){

                if(arr[i] > temp){
                    //means, left is bigger than right. shift to right by 1.
                    arr[i+1] = arr[i]
                }
                else {
                    //found right place. add it.
                    arr[i+1] = temp
                    break
                }

                if(i == 0){
                    //no left space to go. add it to 0th index.
                    arr[0] = temp
                    break
                }
            }
        }
    }
}