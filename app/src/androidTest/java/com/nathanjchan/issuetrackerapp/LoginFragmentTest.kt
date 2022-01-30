package com.nathanjchan.issuetrackerapp

import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.navigation.Navigation
import androidx.navigation.testing.TestNavHostController
import androidx.test.core.app.ApplicationProvider
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.nathanjchan.issuetrackerapp.ui.fragment.LoginFragment
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class LoginFragmentTest {

    @Test
    fun testNavigationToSignupFragment() {
        // Create TestNavHostController.
        val navController = TestNavHostController(ApplicationProvider.getApplicationContext())
        // Create FragmentScenario for LoginFragment.
        val loginScenario = launchFragmentInContainer<LoginFragment>()

        loginScenario.onFragment { fragment ->
            // Set nav graph for TestNavHostController.
            navController.setGraph(R.navigation.nav_graph)
            // Associate this FragmentScenario with this TestNavHostController.
            Navigation.setViewNavController(fragment.requireView(), navController)
        }

        // Verify that clicking signup button changes NavController's state to Signup Fragment.
        onView(ViewMatchers.withId(R.id.signupButton)).perform(ViewActions.click())
        Assert.assertEquals(navController.currentDestination?.id, R.id.loginFragment)

        // Verify that clicking the back button changes the NavController's state to Login Fragment.
        onView(ViewMatchers.doesNotHaveFocus()).perform(ViewActions.pressBack())
        Assert.assertEquals(navController.currentDestination?.id, R.id.signupFragment)
    }

    @Test
    fun testNavigationToSignupFragmentSafer() {
        val navController = TestNavHostController(ApplicationProvider.getApplicationContext())
        launchFragmentInContainer {
            LoginFragment().also { fragment ->
                // In addition to returning a new instance of Fragment, get a callback whenever
                // the fragment's view is created or destroyed so we can set the NavController
                // ahead of time.
                fragment.viewLifecycleOwnerLiveData.observeForever{ viewLifecycleOwner ->
                    if (viewLifecycleOwner != null) {
                        // The fragment's view has just been created.
                        navController.setGraph(R.navigation.nav_graph)
                        Navigation.setViewNavController(fragment.requireView(), navController)
                    }
                }
            }
        }
        onView(ViewMatchers.withId(R.id.signupButton)).perform(ViewActions.click())
        Assert.assertEquals(navController.currentDestination?.id, R.id.signupFragment)
    }
}
