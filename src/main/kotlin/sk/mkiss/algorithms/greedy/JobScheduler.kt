package sk.mkiss.algorithms.greedy

import java.util.*
import java.util.Comparator.comparingInt
import java.util.Comparator.reverseOrder

object JobScheduler {

    private val EMPTY_RESULT = Result(emptyList(), 0)

    /**
     * Schedule jobs for execution to minimize the penalty for missed jobs.
     * Each job has a deadline and a penalty for not being executed before the deadline.
     *
     * @param List of jobs to be scheduled
     * @return Result with an ordered list of scheduled Job Ids and the total penalty for unscheduled jobs.
     */
    fun scheduleJobs(jobs: List<Job>): Result {
        if (jobs.isEmpty()) return EMPTY_RESULT

        val priorityQueue = PriorityQueue(comparingInt(Job::penalty).reversed())

        val scheduledJobs = mutableListOf<JobId>()
        var totalPenalty = 0L

        val jobsByDeadline = jobs.groupBy { it.deadline }.toSortedMap(reverseOrder())
        val lastDeadline = jobsByDeadline.firstKey()!!

        (lastDeadline downTo 1).forEach { timePoint ->
            jobsByDeadline[timePoint]?.let { priorityQueue.addAll(it) }

            val jobWithTopPriority = priorityQueue.poll()
            jobWithTopPriority?.let { scheduledJobs.add(it.id) }
        }

        totalPenalty += priorityQueue.sumOf { missedJob -> missedJob.penalty }
        return Result(scheduledJobs = scheduledJobs.reversed(), penalty = totalPenalty)
    }

    data class Result(
        val scheduledJobs: List<JobId>,
        val penalty: Long
    )
}

data class Job(
    val id: JobId,
    val deadline: Int,
    val penalty: Int
)

typealias JobId = Int