class CustomWidget(final var context : BuildContext) {

    fun drawWidget(builder : (BuildContext) -> Widget){
        var widget : Widget = builder(context)
    }
}

class Widget(var context : BuildContext){

}

class BuildContext {

}

fun main(){
    var cw = CustomWidget(BuildContext())
    cw.drawWidget { context ->
        return@drawWidget Widget(context)
    }
}