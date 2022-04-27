import org.junit.Test

import org.junit.Assert.*

class SummaTest {

    @Test
    fun summa_default() {
        // arrange
        val choiceAmount = 2000

        // act
        val result = summa(
            amount = choiceAmount
        )

        // assert
        assertEquals(0, result)
    }

    @Test
    fun summa_VK_Pay_free() {
        // arrange
        val choiceCard = "VK Pay"
        val choicePreviousTransfer = 13000
        val choiceAmount = 2000

        // act
        val result = summa(
            card = choiceCard,
            previousTransfer = choicePreviousTransfer,
            amount = choiceAmount
        )

        // assert
        assertEquals(0, result)
    }

    @Test
    fun summa_VK_Pay_limit_1() {
        // arrange
        val choiceCard = "VK Pay"
        val choicePreviousTransfer = 0
        val choiceAmount = 20000

        // act
        val result = summa(
            card = choiceCard,
            previousTransfer = choicePreviousTransfer,
            amount = choiceAmount
        )

        // assert
        assertEquals(null, result)
    }

    @Test
    fun summa_VK_Pay_limit_2() {
        // arrange
        val choiceCard = "VK Pay"
        val choicePreviousTransfer = 40_000
        val choiceAmount = 1000

        // act
        val result = summa(
            card = choiceCard,
            previousTransfer = choicePreviousTransfer,
            amount = choiceAmount
        )

        // assert
        assertEquals(null, result)
    }

    @Test
    fun summa_Visa_minimum() {
        // arrange
        val choiceCard = "Visa"
        val choicePreviousTransfer = 133000
        val choiceAmount = 570

        // act
        val result = summa(
            card = choiceCard,
            previousTransfer = choicePreviousTransfer,
            amount = choiceAmount
        )

        // assert
        assertEquals(3500, result)
    }

    @Test
    fun summa_Visa_commission() {
        // arrange
        val choiceCard = "Visa"
        val choicePreviousTransfer = 53737
        val choiceAmount = 8935

        // act
        val result = summa(
            card = choiceCard,
            previousTransfer = choicePreviousTransfer,
            amount = choiceAmount
        )

        // assert
        assertEquals(6701, result)
    }

    @Test
    fun summa_Visa_free_1() {
        // arrange
        val choiceCard = "Visa"
        val choicePreviousTransfer = 590000
        val choiceAmount = 10000

        // act
        val result = summa(
            card = choiceCard,
            previousTransfer = choicePreviousTransfer,
            amount = choiceAmount
        )

        // assert
        assertEquals(0, result)
    }

    @Test
    fun summa_Visa_free_2() {
        // arrange
        val choiceCard = "Visa"
        val choicePreviousTransfer = 0
        val choiceAmount = 150000

        // act
        val result = summa(
            card = choiceCard,
            previousTransfer = choicePreviousTransfer,
            amount = choiceAmount
        )

        // assert
        assertEquals(0, result)
    }

    @Test
    fun summa_Visa_limit() {
        // arrange
        val choiceCard = "Visa"
        val choicePreviousTransfer = 53737
        val choiceAmount = 178935

        // act
        val result = summa(
            card = choiceCard,
            previousTransfer = choicePreviousTransfer,
            amount = choiceAmount
        )

        // assert
        assertEquals(null, result)
    }

    @Test
    fun summa_Mir_minimum() {
        // arrange
        val choiceCard = "Мир"
        val choicePreviousTransfer = 133000
        val choiceAmount = 1000

        // act
        val result = summa(
            card = choiceCard,
            previousTransfer = choicePreviousTransfer,
            amount = choiceAmount
        )

        // assert
        assertEquals(3500, result)
    }

    @Test
    fun summa_Mir_commission() {
        // arrange
        val choiceCard = "Мир"
        val choicePreviousTransfer = 66068
        val choiceAmount = 37669

        // act
        val result = summa(
            card = choiceCard,
            previousTransfer = choicePreviousTransfer,
            amount = choiceAmount
        )

        // assert
        assertEquals(28251, result)
    }

    @Test
    fun summa_Mir_free_1() {
        // arrange
        val choiceCard = "Мир"
        val choicePreviousTransfer = 590000
        val choiceAmount = 10000

        // act
        val result = summa(
            card = choiceCard,
            previousTransfer = choicePreviousTransfer,
            amount = choiceAmount
        )

        // assert
        assertEquals(0, result)
    }

    @Test
    fun summa_Mir_free_2() {
        // arrange
        val choiceCard = "Мир"
        val choicePreviousTransfer = 0
        val choiceAmount = 150000

        // act
        val result = summa(
            card = choiceCard,
            previousTransfer = choicePreviousTransfer,
            amount = choiceAmount
        )

        // assert
        assertEquals(0, result)
    }

