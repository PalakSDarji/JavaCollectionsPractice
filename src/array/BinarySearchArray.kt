package array

fun main(){

    val arr = arrayListOf(1,5,8,12,20)
    val search = 10
    var searchedIndex = -1

    var low = 0
    var high = arr.size - 1
    var middle: Int

    while(low <= high){
        middle = (low + high)/2

        if(arr[middle] == search){
            searchedIndex = middle
            break
        }
        else if(search < arr[middle]){
            high = middle - 1
        }
        else {
            low = middle + 1
        }
    }

    if(searchedIndex >= 0){
        println("found searchedIndex : $searchedIndex")
    }
    else{
        println("did not find.")
    }
}