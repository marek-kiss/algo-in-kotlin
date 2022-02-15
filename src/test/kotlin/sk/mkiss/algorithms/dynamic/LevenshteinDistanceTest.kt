package sk.mkiss.algorithms.dynamic

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class LevenshteinDistanceTest {

    @Test
    fun `should return zero for equal texts`() {
        assertThat(LevenshteinDistance.distance("abc", "abc")).isEqualTo(0)
    }

    @Test
    fun `should return zero if both texts are empty`() {
        assertThat(LevenshteinDistance.distance("", "")).isEqualTo(0)
    }

    @ParameterizedTest(name = "levenshtein distance between {0} and {1} is {2}")
    @MethodSource("getTestData")
    fun `should correctly calculate the distance`(word1: String, word2: String, expectedDistance: Int) {
        assertThat(LevenshteinDistance.distance(word1, word2)).isEqualTo(expectedDistance)
    }

    companion object {
        @JvmStatic
        fun getTestData(): List<Arguments> {
            return listOf(
                Arguments.of("abcdef", "abcd", 2),
                Arguments.of("abcdef", "bcde", 2),
                Arguments.of("abcdef", "ababcdcd", 4),
                Arguments.of("xabcy", "yabcx", 2),
                Arguments.of("abc", "", 3),
                Arguments.of("", "abcd", 4),
                Arguments.of("1234567","7654321", 6),
                Arguments.of("123456","654321", 6)
            )
        }
    }
}