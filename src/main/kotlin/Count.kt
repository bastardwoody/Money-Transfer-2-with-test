const val TO_CENT = 100.00
const val MASTERCARD_AND_MAESTRO_COMMISSION_06 = 0.6
const val MASTERCARD_AND_MAESTRO_COMMISSION_20 = 20
const val MASTERCARD_AND_MAESTRO_LIMIT_STOCK = 75_000
const val VISA_AND_MIR_COMMISSION = 0.75
const val VISA_AND_MIR_COMMISSION_MINIMUM = 35
const val MAX_LIMIT_DAY = 150_000
const val MAX_LIMIT_MONTH = 600_000
const val MAX_LIMIT_VK_DAY = 15_000
const val MAX_LIMIT_VK_MONTH = 40_000
val card = listOf("VK Pay", "Мир", "Visa", "Mastercard", "Maestro").random()
val previousTransfer = (0..160_000).random()
val amount = (0..200_000).random()
val summa = summa(card, previousTransfer, amount)

fun main() {
    if (summa != null) {
        print(
            "Карта: $card \n" +
                    "Сумма перевода: $amount \n" +
                    "Комиссия: ${summa.toInt()} \n" +
                    "Общая сумма переводов за месяц: $previousTransfer")
    } else {
        print("Невозможно совершить перевод. Превышен лимит")
    }
}

fun summa(
    card: String = "VK Pay",
    previousTransfer: Int = 0,
    amount: Int
): Double? {
    return when {
        card == "VK Pay" &&
                amount <= MAX_LIMIT_VK_DAY &&
                amount <= MAX_LIMIT_VK_MONTH - previousTransfer
        -> 0.0

        (card == "Мир" || card == "Visa") &&
                amount < MAX_LIMIT_DAY &&
                amount < MAX_LIMIT_MONTH - previousTransfer &&
                amount * VISA_AND_MIR_COMMISSION / 100 <= VISA_AND_MIR_COMMISSION_MINIMUM
        -> VISA_AND_MIR_COMMISSION_MINIMUM * TO_CENT

        (card == "Мир" || card == "Visa") &&
                amount < MAX_LIMIT_DAY &&
                amount < MAX_LIMIT_MONTH - previousTransfer &&
                amount * VISA_AND_MIR_COMMISSION / 100 > VISA_AND_MIR_COMMISSION_MINIMUM
        -> (amount * VISA_AND_MIR_COMMISSION / 100) * TO_CENT

        (card == "Мир" || card == "Visa") &&
                (amount == MAX_LIMIT_DAY || amount == MAX_LIMIT_MONTH - previousTransfer) &&
                amount <= MAX_LIMIT_MONTH - previousTransfer
        -> 0.0

        (card == "Mastercard" || card == "Maestro") &&
                amount < MAX_LIMIT_DAY &&
                amount < MAX_LIMIT_MONTH - previousTransfer &&
                amount > (MASTERCARD_AND_MAESTRO_LIMIT_STOCK - previousTransfer)
        -> (((amount - (MASTERCARD_AND_MAESTRO_LIMIT_STOCK - previousTransfer)) * MASTERCARD_AND_MAESTRO_COMMISSION_06 / 100) + MASTERCARD_AND_MAESTRO_COMMISSION_20) * TO_CENT

        (card == "Mastercard" || card == "Maestro") &&
                amount == MAX_LIMIT_DAY ||
                amount == MAX_LIMIT_DAY - previousTransfer ||
                amount <= MAX_LIMIT_MONTH - previousTransfer &&
                amount <= MASTERCARD_AND_MAESTRO_LIMIT_STOCK
        -> 0.0
        else -> null
    }
}