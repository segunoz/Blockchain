import com.sun.org.apache.xalan.internal.lib.ExsltDatetime.time
import java.util.*
import java.time.*
import java.math.BigInteger
import java.security.MessageDigest

fun main(args: Array<String>){
    println("This is the new Blockchain we are working on")


}

fun ByteArray.md5(): String {
    val md = MessageDigest.getInstance("MD5")
    return BigInteger(1, md.digest()).toString(16).padStart(32, '0')
}

fun ByteArray.sha256(): String {
    val md = MessageDigest.getInstance("SHA-256")
    return BigInteger(1, md.digest()).toString(16).padStart(32, '0')

}


class Block(
    val index: Int,
    val previousHash : String,
    val data : Any){
    val hash = calculateHash()
    val timeStamp = LocalDateTime.now()

    fun calculateHash() : String{
        val input = (index.toString() + previousHash + timeStamp + data).toByteArray()
        return input.md5()


    }

    object Blockchain {
        val chain = mutableListOf<Block>()
        val latestBlock : Block
            get() = chain.last()

        init{
            chain.add(Block(0,"0", "Genesis block"))
        }

        fun addNewBlock(block: Block){
            if(isNewBlockValid(block)) chain.add(block)

        }
    }

}





