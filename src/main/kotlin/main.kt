fun main() {
    println("был(а) ${agoToText(3600)}")
}

//function counts the time interval
fun agoToText(countSeconds: Int): String {
    val status = when (countSeconds) {
        in 0..60 -> "только что"
        in 61 until 60 * 60 -> "${(countSeconds / 60).toInt()} ${
            messageDuration(
                (countSeconds / 60).toInt(),
                "минуту", "минуты", "минут"
            )
        } назад"

        in 60 * 60 until 24 * 60 * 60 -> "${(countSeconds / 60 / 60).toInt()} ${
            messageDuration(
                (countSeconds / 60 / 60).toInt(),
                "час", "часа", "часов"
            )
        } назад"

        in 24 * 60 * 60 until 2 * 24 * 60 * 60 -> "вчера"
        in 2 * 24 * 60 * 60 until 3 * 24 * 60 * 60 -> "позавчера"
        else -> {
            "давно"
        }
    }
    return status
}

//function selects the correct message format for minuts
fun messageDuration(number: Int, one: String, two: String, five: String): String {
    return if (number in 5..20) {
        five
    } else {
        when (number % 10) {
            1 -> one
            in 2..4 -> two
            else -> {five}
        }
    }
}
