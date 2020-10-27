package mohsin.reza.newsapp.home

import android.content.Intent
import android.view.View
import androidx.test.espresso.Espresso
import androidx.test.espresso.ViewAssertion
import androidx.test.espresso.ViewInteraction
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withContentDescription
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.rule.ActivityTestRule
import mohsin.reza.newsapp.MainActivity
import mohsin.reza.newsapp.R.id
import mohsin.reza.newsapp.TestApp
import mohsin.reza.newsapp.TestAppComponent
import mohsin.reza.newsapp.ui.ArticleViewHolder
import org.hamcrest.Matcher
import org.hamcrest.Matchers
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import timber.log.Timber

@RunWith(AndroidJUnit4::class)
class HomeFragmentTest {

    @get:Rule
    val activityRule = ActivityTestRule(MainActivity::class.java, true, false)

    @Before
    fun setUp() {
        (TestApp.app.appComponent as TestAppComponent).inject(this)
    }

    private fun launchActivity() {
        val intent = Intent(
            InstrumentationRegistry.getInstrumentation().targetContext,
            MainActivity::class.java
        )
        activityRule.launchActivity(intent)
    }

    @Test
    fun verifyHomePageContent() {
        launchActivity()
        // verify recyclerView is displayed
        waitFor(withId(id.home_page_recycler_view), ViewAssertions.matches(isDisplayed()))
        // verify first article
        waitFor(withId(id.headline_text_view) and withText(Matchers.containsString("The high price")))
        waitFor(withId(id.article_image_view) and withContentDescription("- Jennifer Hewett"))
        waitFor(withId(id.abstract_text_view) and withText(Matchers.containsString("The community may be")))
        waitFor(withId(id.by_line_text_view) and withText(Matchers.containsString("- Jennifer Hewett")))

        Espresso.onView(withId(id.home_page_recycler_view)).perform(
            RecyclerViewActions.scrollToPosition<ArticleViewHolder>(5)
        )

        // verify fifth article
        waitFor(withId(id.headline_text_view) and withText(Matchers.containsString("CVC cleans up")))
        waitFor(withId(id.article_image_view) and withContentDescription("- Robert Guy"))
        waitFor(withId(id.abstract_text_view) and withText(Matchers.containsString("CVC Emerging")))
        waitFor(withId(id.by_line_text_view) and withText(Matchers.containsString("- Robert Guy")))
    }

    private fun waitFor(
        matcher: Matcher<View>,
        viewAssertion: ViewAssertion = ViewAssertions.matches(
            isDisplayed()
        ),
        seconds: Int = 10
    ): ViewInteraction {
        var counter = 0
        while (true) {
            try {
                return Espresso.onView(matcher).check(viewAssertion)
            } catch (e: Throwable) {
                counter++
                if (counter > seconds * 10) {
                    Timber.e(e, "Waited for $seconds seconds")
                    throw e
                }
                Thread.sleep(100)
            }
        }
    }

    private infix fun <T> Matcher<T>.and(another: Matcher<T>): Matcher<T> =
        Matchers.allOf(this, another)
}