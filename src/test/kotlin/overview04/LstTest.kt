package overview04

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotNull
import kotlin.test.fail

fun <A> headIs(list: Lst<A>, value: A): Lst<A> =
  when(list) {
    is Cons -> {
      assertEquals(list.head, value)
      list.tail
    }
    is Nil -> {
      fail("Empty list")
    }
  }

class LstTest {
  @Test fun `Lst can be empty`() {
    assertNotNull(Nil, "list should not be null")
  }

  @Test fun `Lst can have elements`() {
    val list1 = Cons(1, Cons(2, Cons(3, Nil)))
    val list2 = headIs(list1, 1)
    val list3 = headIs(list2, 2)
    val list4 = headIs(list3, 3)
    assertEquals(Nil, list4)
  }

  @Test fun `reduce reduces`() {
    val list = Cons(2, Cons(3, Cons(4, Nil)))
    val sum1 = list.reduce(0) { a, b -> a + b }
    assertEquals(9, sum1)
    val sum2 = list.reduce(1) { a, b -> a * b }
    assertEquals(24, sum2)
  }

  @Test fun `works on list of chars`() {
    val list = Cons('k', Cons('o', Cons('t', Cons('l', Cons('i', Cons('n', Nil))))))
    assertEquals("kotlin", list.reduce("") { word, c -> word + c.toString() })
  }
}
