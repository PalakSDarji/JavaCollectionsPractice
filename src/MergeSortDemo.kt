fun main(){

    var arr = mutableListOf<Int>(5,4,3,2,1)

    arr = MergeSortDemo().sort(arr)

    println(arr)
}

class MergeSortDemo {

    fun sort(arr : MutableList<Int>) : MutableList<Int>{

        sortThis(arr, 0, arr.size-1)

        return arr
    }

    fun sortThis(list : MutableList<Int>, leftPos : Int, rightPos : Int)  : MutableList<Int>{

        if(leftPos == rightPos) return list;
        if(leftPos + 1 == rightPos) return list;

        var arr = list

        val midPos = leftPos + rightPos / 2

        val left = sortThis(arr, leftPos, midPos)
        println("SortThis : ${midPos+1}, $rightPos")
        val right = sortThis(arr, midPos + 1, rightPos)
        arr = merge(left, right)

        return arr
    }

    fun merge(arrLeft : MutableList<Int>, arrRight : MutableList<Int>) : MutableList<Int>{

        val sortedArr = mutableListOf<Int>()
        var leftPointer = 0
        var rightPointer = 0
        var indexPointer = 0

        while(leftPointer <= arrLeft.size || rightPointer <= arrRight.size){

            if(leftPointer <= arrLeft.size && rightPointer <= arrRight.size){

                //check both the values
                if(arrLeft[leftPointer] < arrRight[rightPointer]){
                    sortedArr[indexPointer] = arrLeft[leftPointer]
                    leftPointer++
                }
                else{
                    println("arrRight : $arrRight ")
                    sortedArr[indexPointer] = arrRight[rightPointer]
                    rightPointer++
                }

                indexPointer++
            }
            else if(leftPointer <= arrLeft.size){
                sortedArr[indexPointer] = arrLeft[leftPointer]
                leftPointer++
                indexPointer++
            }
            else if(rightPointer <= arrRight.size){
                sortedArr[indexPointer] = arrRight[rightPointer]
                rightPointer++
                indexPointer++
            }
        }

        return sortedArr
    }
}