package com.padovese.assessment.exception


class NegativeArgException(arg: String, value: Long) : RuntimeException() {
    override val message: String? = "The requesting $arg is $value. It must not be negative."
}