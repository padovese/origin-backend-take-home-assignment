package com.padovese.assessment.exception


class RiskQuestionsException : RuntimeException() {
    override val message: String? = "Risk questions must contains 3 values, being 0 or 1 each."
}