    @Test
    fun summa_Mir_limit() {
        // arrange
        val choiceCard = "Мир"
        val choicePreviousTransfer = 53737
        val choiceAmount = 178935

        // act
        val result = summa(
            card = choiceCard,
            previousTransfer = choicePreviousTransfer,
            amount = choiceAmount
        )

        // assert
        assertEquals(null, result)
    }

    @Test
    fun summa_Mastercard_stock() {
        // arrange
        val choiceCard = "Mastercard"
        val choicePreviousTransfer = 10000
        val choiceAmount = 1000

        // act
        val result = summa(
            card = choiceCard,
            previousTransfer = choicePreviousTransfer,
            amount = choiceAmount
        )

        // assert
        assertEquals(0, result)
    }

    @Test
    fun summa_Mastercard_commission() {
        // arrange
        val choiceCard = "Mastercard"
        val choicePreviousTransfer = 135441
        val choiceAmount = 2111

        // act
        val result = summa(
            card = choiceCard,
            previousTransfer = choicePreviousTransfer,
            amount = choiceAmount
        )

        // assert
        assertEquals(3266, result)
    }

    @Test
    fun summa_Mastercard_fifty_fifty() {
        // arrange
        val choiceCard = "Mastercard"
        val choicePreviousTransfer = 74000
        val choiceAmount = 3000

        // act
        val result = summa(
            card = choiceCard,
            previousTransfer = choicePreviousTransfer,
            amount = choiceAmount
        )

        // assert
        assertEquals(3200, result)
    }

    @Test
    fun summa_Mastercard_free() {
        // arrange
        val choiceCard = "Mastercard"
        val choicePreviousTransfer = 520000
        val choiceAmount = 80000

        // act
        val result = summa(
            card = choiceCard,
            previousTransfer = choicePreviousTransfer,
            amount = choiceAmount
        )

        // assert
        assertEquals(0, result)
    }

    @Test
    fun summa_Mastercard_limit() {
        // arrange
        val choiceCard = "Mastercard"
        val choicePreviousTransfer = 599000
        val choiceAmount = 3000

        // act
        val result = summa(
            card = choiceCard,
            previousTransfer = choicePreviousTransfer,
            amount = choiceAmount
        )

        // assert
        assertEquals(null, result)
    }

    @Test
    fun summa_Maestro_stock() {
        // arrange
        val choiceCard = "Mastercard"
        val choicePreviousTransfer = 10000
        val choiceAmount = 1000

        // act
        val result = summa(
            card = choiceCard,
            previousTransfer = choicePreviousTransfer,
            amount = choiceAmount
        )

        // assert
        assertEquals(0, result)
    }

    @Test
    fun summa_Maestro_commission() {
        // arrange
        val choiceCard = "Mastercard"
        val choicePreviousTransfer = 115641
        val choiceAmount = 2135

        // act
        val result = summa(
            card = choiceCard,
            previousTransfer = choicePreviousTransfer,
            amount = choiceAmount
        )

        // assert
        assertEquals(3281, result)
    }

    @Test
    fun summa_Maestro_fifty_fifty() {
        // arrange
        val choiceCard = "Mastercard"
        val choicePreviousTransfer = 3000
        val choiceAmount = 80000

        // act
        val result = summa(
            card = choiceCard,
            previousTransfer = choicePreviousTransfer,
            amount = choiceAmount
        )

        // assert
        assertEquals(6800, result)
    }

    @Test
    fun summa_Maestro_free() {
        // arrange
        val choiceCard = "Mastercard"
        val choicePreviousTransfer = 520000
        val choiceAmount = 80000

        // act
        val result = summa(
            card = choiceCard,
            previousTransfer = choicePreviousTransfer,
            amount = choiceAmount
        )

        // assert
        assertEquals(0, result)
    }

    @Test
    fun summa_Maestro_limit() {
        // arrange
        val choiceCard = "Mastercard"
        val choicePreviousTransfer = 599000
        val choiceAmount = 3000

        // act
        val result = summa(
            card = choiceCard,
            previousTransfer = choicePreviousTransfer,
            amount = choiceAmount
        )

        // assert
        assertEquals(null, result)
    }

    @Test
    fun summa_null() {
        // arrange
        val choiceCard = "GPay"
        val choicePreviousTransfer = 7599000
        val choiceAmount = 3000

        // act
        val result = summa(
            card = choiceCard,
            previousTransfer = choicePreviousTransfer,
            amount = choiceAmount
        )

        // assert
        assertEquals(null, result)
    }
}