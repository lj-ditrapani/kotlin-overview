package overview01

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotNull
import kotlin.test.fail

fun headIs(list: Lst, value: Int): Lst =
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
    assertEquals(list4, Nil)
  }
}
