
import java.time.*
import java.math.BigInteger
import java.security.MessageDigest


fun main(args: Array<String>) {
    println("This is the new Blockchain we are working on")
    println("We introduce Baddo coin")

    val badoCoin = Block



    for (i in 1..15) {
        badoCoin.addNewBlock(Block.latestBlock)
        //test code to see if new hash is being added to the blockchain
        println(Block.hashCode())
    }

   /* for (block in badoCoin.chain) {
        println("""Data : ${block.data}  | Previous Hash : ${block.previousHash}  | Current Hash = ${block.hash} |""".trimMargin())


    } */
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
        val timeStamp: LocalDateTime = LocalDateTime.now()

        fun calculateHash(): String {
            val input = (index.toString() + previousHash + timeStamp + data).toByteArray()
            return input.sha256()
        }

    companion object Blockchain {
            val chain = mutableListOf<Block>()
            val latestBlock: Block
                get() = chain.last()

            init {
                chain.add(Block(0, "0", "Genesis block"))
            }


            //to add new block to the
            fun addNewBlock(block: Block) {
                if (isNewBlockValid(block)) {
                    chain.add(block)
                }

            }

        }

    }


        //to check if the block is valid.
        fun isNewBlockValid(block: Block): Boolean {
            return true
        }




        //I am having problems adding a previous hash...

