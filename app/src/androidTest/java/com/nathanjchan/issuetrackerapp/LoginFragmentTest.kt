package com.nathanjchan.issuetrackerapp

import androidx.navigation.Navigation
import androidx.navigation.testing.TestNavHostController
import androidx.test.core.app.ApplicationProvider
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.nathanjchan.issuetrackerapp.ui.fragment.LoginFragment
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import org.junit.Assert
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@HiltAndroidTest
class LoginFragmentTest {

    @get:Rule
    var hiltRule = HiltAndroidRule(this)

    @Test
    fun testNavigationToSignupFragment() {
        // Create TestNavHostController.
        val navController = TestNavHostController(ApplicationProvider.getApplicationContext())
        // Create FragmentScenario for LoginFragment.
        launchFragmentInHiltContainer<LoginFragment> {
            LoginFragment().also { fragment ->
                // Set nav graph for TestNavHostController.
                navController.setGraph(R.navigation.nav_graph)
                // Associate this FragmentScenario with this TestNavHostController.
                Navigation.setViewNavController(fragment.requireView(), navController)
            }
        }

        // Verify that clicking signup button changes NavController's state to Signup Fragment.
        onView(ViewMatchers.withId(R.id.loginToSignupButton)).perform(ViewActions.click())
        Assert.assertEquals(navController.currentDestination?.id, R.id.signupFragment)
    }

    @Test
    fun testNavigationToSignupFragmentSafer() {
        val navController = TestNavHostController(ApplicationProvider.getApplicationContext())
        launchFragmentInHiltContainer<LoginFragment> {
            LoginFragment().also { fragment ->
                // In addition to returning a new instance of Fragment, get a callback whenever
                // the fragment's view is created or destroyed so we can set the NavController
                // ahead of time.
                fragment.viewLifecycleOwnerLiveData.observeForever { viewLifecycleOwner ->
                    if (viewLifecycleOwner != null) {
                        // The fragment's view has just been created.
                        navController.setGraph(R.navigation.nav_graph)
                        Navigation.setViewNavController(fragment.requireView(), navController)
                    }
                }
            }
        }
        onView(ViewMatchers.withId(R.id.loginToSignupButton)).perform(ViewActions.click())
        Assert.assertEquals(navController.currentDestination?.id, R.id.signupFragment)
    }
}
