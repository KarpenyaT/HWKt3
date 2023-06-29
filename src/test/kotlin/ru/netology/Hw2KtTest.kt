package ru.netology

import org.junit.Test

import org.junit.Assert.*

class Hw2KtTest {


    @Test
    fun sumCommMas0() {
        val typePaySystem = "Mastercard"
        val sumTransfers = 70_358_00
        val transfer = 3_000_00
        val result = sumComm(typePaySystem, sumTransfers, transfer = transfer)

        assertEquals(0,result)
    }
    @Test
    fun sumCommMas() {
        val typePaySystem = "Mastercard"
        val sumTransfers = 75_358_00
        val transfer = 3_000_00
        val result = sumComm(typePaySystem, sumTransfers, transfer = transfer)

        assertEquals(38_00,result)
    }
    @Test
    fun sumCommMasOverLimit() {
        val typePaySystem = "Mastercard"
        val sumTransfers = 750_358_00
        val transfer = 3_000_00
        val result = sumComm(typePaySystem, sumTransfers, transfer = transfer)

        assertEquals(-1,result)
    }
    @Test
    fun sumCommMaes0() {
        val typePaySystem = "Maestro"
        val sumTransfers = 70_358_00
        val transfer = 3_000_00
        val result = sumComm(typePaySystem, sumTransfers, transfer = transfer)

        assertEquals(0,result)
    }
    @Test
    fun sumCommMaes() {
        val typePaySystem = "Maestro"
        val sumTransfers = 75_358_00
        val transfer = 3_000_00
        val result = sumComm(typePaySystem, sumTransfers, transfer = transfer)

        assertEquals(38_00,result)
    }
    @Test
    fun sumCommMaesOverLimit() {
        val typePaySystem = "Maestro"
        val sumTransfers = 750_358_00
        val transfer = 3_000_00
        val result = sumComm(typePaySystem, sumTransfers, transfer = transfer)

        assertEquals(-1,result)
    }
    @Test
    fun sumCommVisMin() {
        val typePaySystem = "Visa"
        val sumTransfers = 70_358_00
        val transfer = 3000_00
        val result = sumComm(typePaySystem, sumTransfers, transfer = transfer)

        assertEquals(35_00,result)
    }

    @Test
    fun sumCommVis() {
        val typePaySystem = "Visa"
        val sumTransfers = 69_358_00
        val transfer = 5000_00
        val result = sumComm(typePaySystem, sumTransfers, transfer = transfer)

        assertEquals(37_50,result)
    }
    @Test
    fun sumCommVisOverLimit() {
        val typePaySystem = "Visa"
        val sumTransfers = 69_358_00
        val transfer = 160_000_00
        val result = sumComm(typePaySystem, sumTransfers, transfer = transfer)

        assertEquals(-1,result)
    }
    @Test
    fun sumCommMirMin() {
        val typePaySystem = "Мир"
        val sumTransfers = 70_358_00
        val transfer = 3000_00
        val result = sumComm(typePaySystem, sumTransfers, transfer = transfer)

        assertEquals(35_00,result)
    }

    @Test
    fun sumCommMir() {
        val typePaySystem = "Мир"
        val sumTransfers = 69_358_00
        val transfer = 5000_00
        val result = sumComm(typePaySystem, sumTransfers, transfer = transfer)

        assertEquals(37_50,result)
    }
    @Test
    fun sumCommMirOverLimit() {
        val typePaySystem = "Мир"
        val sumTransfers = 69_358_00
        val transfer = 160_000_00
        val result = sumComm(typePaySystem, sumTransfers, transfer = transfer)

        assertEquals(-1,result)
    }
    @Test
    fun sumCommVkPay0() {
        val typePaySystem = "VK Pay"
        val sumTransfers = 10_358_00
        val transfer = 14000_00
        val result = sumComm(typePaySystem,sumTransfers,transfer = transfer)

        assertEquals(0,result)
    }
    @Test
    fun sumCommVkPayOverLimit() {
        val typePaySystem = "VK Pay"
        val sumTransfers = 39_358_00
        val transfer = 14000_00
        val result = sumComm(typePaySystem,sumTransfers,transfer = transfer)

        assertEquals(-1,result)
    }
    @Test
    fun sumCommVkPayDefault0() {
        val transfer = 14000_00
        val result = sumComm(transfer = transfer)

        assertEquals(0,result)
    }
    @Test
    fun sumCommVkPayDefault() {
        val transfer = 16000_00
        val result = sumComm(transfer = transfer)

        assertEquals(-1,result)
    }
    @Test
    fun sumCommOther() {
        val typePaySystem = "GooglePay"
        val sumTransfers = 69_358_00
        val transfer = 160_000_00
        val result = sumComm(typePaySystem, sumTransfers, transfer = transfer)

        assertEquals(-1,result)
    }
    @Test
    fun sumCommOther2() {
        val typePaySystem = ""
        val sumTransfers = 69_358_00
        val transfer = 160_000_00
        val result = sumComm(typePaySystem, sumTransfers, transfer = transfer)

        assertEquals(-1,result)
    }


}