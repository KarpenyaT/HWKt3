import org.junit.Test

import org.junit.Assert.*

class Hw2KtTest {

    @Test
    fun sumCommVkPayDefault0() {
        val transfer = 14000_00
        val result = sumComm(transfer = transfer)

        assertEquals(-1, result)
    }
    @Test
    fun sumCommVkPayDefaultLimit() {
        val transfer = 16000_00
        val result = sumComm(transfer = transfer)

        assertEquals(-1, result)
    }
    @Test
    fun sumCommMas0() {
        val typePaySystem = "Mastercard"
        val sumTransfers = 70_358_00
        val transfer = 3_000_00
        val result = sumComm(typePaySystem, sumTransfers, transfer = transfer)

        assertEquals(0, result)
    }
    @Test
    fun sumCommMas() {
        val typePaySystem = "Mastercard"
        val sumTransfers = 75_358_00
        val transfer = 3_000_00
        val result = sumComm(typePaySystem, sumTransfers, transfer = transfer)

        assertEquals(38_00, result)
    }
    @Test
    fun sumCommMasLimitDay() {
        val typePaySystem = "Mastercard"
        val sumTransfers = 75_358_00
        val transfer = 152_000_00
        val result = sumComm(typePaySystem, sumTransfers, transfer = transfer)

        assertEquals(-1, result)
    }
    @Test
    fun sumCommMasLimitMonth() {
        val typePaySystem = "Mastercard"
        val sumTransfers = 575_358_00
        val transfer = 35_000_00
        val result = sumComm(typePaySystem, sumTransfers, transfer = transfer)

        assertEquals(-1, result)
    }
    @Test
    fun sumCommMaes0() {
        val typePaySystem = "Maestro"
        val sumTransfers = 70_358_00
        val transfer = 3_000_00
        val result = sumComm(typePaySystem, sumTransfers, transfer = transfer)

        assertEquals(0, result)
    }
    @Test
    fun sumCommMaes() {
        val typePaySystem = "Maestro"
        val sumTransfers = 75_358_00
        val transfer = 3_000_00
        val result = sumComm(typePaySystem, sumTransfers, transfer = transfer)

        assertEquals(38_00, result)
    }
    @Test
    fun sumCommMaesLimitDay() {
        val typePaySystem = "Maestro"
        val sumTransfers = 75_358_00
        val transfer = 152_000_00
        val result = sumComm(typePaySystem, sumTransfers, transfer = transfer)

        assertEquals(-1, result)
    }
    @Test
    fun sumCommMaesLimitMonth() {
        val typePaySystem = "Maestro"
        val sumTransfers = 575_358_00
        val transfer = 35_000_00
        val result = sumComm(typePaySystem, sumTransfers, transfer = transfer)

        assertEquals(-1, result)
    }
    @Test
    fun sumCommVisMin() {
        val typePaySystem = "Visa"
        val sumTransfers = 70_358_00
        val transfer = 3000_00
        val result = sumComm(typePaySystem, sumTransfers, transfer = transfer)

        assertEquals(35_00, result)
    }
    @Test
    fun sumCommVis() {
        val typePaySystem = "Visa"
        val sumTransfers = 69_358_00
        val transfer = 5000_00
        val result = sumComm(typePaySystem, sumTransfers, transfer = transfer)

        assertEquals(37_50, result)
    }
    @Test
    fun sumCommVisaLimitDay() {
        val typePaySystem = "Visa"
        val sumTransfers = 75_358_00
        val transfer = 152_000_00
        val result = sumComm(typePaySystem, sumTransfers, transfer = transfer)

        assertEquals(-1, result)
    }
    @Test
    fun sumCommVisaLimitMonth() {
        val typePaySystem = "Visa"
        val sumTransfers = 575_358_00
        val transfer = 35_000_00
        val result = sumComm(typePaySystem, sumTransfers, transfer = transfer)

        assertEquals(-1, result)
    }
    @Test
    fun sumCommMirMin() {
        val typePaySystem = "Mir"
        val sumTransfers = 70_358_00
        val transfer = 3000_00
        val result = sumComm(typePaySystem, sumTransfers, transfer = transfer)

        assertEquals(35_00, result)
    }
    @Test
    fun sumCommMir() {
        val typePaySystem = "Mir"
        val sumTransfers = 69_358_00
        val transfer = 5000_00
        val result = sumComm(typePaySystem, sumTransfers, transfer = transfer)

        assertEquals(37_50, result)
    }
    @Test
    fun sumCommMirLimitDay() {
        val typePaySystem = "Mir"
        val sumTransfers = 75_358_00
        val transfer = 152_000_00
        val result = sumComm(typePaySystem, sumTransfers, transfer = transfer)

        assertEquals(-1, result)
    }
    @Test
    fun sumCommMirLimitMonth() {
        val typePaySystem = "Mir"
        val sumTransfers = 575_358_00
        val transfer = 35_000_00
        val result = sumComm(typePaySystem, sumTransfers, transfer = transfer)

        assertEquals(-1, result)
    }
    @Test
    fun sumCommVkPay0() {
        val typePaySystem = "VK Pay"
        val sumTransfers = 10_358_00
        val transfer = 14000_00
        val result = sumComm(typePaySystem, sumTransfers, transfer = transfer)

        assertEquals(0, result)
    }
    @Test
    fun sumCommVkLimitDay() {
        val typePaySystem = "VK Pay"
        val sumTransfers = 15_358_00
        val transfer = 16_000_00
        val result = sumComm(typePaySystem, sumTransfers, transfer = transfer)

        assertEquals(-1, result)
    }
    @Test
    fun sumCommVKLimitMonth() {
        val typePaySystem = "VK Pay"
        val sumTransfers = 35_358_00
        val transfer = 10_000_00
        val result = sumComm(typePaySystem, sumTransfers, transfer = transfer)

        assertEquals(-1, result)
    }
    @Test
    fun sumCommOther() {
        val typePaySystem = "GooglePay"
        val sumTransfers = 69_358_00
        val transfer = 160_000_00
        val result = sumComm(typePaySystem, sumTransfers, transfer = transfer)

        assertEquals(-1, result)
    }
}