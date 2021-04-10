import org.approvaltests.legacycode.LegacyApprovals
import org.approvaltests.legacycode.Range
import org.junit.jupiter.api.Test
import java.util.*


class NonRegressionMethodTest {

    @Test
    fun non_reg_rnd(){
        LegacyApprovals.LockDown(this, "runRnd", Range.get(0, 50), Range.get(-1000, 1000))}


    fun runRnd(random : Int?, count : Int?): Int {
        Amazing.random = Random(random!!.toLong())
        return Amazing.rand(count!!)
    }

}