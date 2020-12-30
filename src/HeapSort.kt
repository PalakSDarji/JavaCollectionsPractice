fun main(){

    val list = mutableListOf(4,2,3,5,1)
    val list1 = mutableListOf(4,29,25,60,3,5,1)
    val list2 = mutableListOf(30,95,4,29,25,60,3,5,67,100,15)

    HeapSort().sort(list)
}

class HeapSort{

    fun sort(list : MutableList<Int>){

        adjustMaxHeap(list, list.size)
        println(list)
        deletion(list)
        println(list)
    }

    private fun deletion(list: MutableList<Int>) {

        var maxIndex = list.size - 1

        while(maxIndex > 0){
            val minValue = list[0]
            list.set(0,list[maxIndex])
            list.set(maxIndex,minValue)
            maxIndex--
            println("maxIndex : $maxIndex")
            adjustMaxHeap(list, maxIndex)
        }
    }

    private fun adjustMaxHeap(list : MutableList<Int>, n : Int){

        for(i in (n-1)/2 downTo 0){

            println(i)
            if(i == n) break

            val current = list[i]
            val leftIndex = getLeftIndex(i)
            val rightIndex = getRightIndex(i)

            if(leftIndex >= list.size) continue
            val leftChild = list[leftIndex]

            var biggerChild = leftChild
            var biggerIndex = leftIndex

            if(leftIndex >= list.size && rightIndex >= list.size){
                continue
            }
            else if(rightIndex <= list.size){

                val rightChild = list[rightIndex]

                if(rightChild > leftChild) biggerChild = rightChild
                if(rightChild > leftChild) biggerIndex = rightIndex

            }


            if(biggerChild > current){
                //swap..
                list[i] = biggerChild
                list[biggerIndex] = current
                adjustMaxHeap(list,i)
            }
        }
    }

    private fun getLeftIndex(index : Int) : Int {
        return 2*index + 1
    }

    private fun getRightIndex(index : Int) : Int {
        return getLeftIndex(index) + 1
    }
}