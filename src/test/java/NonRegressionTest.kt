import org.approvaltests.Approvals
import org.approvaltests.legacycode.LegacyApprovals
import org.approvaltests.legacycode.Range
import org.junit.jupiter.api.Test
import java.util.*


class NonRegressionTest {

    @Test
    fun random_100_horizontal4_vertical_5() {
        Amazing.random = Random(100)
        Amazing.doit(4, 5)

        Approvals.verify(Amazing.result.toString())
    }

    @Test
    fun random_200_horizontal4_vertical_5() {
        Amazing.random = Random(200)
        Amazing.doit(4, 5)

        Approvals.verify(Amazing.result.toString())
    }

    @Test
    fun random_100_horizontal40_vertical_50() {
        Amazing.random = Random(100)
        Amazing.doit(40, 50)

        Approvals.verify(Amazing.result.toString())
    }

    @Test
    fun random_10_horizontal40_vertical_50() {
        Amazing.random = Random(10)
        Amazing.doit(40, 50)

        Approvals.verify(Amazing.result.toString())
    }

    @Test
    fun random_99_horizontal40_vertical_30() {
        Amazing.random = Random(99)
        Amazing.doit(40, 30)

        Approvals.verify(Amazing.result.toString())
    }

    @Test
    fun random_101_horizontal40_vertical_40() {
        Amazing.random = Random(101)
        Amazing.doit(40, 40)

        Approvals.verify(Amazing.result.toString())
    }

    @Test
    fun non_reg_with_legacy(){
        LegacyApprovals.LockDown(this, "runAmazing", Range.get(0, 5), Array(10) { it * 7 }, Array(10) { it * 7 })
    }

    @Test
    fun non_reg_with_legacy_random(){
        LegacyApprovals.LockDown(this, "runAmazing", Range.get(999, 1049), Array(5) { it * 4 + 40 }, Array(5) { it * 4 + 40 })
    }

    @Test
    fun non_reg_with_legacy_small_maze(){
        LegacyApprovals.LockDown(this, "runAmazing", Range.get(50, 100), Range.get(-1, 10), Range.get(-1, 10))
    }

    @Test
    fun non_reg_with_legacy_big_maze(){
        LegacyApprovals.LockDown(this, "runAmazing", Range.get(100, 102), Array(15) { it * 3 + 50 }, Array(15) { it * 3 + 50 })
    }

    @Test
    fun non_reg_with_legacy_horizontal(){
        LegacyApprovals.LockDown(this, "runAmazing", Range.get(150, 155), Range.get(60, 100), Range.get(0, 10))
    }

    @Test
    fun non_reg_with_legacy_vertical(){
        LegacyApprovals.LockDown(this, "runAmazing", Range.get(200, 205), Range.get(0, 10), Range.get(60, 100))
    }

    fun runAmazing(random : Int?, horizontal : Int?,  vertical : Int?): String {
        Amazing.random = Random(random!!.toLong())
        Amazing.doit(horizontal!!, vertical!!)

        return Amazing.result.toString()

    }

}