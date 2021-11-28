package sk.mkiss.algorithms.sort

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class CountSortTest {

    private val people = arrayOf(
        Person(18, "Ben"),
        Person(20, "Alica"),
        Person(30, "Ema"),
        Person(20, "Anna"),
        Person(18, "Tom"),
        Person(18, "Ben")
    )

    @Test
    fun `should handle empty array`() {
        assertThat(CountingSort.sortBy(emptyArray<Person>(), Person::age)).isEqualTo(
            emptyArray<Person>()
        )
    }

    @Test
    fun `should sort bjects with duplicates by number`() {

        val result = CountingSort.sortBy(array = people, selector = Person::age)

        assertThat(result).isEqualTo(
            arrayOf(
                Person(18, "Ben"),
                Person(18, "Tom"),
                Person(18, "Ben"),
                Person(20, "Alica"),
                Person(20, "Anna"),
                Person(30, "Ema")
            )
        )
    }

    @Test
    fun `should sort objects with duplicates by text`() {

        val result = CountingSort.sortBy(array = people, selector = Person::name)

        assertThat(result).isEqualTo(
            arrayOf(
                Person(20, "Alica"),
                Person(20, "Anna"),
                Person(18, "Ben"),
                Person(18, "Ben"),
                Person(30, "Ema"),
                Person(18, "Tom")
            )
        )
    }

    data class Person(val age: Int, val name: String) : Comparable<Person> {
        override fun compareTo(other: Person) = compareValues(age, other.age)
    }
}