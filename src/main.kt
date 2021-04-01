import com.sun.org.apache.xalan.internal.lib.ExsltDatetime.time
import java.util.*

fun main(args: Array<String>){
    println("This is the new Blockchain we are working on")


}


class Block(
    val index: Int,
    val previousHash : String,
    val data : Any){
    val hash = calculateHash()
    val timeStamp = Date.time()

    fun calculateHash() : String{
        val input = (index.toString() + previousHash + timeStamp + data).toByteArray()


    }

}
