package com.padovese.assessment.runner

import com.padovese.assessment.groups.IntegratedTest
import org.junit.runner.notification.RunListener
import org.junit.runner.notification.RunNotifier
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner


class TestRunner(klass: Class<Any>) : SpringJUnit4ClassRunner(klass) {

    companion object {
        const val INTEGRATED_TEST_GROUP: String = "INTEGRATED_TEST"
        const val INTEGRATED_TEST_GROUP_RUN_VALUE = "true"
    }

    /**
     * Integrated test only will be executed if test method has annotation @see[IntegratedTest] and if there is environment variable set as @see[TestRunner.INTEGRATED_TEST_GROUP] with value @see[TestRunner.INTEGRATED_TEST_GROUP_RUN_VALUE]
     */
    override fun run(notifier: RunNotifier) {
        notifier.addListener(RunListener())

        val env = System.getenv(INTEGRATED_TEST_GROUP)?.contentEquals(INTEGRATED_TEST_GROUP_RUN_VALUE)
        val isMethodIntegratedTest = description.children.filter { annotation -> annotation.getAnnotation(IntegratedTest::class.java) != null }

        if (isMethodIntegratedTest.isNotEmpty() && env == null) {
            isMethodIntegratedTest.forEach { currentTest -> notifier.fireTestIgnored(currentTest) }
        } else {
            super.run(notifier)
        }
    }
}