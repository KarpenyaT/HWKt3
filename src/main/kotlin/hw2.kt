fun main() {
    val typePaySystem = "Мир"
    var sumTransfers = 580_358
    val transfer = 3000
    val comm = sumComm(typePaySystem,sumTransfers,transfer=transfer * 100)
    if (comm == -1) {
        println("Отмена перевода. Превышен лимит")
    } else {
        println("Комиссия за перевод составляет " +
                "${(comm/100).toInt()} руб"
        )
    }
}

//function calculates the commission for transfer, amounts in kopecks
fun sumComm(typePaySystem: String = "VK Pay", sumTransfers: Int = 0, transfer: Int): Int {
    return when (typePaySystem) {
        "Mastercard", "Maestro" -> calcSumCommMscMaes(sumTransfers, transfer)
        "Visa", "Мир" -> calcSumCommVisMir(sumTransfers, transfer)
        "VK Pay" -> calcSumCommVKPay(sumTransfers,transfer)
        else -> {0}
    }
}

fun calcSumCommMscMaes(sumTransfers: Int, transfer: Int): Int {
    val commMasMaes = 0.006
    val commMasMaesPlus = 20_00
    val maxDayCard = 150_000_00
    val maxMonthCard = 600_000_00
    val maxSumTransfersCommLess = 75_000_00
    return if (checkLimitTransfers(sumTransfers, transfer, maxMonthCard, maxDayCard)) {
        -1
    } else {
        if (sumTransfers < maxSumTransfersCommLess) 0 else (transfer * commMasMaes + commMasMaesPlus).toInt()
    }
}

fun calcSumCommVisMir(sumTransfers: Int, transfer: Int): Int {
    val commVisMir = 0.0075
    val minCommVisMirMin = 35_00
    val maxDayCard = 150_000_00
    val maxMonthCard = 600_000_00
    return if (checkLimitTransfers(sumTransfers, transfer, maxMonthCard, maxDayCard)) {
        -1
    } else {
        if (transfer * commVisMir < minCommVisMirMin) minCommVisMirMin else (transfer * commVisMir).toInt()
    }
}

fun calcSumCommVKPay(sumTransfers: Int, transfer: Int): Int {
    val maxDayVK = 15_000_00
    val maxMonthVK = 40_000_00
    return if (checkLimitTransfers(sumTransfers, transfer, maxMonthVK, maxDayVK)) -1 else 0
}

fun checkLimitTransfers(sumTransfers: Int, transfer: Int, maxMonth: Int, maxDay: Int): Boolean {
    return sumTransfers + transfer > maxMonth || transfer > maxDay
}