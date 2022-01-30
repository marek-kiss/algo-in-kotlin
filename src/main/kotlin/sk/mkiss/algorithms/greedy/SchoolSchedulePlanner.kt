package sk.mkiss.algorithms.greedy

object SchoolSchedulePlanner {

    /**
     * Plan the school schedule that will include as many lectures as possible.
     *
     * @param lectures - list of events with a start and an end
     * @return list of selected lectures
     */
    fun planMaxLectures(lectures: List<Lecture>): List<Lecture> {
        if (lectures.isEmpty()) return emptyList()

        val sortedByEnd = lectures.sortedBy(Lecture::end)
        val plannedLectures = mutableListOf(sortedByEnd.first())

        sortedByEnd.forEach { lecture -> if (lecture.start >= plannedLectures.last().end) plannedLectures.add(lecture) }
        return plannedLectures
    }
}

data class Lecture(val start: Int, val end: Int) {
    init {
        require(start < end)
    }
}