import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.util.*

class AmazingTest {
    @Test
    fun testSeed0size15x20() {
        val expected = """
            Amazing - Copyright by Creative Computing, Morristown, NJ
            :--:--:--:--:--:--:--:--:--:--:  :--:--:--:--:
            I  I           I        I     I     I        I 
            :  :  :  :  :  :  :--:  :  :  :  :--:  :--:  :
            I     I  I  I  I     I     I     I     I  I  I 
            :--:--:  :  :--:  :  :--:--:--:--:  :  :  :  :
            I     I  I        I  I              I  I     I 
            :  :  :  :--:--:--:  :  :  :--:--:--:--:--:--:
            I  I     I        I     I  I     I        I  I 
            :--:--:  :--:  :--:  :--:  :  :  :  :--:  :  :
            I     I        I        I  I  I     I     I  I 
            :  :  :--:--:--:  :--:  :  :  :--:--:  :--:  :
            I  I              I     I  I  I     I  I     I 
            :  :--:--:--:--:--:--:  :  :  :  :--:  :--:  :
            I        I           I  I  I  I     I  I     I 
            :  :--:  :--:  :  :  :  :  :  :--:  :  :  :--:
            I  I     I     I  I  I  I  I     I  I  I  I  I 
            :  :  :--:  :--:  :  :  :  :--:  :  :  :  :  :
            I  I        I     I  I  I        I  I  I  I  I 
            :  :--:  :--:  :--:  :  :--:--:--:  :  :  :  :
            I     I     I  I  I  I  I     I        I     I 
            :--:  :--:  :  :  :  :--:  :  :  :--:--:  :--:
            I  I     I  I     I     I  I  I     I  I     I 
            :  :--:  :--:--:--:  :  :  :  :--:  :  :  :  :
            I     I     I     I  I  I  I     I  I  I  I  I 
            :  :  :--:  :  :  :--:  :  :--:  :  :  :  :  :
            I  I        I  I     I  I     I     I  I  I  I 
            :  :--:--:  :--:  :  :  :--:  :--:--:  :  :--:
            I  I     I        I  I     I     I     I     I 
            :  :  :--:--:--:--:  :  :--:  :  :  :--:--:  :
            I     I           I  I     I  I  I  I     I  I 
            :  :--:  :--:--:--:  :--:  :  :  :  :  :  :  :
            I  I                 I     I  I  I     I  I  I 
            :  :  :--:--:--:--:--:  :--:  :--:  :--:  :  :
            I  I  I  I           I     I     I  I     I  I 
            :  :  :  :  :--:  :  :--:  :--:  :  :  :--:  :
            I  I  I     I     I  I  I     I     I  I     I 
            :--:  :--:--:  :  :  :  :  :  :--:--:  :--:  :
            I     I        I  I  I  I  I  I     I        I 
            :  :--:  :--:--:  :  :  :  :  :--:  :  :--:--:
            I        I        I     I  I        I        I 
            :--:--:--:--:--:--:--:--:  :--:--:--:--:--:--:
            
            """.trimIndent()
        Amazing.random = Random(0)
        Amazing.doit(15, 20)
        Assertions.assertEquals(expected, Amazing.result.toString())
    }

    @Test
    fun testSeed100size4x5() {
        val expected = """
            Amazing - Copyright by Creative Computing, Morristown, NJ
            :--:--:  :--:
            I     I     I 
            :  :--:  :  :
            I  I     I  I 
            :  :  :--:  :
            I  I  I     I 
            :  :  :  :  :
            I  I  I  I  I 
            :  :--:  :  :
            I  I  I  I  I 
            :--:--:  :--:
            
            """.trimIndent()
        Amazing.random = Random(100)
        Amazing.doit(4, 5)
        Assertions.assertEquals(expected, Amazing.result.toString())
    }
}