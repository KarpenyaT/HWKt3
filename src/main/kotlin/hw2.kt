

fun main() {
    val typePaySystem = "Mir"
    val sumTransfers = 580_358_00
    val transfer = 3000_00
    val comm = sumComm(typePaySystem, sumTransfers, transfer = transfer)
    if (comm == -1) {
        println("Отмена перевода. Превышен лимит или платежная система не доступна")
    } else {
        println(
            "Комиссия за перевод составляет ${(comm / 100)} руб"
        )
    }
}

//function calculates the commission for transfer, amounts in kopecks
fun sumComm(typePaySystem: String = "VK Pay", sumTransfers: Int = 0, transfer: Int): Int {
    return when (typePaySystem) {
        "Mastercard", "Maestro" -> calcSumCommMscMaes(sumTransfers, transfer)
        "Visa", "Mir" -> calcSumCommVisMir(sumTransfers, transfer)
        "VK Pay" -> calcSumCommVKPay(sumTransfers, transfer)
        else -> {
            -1
        }
    }
}

fun calcSumCommMscMaes(sumTransfers: Int, transfer: Int): Int {
    val commMasMaes = 0.006
    val commMasMaesPlus = 20_00
    val maxDayCard = 150_000_00
    val maxMonthCard = 600_000_00
    val maxSumTransfersCommLess = 75_000_00
    return if (!checkLimitTransfers(sumTransfers, transfer, maxMonthCard, maxDayCard)) {
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
    return if (!checkLimitTransfers(sumTransfers, transfer, maxMonthCard, maxDayCard)) {
        -1
    } else {
        if (transfer * commVisMir < minCommVisMirMin) minCommVisMirMin else (transfer * commVisMir).toInt()
    }
}

fun calcSumCommVKPay(sumTransfers: Int, transfer: Int): Int {
    val maxDayVK = 15_000_00
    val maxMonthVK = 40_000_00
    return if (checkLimitTransfers(sumTransfers, transfer, maxMonthVK, maxDayVK)) 0 else -1
}

fun checkLimitTransfers(sumTransfers: Int, transfer: Int, maxMonth: Int, maxDay: Int): Boolean {
    return sumTransfers + transfer <= maxMonth && transfer <= maxDay
}