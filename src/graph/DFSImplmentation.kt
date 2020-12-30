package graph

import java.util.*

class Graph(v : Int){

    var adj : Array<LinkedList<Int>> = Array(v){
        LinkedList()
    }

    fun addEdge(source : Int, destination : Int){
        adj[source].add(destination)
        adj[destination].add(source)
    }

    fun dfs(source: Int, destination: Int) : Boolean{
        val visitedArray = BooleanArray(adj.size)
        visitedArray[source] = true

        val arrayDeque = ArrayDeque<Int>()
        arrayDeque.push(source)

        while(arrayDeque.isNotEmpty()){
            val cur = arrayDeque.pop()

            if(cur == destination) return true
            println("Op : $cur")
            for(neighbor in adj[cur]){
                if(!visitedArray[neighbor]){
                    visitedArray[neighbor] = true
                    arrayDeque.push(neighbor)
                }
            }
        }

        return false
    }

    fun dfsThrough(source: Int) : Boolean{
        return dfs(source, adj.size)
    }
}

fun main(){
    val sc = Scanner(System.`in`)
    println("Please enter number of vertices and edegs:")
    val v = sc.nextInt()
    val e = sc.nextInt()

    val graph = Graph(v)
    println("Please enter $e edges:")

    for(i in 0 until e){
        val source = sc.nextInt()
        val destination = sc.nextInt()
        graph.addEdge(source,destination)
    }

    println("Please enter source /*and destination:*/")
    val s = sc.nextInt()
    //val d = sc.nextInt()

    //val b = graph.dfs(s,d)
    val b = graph.dfsThrough(s)
    println("$b")

}