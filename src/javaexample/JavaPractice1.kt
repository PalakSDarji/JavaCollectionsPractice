package javaexample

import java.util.*
import java.util.concurrent.TimeUnit
import kotlin.collections.ArrayList


fun take(anotherFun : (String) -> Int) : Int{
    return anotherFun("S")
}
open class A{
    val a : Int = 2
    protected open fun printA(){
        println(a)
    }
}

class B : A() {
    override fun printA() {
        super.printA()
    }
}

fun createAlone(){

}

fun main(){

    createAlone()
    var l : List<Int> = mutableListOf<Int>(1,2,3,4,5)
    l = l.map {
        it * it
    }

    var lis = mutableListOf<ArrayList<Int>>(arrayListOf(1,2,3,4),arrayListOf(5,6,7,8))
    var lisr = lis.flatten()
    println(lis)
    println(lisr)

    val a = intArrayOf(1,2)
    val d = Array<Int>(2){
        0
    }

    val i : Int = take{
        it.length
    }

    var int : Int? = null
    var b = int?.toByte()
    //println(b.toString())

    int?.let {
        println("no null")
    } ?: println("null")
/*
    val ll = LinkedList<String>()
    val al = ArrayList<String>()

    var start = System.nanoTime()
    for(i in 0 until 10000000){
        ll.add("$i")
    }
    ll.add(10000,"start")
    var end = System.nanoTime()

    println("${end - start} linkedlist time : ${TimeUnit.NANOSECONDS.toSeconds(end - start)}")

    var start1 = System.nanoTime()
    for(i in 0 until 10000000){
        al.add("$i")
    }
    al.add(10000,"start")
    var end1 = System.nanoTime()

    println("${end1 - start1} arraylist time : ${TimeUnit.NANOSECONDS.toSeconds(end1 - start1)}")*/

}
