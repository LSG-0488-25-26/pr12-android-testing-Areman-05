package com.example.android_studio_test_exercice.view

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertIsEnabled
import androidx.compose.ui.test.assertIsNotEnabled
import androidx.compose.ui.test.assertIsOff
import androidx.compose.ui.test.assertIsOn
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextInput
import androidx.compose.ui.test.performTouchInput
import androidx.compose.ui.test.swipeRight
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.android_studio_test_exercice.MainActivity
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainViewTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    @Test
    fun switch_wifi_canvia_estat() {
        composeTestRule.onNodeWithTag("wifiSwitch").assertIsOn().performClick().assertIsOff()
    }

    @Test
    fun checkboxes_menu_es_comporten_com_esperat() {
        composeTestRule.onNodeWithTag("carnivorCheckbox").assertIsNotEnabled()
        composeTestRule.onNodeWithTag("vegetariaCheckbox").assertIsOff().performClick().assertIsOn()
        composeTestRule.onNodeWithTag("vegaCheckbox").assertIsOff().performClick().assertIsOn()
    }

    @Test
    fun tristate_checkbox_existeix_i_respon_click() {
        composeTestRule.onNodeWithTag("triStateCheckbox").assertIsDisplayed().performClick().assertIsDisplayed()
    }

    @Test
    fun radio_buttons_mostren_opcions_i_permeten_seleccio() {
        composeTestRule.onNodeWithTag("radio_Vinicius").assertIsNotEnabled()
        composeTestRule.onNodeWithTag("radio_Lamine Yamal").assertIsEnabled().performClick()
        composeTestRule.onNodeWithTag("radio_Raphina").assertIsEnabled().performClick()
    }

    @Test
    fun slider_canvia_valor() {
        composeTestRule.onNodeWithTag("volumeSlider").performTouchInput { swipeRight() }
        composeTestRule.onNodeWithText("Volum: 100%").assertIsDisplayed()
    }

    @Test
    fun dropdown_permet_seleccionar_opcio() {
        composeTestRule.onNodeWithTag("dropdownSelectedText").performClick()
        composeTestRule.onNodeWithTag("dropdown_Opció B").performClick()
        composeTestRule.onNodeWithText("Opció B").assertIsDisplayed()
    }

    @Test
    fun search_field_i_boto_mostren_snackbar() {
        composeTestRule.onNodeWithTag("searchField").performTextInput("kotlin")
        composeTestRule.onNodeWithTag("searchButton").performClick()
        composeTestRule.onNodeWithText("Acció completada!").assertIsDisplayed()
    }

    @Test
    fun toggle_button_canvia_text() {
        composeTestRule.onNodeWithTag("toggleButton").performClick()
        composeTestRule.onNodeWithText("Activat").assertIsDisplayed()
    }
}
