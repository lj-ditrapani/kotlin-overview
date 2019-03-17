package overview04

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotNull
import kotlin.test.fail

fun headIs(list: Lst<Int>, value: Int): Lst<Int> =
when (list) {
    is Cons -> {
        assertEquals(list.head, value)
        list.tail
    }
    is Nil -> {
        fail("Empty list")
    }
}

class LstTest {
    @Test fun `can be empty`() {
        assertNotNull(Nil, "list should not be null")
    }

    @Test fun `can have elements`() {
        val list1 = newLst(1, 2, 3)
        val list2 = headIs(list1, 1)
        val list3 = headIs(list2, 2)
        val list4 = headIs(list3, 3)
        assertEquals(Nil, list4)
    }

    class ` on map` {
        @Test fun `returns an empty list given an empty list`() {
            val empty: Lst<Int> = Nil
            assertEquals(Nil, empty.map { it + 5 })
        }

        @Test fun `applies given function to each element in the list`() {
            val list = newLst(1, 2, 3).map { it * 2 }
            assertEquals(3, list.size())
            assertEquals("Lst( 2 4 6 )", list.asString())
        }
    }

    class ` on Reduce` {
        @Test fun `reduces with +`() {
            val list = newLst(2, 3, 4)
            val sum = list.reduce(0) { a, b -> a + b }
            assertEquals(9, sum)
        }

        @Test fun `reduces with *`() {
            val list = newLst(2, 3, 4)
            val prod = list.reduce(1) { a, b -> a * b }
            assertEquals(24, prod)
        }

        @Test fun `reduces to a string`() {
            val list = newLst(1, 2, 3)
            val str = list.reduce("", { a, b -> a + b.toString() })
            assertEquals("123", str)
        }
    }

    @Test fun `size returns size of list`() {
        val list = newLst(4, 5, 6)
        assertEquals(3, list.size())
    }

    class ` on AsString` {
        @Test fun `returns a string representation of the list`() {
            val list = newLst(1, 2, 3)
            assertEquals("Lst( 1 2 3 )", list.asString())
        }

        @Test fun `returns a string representation of the empty list`() {
            assertEquals("Lst( )", Nil.asString())
        }
    }

    @Test fun `works on list of chars`() {
        val list = newLst('k', 'o', 't', 'l', 'i', 'n')
        assertEquals("kotlin", list.reduce("") { word, c -> word + c.toString() })
        assertEquals(6, list.size())
        assertEquals("Lst( n i l t o k )", list.reverse().asString())
        assertEquals("Lst( 11 15 20 12 9 14 )", list.map { it.toInt() - 96 }.asString())
    }
}
