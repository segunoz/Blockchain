import java.time.*
import java.math.BigInteger
import java.security.MessageDigest

fun main(args: Array<String>) {
    println("This is the new Blockchain we are working on")
    println("We introduce Baddo coin")

    val badocoin = Blockchain

    for (i in 1..15) {
        badocoin.addNewBlock()
    }

    for (block in badocoin) {
        println("""Data : ${block.data}  | Previous Hash : ${block.previousHash}  | Current Hash = ${block.hash} |""".trimMargin())


    }
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
        val previousHash: String,
        val data: Any
    ) {
        val hash = calculateHash()
        val timeStamp = LocalDateTime.now()

        fun calculateHash(): String {
            val input = (index.toString() + previousHash + timeStamp + data).toByteArray()
            return input.cha256()
        }
    }

object Blockchain {
    val chain = mutableListOf<Block>()
    val latestBlock: Block
        get() = chain.last()

    init {
        chain.add(Block(0, "0", "Genesis block"))
    }

    fun addNewBlock(block: Block) {
        if (block) {
            chain.add(block)

        }
    }
}







