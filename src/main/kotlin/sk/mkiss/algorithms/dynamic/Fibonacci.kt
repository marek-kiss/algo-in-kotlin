package sk.mkiss.algorithms.dynamic

import java.math.BigDecimal

object Fibonacci {

    fun getNumber(i: Int): BigDecimal {
        require(i >= 0)

        if (i == 0) return BigDecimal.ZERO
        if (i == 1) return BigDecimal.ONE

        var fn1 = BigDecimal.ZERO
        var fn2 = BigDecimal.ONE

        repeat(i - 2) {
            val fn = fn1 + fn2
            fn1 = fn2
            fn2 = fn
        }

        return fn1 + fn2
    }
}