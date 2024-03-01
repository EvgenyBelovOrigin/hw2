package ru.netology

fun main() {
    agoToText(300)
}

fun agoToText(agoTimeSeconds: Int) {
    when {
        agoTimeSeconds <= 60 -> println("был(а) только что")
        agoTimeSeconds < 60 * 60 ->
            println("был(а) ${agoTimeSeconds / 60} ${minutesToPhrase(agoTimeSeconds / 60)} назад")

        agoTimeSeconds < 24 * 60 * 60 ->
            println("был(а) ${agoTimeSeconds / 60 / 60} ${hoursToPhrase(agoTimeSeconds / 60 / 60)} назад")

        agoTimeSeconds < 48 * 60 * 60 -> println("был(а) вчера")
        agoTimeSeconds < 72 * 60 * 60 -> println("был(а) позавчера")
        else -> println("был(а) давно")
    }
}

fun minutesToPhrase(agoTimeMinutes: Int): String {

    return when {
        agoTimeMinutes in 11..14 -> "минут"
        agoTimeMinutes % 10 == 1 -> "минуту"
        agoTimeMinutes % 10 in 2..4 -> "минуты"
        else -> "минут"
    }
}

fun hoursToPhrase(agoTimeHours: Int): String {
    return when (agoTimeHours) {
        1, 21 -> "час"
        2, 3, 4, 22, 23, 24 -> "часа"
        else -> "часов"
    }

}





