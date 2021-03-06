package com.padovese.assessment.exception


class NegativeArgException(arg: String, value: Int) : RuntimeException() {
    override val message: String? = "The requesting $arg is $value. It must not be negative."
}