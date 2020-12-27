package javaexample

import java.util.*
import java.util.concurrent.TimeUnit
import kotlin.collections.ArrayList

fun main(){

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

    println("${end1 - start1} arraylist time : ${TimeUnit.NANOSECONDS.toSeconds(end1 - start1)}")

}
