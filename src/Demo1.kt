fun main(){
    var p = Person("Palak") { name ->
        println("name is $name and he is doing his job.")
    }
    p.doTheJob()
    p.doYourJobAsWell { age, name ->
        println("$name can do his job at age of $age")
        return@doYourJobAsWell true
    }
}

class Person(var name : String, var callback : (String) -> Unit){
    fun doTheJob(){
        callback(name)
    }

    fun doYourJobAsWell(yourJob : (Int, String) -> Boolean){
        doTheJob()
        var b : Boolean = yourJob(1,"Darji")
    }
}