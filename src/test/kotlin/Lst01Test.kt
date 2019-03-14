package overview01

import kotlin.test.Test
import kotlin.test.assertNotNull

class AppTest {
    @Test fun testLstCanBeEmpty() {
            assertNotNull(Nil, "list should not be null")
    }
}
