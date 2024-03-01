package ru.netology

import kotlin.math.round

fun main() {
    var transferResult = transfer(transferAmount = 145_555_00, cardType = "Mastercard")
    println(transferResult)
}

fun transfer(cardType: String = "Мир", thisMonthTransferredAmount: Int = 0, transferAmount: Int): String {
    val dayLimit = 150_000_00 //копейки
    val monthLimit = 600_000_00
    if (transferAmount > dayLimit) return "Превыышен дневной лимит перевода, перевод заблокирован"
    if (transferAmount + thisMonthTransferredAmount > monthLimit)
        return "Превышен месячный лимит перевода, перевод заблокирован"
    val mastercardMonthLimit = 75_000_00
    val mastercardMonthTransferredAmount = 0
    val mastercardExtraFeePercent = 0.006
    val mastercardExtraFeeConst = 20_00
    val visaFee = 0.0075
    val visaMinFee = 35_00
    val mirFee = 0.0

    var feeResult: Double = 0.0

    when (cardType) {
        "Mastercard" -> feeResult =
            if (transferAmount + mastercardMonthTransferredAmount > mastercardMonthLimit)
                ((transferAmount - mastercardMonthLimit) * mastercardExtraFeePercent + mastercardExtraFeeConst)
            else 0.0

        "Visa" -> feeResult =
            if (transferAmount * visaFee > visaMinFee)
                transferAmount * visaFee
            else (visaMinFee.toDouble())

        "Мир" -> feeResult = mirFee * transferAmount

        else -> return "Неизвестная платежная система, перевод заблокирован"

    }
    return "Комиссия за перевод: ${round(feeResult) / 100} руб."

}