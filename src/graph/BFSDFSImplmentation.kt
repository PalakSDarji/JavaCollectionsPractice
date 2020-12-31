package graph

import java.util.*
import kotlin.collections.HashSet

class Graph(v : Int){

    var adj : Array<LinkedList<Int>> = Array(v){
        LinkedList()
    }

    fun addEdge(source : Int, destination : Int){
        adj[source].add(destination)
        adj[destination].add(source)
    }

    //find distance
    fun bfs(source: Int, destination: Int) : Int{

        val set = HashSet<Int>()
        val queue = LinkedList<Int>()
        val parent = IntArray(adj.size)

        set.add(source)
        queue.offer(source)
        parent[source] = -1

        while(queue.isNotEmpty()){

            val cur = queue.poll()
            if(cur == destination) break
            println("Op : $cur")
            val linkedList : LinkedList<Int> = adj[cur]

            for(node in linkedList){
                if(!set.contains(node)){
                    set.add(node)
                    queue.offer(node)
                    parent[node] =  cur
                }
            }
        }

        parent.forEachIndexed { index, i ->
            println("index $index -> $i")
        }
        //distance calculation
        var cur = destination
        var distance = 0
        while(parent[cur] != -1){
            cur = parent[cur]
            println("cur : $cur")
            distance++
        }

        return distance
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
    //val s1 = sc.nextInt()
    //val d2 = sc.nextInt()
    //val b = graph.dfs(s1,d2)

    //val s2 = sc.nextInt()
    //val b = graph.dfsThrough(s2)

    val s3 = sc.nextInt()
    val d3 = sc.nextInt()
    val b = graph.bfs(s3,d3)

    println("$b")

}