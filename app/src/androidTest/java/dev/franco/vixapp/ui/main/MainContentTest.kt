package dev.franco.vixapp.ui.main

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertIsEnabled
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performClick
import dev.franco.vixapp.ui.data.model.main.ContentStreamModel
import org.junit.Rule
import org.junit.Test

class MainContentTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun whenSplashFinishesThenContentIsLoaded() {
        var premiumButtonClicked = false
        val clickPremiumButtonTest: () -> Unit = {
            premiumButtonClicked = true
        }
        val content = ContentStreamModel(
            "1",
            "1",
            "https://images.vix.com/prd/videos/video:mcp:4394544/64907018cc5b1df1ef386b00f1bf3458",
        )
        composeTestRule.setContent {
            MainContent(
                onClickPremium = clickPremiumButtonTest,
                onClickSearch = {},
                onClickProfile = {},
                categories = emptyList(),
                onClickCategory = { },
                mainContent = listOf(),
                onClickContent = { _, _ -> },
                freemiumContent = Pair(
                    "Titulo",
                    listOf(content),
                ),
                onClickFreemiumContent = { _, _ -> },
                premiumContent = Pair(
                    "Titulo",
                    listOf(content),
                ),
                onClickPremiumContent = { _, _ -> },
            )
        }

        with(composeTestRule) {
            onNodeWithTag("main_content")
                .assertIsDisplayed()

            onNodeWithTag("top_bar")
                .assertIsDisplayed()

            onNodeWithTag("premium_button")
                .assertIsDisplayed()
                .assertIsEnabled()
                .performClick()

            assert(premiumButtonClicked)
        }
    }
}
