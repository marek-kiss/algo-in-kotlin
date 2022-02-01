package sk.mkiss.algorithms.greedy

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class JobSchedulerTest {

    @Test
    fun `should handle empty list`() {
        assertThat(JobScheduler.scheduleJobs(emptyList())).isEqualTo(JobScheduler.Result(emptyList(), 0))
    }

    @Test
    fun `should schedule as many jobs as it is possible to be processed before their deadlines`() {
        val result = JobScheduler.scheduleJobs(
            listOf(
                Job(id = 1, deadline = 3, penalty = 10_000),
                Job(id = 2, deadline = 3, penalty = 10_000),
                Job(id = 3, deadline = 3, penalty = 10_000),
                Job(id = 4, deadline = 3, penalty = 10_000),
                Job(id = 5, deadline = 3, penalty = 10_000)
            )
        )
        assertThat(result.scheduledJobs).hasSize(3)
        assertThat(result.penalty).isEqualTo(20_000)
    }

    @Test
    fun `should schedule job with higher penalty if there is time only for 1`() {
        assertThat(
            JobScheduler.scheduleJobs(
                listOf(
                    Job(id = 1, deadline = 1, penalty = 10_000),
                    Job(id = 2, deadline = 1, penalty = 20_000),
                    Job(id = 3, deadline = 1, penalty = 5_000)
                )
            )
        ).isEqualTo(
            JobScheduler.Result(
                scheduledJobs = listOf(2),
                penalty = 15_000
            )
        )
    }

    @Test
    fun `should schedule all jobs if the is enough time`() {
        assertThat(
            JobScheduler.scheduleJobs(
                listOf(
                    Job(id = 1, deadline = 3, penalty = 10_000),
                    Job(id = 2, deadline = 3, penalty = 20_000),
                    Job(id = 3, deadline = 3, penalty = 5_000)
                )
            )
        ).isEqualTo(
            JobScheduler.Result(
                scheduledJobs = listOf(3, 1, 2),
                penalty = 0
            )
        )
    }

    @Test
    fun `should schedule jobs to minimize penalty`() {
        assertThat(
            JobScheduler.scheduleJobs(
                listOf(
                    Job(id = 1, deadline = 2, penalty = 10_000),
                    Job(id = 2, deadline = 1, penalty = 10),
                    Job(id = 3, deadline = 2, penalty = 11_000),
                    Job(id = 4, deadline = 4, penalty = 8_000),
                    Job(id = 5, deadline = 2, penalty = 7_000)
                )
            )
        ).isEqualTo(
            JobScheduler.Result(
                scheduledJobs = listOf(1, 3, 4),
                penalty = 7_010
            )
        )
    }
}