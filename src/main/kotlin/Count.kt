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
val previousTransfer = (0..600000).random()
val amount = (0..150000).random()
val summa = summa(card, previousTransfer, amount)

fun main() {
    if (summa != null) {
        print(
            "Карта: $card\n" +
                    "Сумма перевода: $amount руб.\n" +
                    "Комиссия: $summa коп.\n" +
                    "Общая сумма переводов за месяц: $previousTransfer руб."
        )
    } else {
        print(
            "Невозможно совершить перевод. Превышен лимит\n" +
                    "Карта: $card\n" +
                    "Сумма перевода: $amount руб.\n" +
                    "Общая сумма переводов за месяц: $previousTransfer руб."
        )
    }
}

fun summa(
    card: String = "VK Pay",
    previousTransfer: Int = 0,
    amount: Int
): Int? {
    return when (card) {
        "VK Pay" ->
            if (MAX_LIMIT_VK_DAY >= amount && MAX_LIMIT_VK_MONTH >= amount + previousTransfer) {
                0
            } else {
                null
            }
        "Visa", "Мир" ->
            if (amount < MAX_LIMIT_DAY && MAX_LIMIT_MONTH > amount + previousTransfer) {
                if (amount * VISA_AND_MIR_COMMISSION / 100 <= VISA_AND_MIR_COMMISSION_MINIMUM) {
                    (VISA_AND_MIR_COMMISSION_MINIMUM * TO_CENT).toInt()
                } else {
                    ((amount * VISA_AND_MIR_COMMISSION / 100) * TO_CENT).toInt()
                }
            } else if ((amount == MAX_LIMIT_DAY && MAX_LIMIT_MONTH >= amount + previousTransfer) ||
                (MAX_LIMIT_MONTH == amount + previousTransfer)) {
                0
            } else {
                null
            }
        "Mastercard", "Maestro" ->
            if (amount < MAX_LIMIT_DAY && MAX_LIMIT_MONTH > amount + previousTransfer) {
                if (MASTERCARD_AND_MAESTRO_LIMIT_STOCK >= previousTransfer) {
                    if (MASTERCARD_AND_MAESTRO_LIMIT_STOCK < amount + previousTransfer) {
                    ((((amount - (MASTERCARD_AND_MAESTRO_LIMIT_STOCK - previousTransfer)) *
                            MASTERCARD_AND_MAESTRO_COMMISSION_06 / 100) +
                            MASTERCARD_AND_MAESTRO_COMMISSION_20) * TO_CENT).toInt()
                    } else {
                        0
                    }
                } else {
                    (((amount * MASTERCARD_AND_MAESTRO_COMMISSION_06 / 100) +
                            MASTERCARD_AND_MAESTRO_COMMISSION_20) * TO_CENT).toInt()
                }
            } else if ((amount == MAX_LIMIT_DAY && MAX_LIMIT_MONTH >= amount + previousTransfer) ||
                (MAX_LIMIT_MONTH == amount + previousTransfer)) {
                0
            } else {
                null
            }
        else -> {null}
    }
}