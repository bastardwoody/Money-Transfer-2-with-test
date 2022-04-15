const val CENT = 100.00
const val MINIMUM = 35.00
const val PERCENT = 0.75

fun main() {
    print("Введите сумму перевода: ")
    val amount = readLine()?.toLong() ?: return
    if (amount < MINIMUM) {
        print("Минимальная сумма перевода 35 рублей")
    } else {
        val summa = (amount * CENT) * PERCENT / 100
        print("Перевод на сумму $amount выполнен. Комиссия составила: ${summa.toInt()} коп.")
    }
}