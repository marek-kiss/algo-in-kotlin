package sk.mkiss.algorithms.greedy

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class SchoolSchedulePlannerTest {

    @Test
    fun `should handle empty list of lectures`() {
        assertThat(SchoolSchedulePlanner.planMaxLectures(emptyList())).isEmpty()
    }

    @Test
    fun `should select all lectures if there is no overlap`() {
        val lectures = listOf(Lecture(7, 9), Lecture(9, 11), Lecture(15, 16))

        assertThat(SchoolSchedulePlanner.planMaxLectures(lectures)).hasSameElementsAs(lectures)
    }

    @Test
    fun `should select the max number of lectures`() {
        val lectures = listOf(Lecture(7, 13), Lecture(8, 9), Lecture(9, 10), Lecture(9, 12), Lecture(10, 12))

        assertThat(SchoolSchedulePlanner.planMaxLectures(lectures))
            .containsExactly(Lecture(8, 9), Lecture(9, 10), Lecture(10, 12))
    }
}