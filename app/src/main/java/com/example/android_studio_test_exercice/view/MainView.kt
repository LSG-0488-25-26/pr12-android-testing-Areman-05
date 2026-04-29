package com.example.android_studio_test_exercice.view

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Slider
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TriStateCheckbox
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.state.ToggleableState
import androidx.compose.ui.unit.dp
import com.example.android_studio_test_exercice.viewmodel.MainViewModel

@Composable
fun MainView(myViewModel: MainViewModel, modifier: Modifier = Modifier) {
    val estatSwitch by myViewModel.estatSwitch.observeAsState(true)
    val esVegetaria by myViewModel.esVegetaria.observeAsState(true)
    val esVega by myViewModel.esVega.observeAsState(false)
    val esCarnivor by myViewModel.esCarnivor.observeAsState(true)
    val triStateStatus by myViewModel.triStateStatus.observeAsState(ToggleableState.Off)
    val selectedOption by myViewModel.selectedOption.observeAsState("Messi")

    val sliderValue by myViewModel.sliderValue.observeAsState(0f)
    val expanded by myViewModel.expanded.observeAsState(false)
    val selectedItem by myViewModel.selectedItem.observeAsState("Opció A")
    val searchText by myViewModel.searchText.observeAsState("")
    val showSnackbar by myViewModel.showSnackbar.observeAsState(false)
    val toggleState by myViewModel.toggleState.observeAsState(false)
    val scrollState = rememberScrollState()

    Surface(
        modifier = modifier
            .fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(scrollState)
                .padding(horizontal = 16.dp, vertical = 24.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Text(
                text = "Configuració principal",
                style = MaterialTheme.typography.headlineSmall
            )

            Card(
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.surfaceVariant
                )
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Column(modifier = Modifier.weight(1f)) {
                        Text(
                            text = "Activar Wi-Fi",
                            style = MaterialTheme.typography.titleMedium
                        )
                        Text(
                            text = if (estatSwitch) "Estat: activat" else "Estat: desactivat",
                            style = MaterialTheme.typography.bodyMedium
                        )
                    }
                    Switch(
                        checked = estatSwitch,
                        onCheckedChange = { myViewModel.toggleEstatSwitch() },
                        modifier = Modifier.testTag("wifiSwitch"),
                        enabled = true,
                        colors = SwitchDefaults.colors(
                            uncheckedThumbColor = Color.LightGray,
                            checkedThumbColor = Color.Black
                        )
                    )
                }
            }

            Card(
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.surfaceVariant
                )
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(
                        text = "Opcions de menú",
                        style = MaterialTheme.typography.titleMedium
                    )

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 8.dp, bottom = 4.dp)
                    ) {
                        Text("Carnívor/a", Modifier.align(CenterVertically).fillMaxWidth(0.33f))
                        Text("Vegetarià/na", Modifier.align(CenterVertically).fillMaxWidth(0.6f))
                        Text("Vegà/na", Modifier.align(CenterVertically).fillMaxWidth(1f))
                    }

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .wrapContentWidth()
                    ) {
                        Checkbox(
                            checked = esCarnivor,
                            onCheckedChange = { myViewModel.toggleEsCarnivor() },
                            modifier = Modifier
                                .fillMaxWidth(0.20f)
                                .testTag("carnivorCheckbox"),
                            enabled = false,
                            colors = CheckboxDefaults.colors(
                                uncheckedColor = Color.LightGray,
                                checkmarkColor = Color.Black
                            )
                        )
                        Checkbox(
                            checked = esVegetaria,
                            onCheckedChange = { myViewModel.toggleEsVegetaria() },
                            modifier = Modifier
                                .fillMaxWidth(0.33f)
                                .testTag("vegetariaCheckbox"),
                            enabled = true,
                            colors = CheckboxDefaults.colors(
                                uncheckedColor = Color.LightGray,
                                checkmarkColor = Color.Black
                            )
                        )
                        Checkbox(
                            checked = esVega,
                            onCheckedChange = { myViewModel.toggleEsVega() },
                            modifier = Modifier
                                .fillMaxWidth(0.33f)
                                .testTag("vegaCheckbox"),
                            enabled = true,
                            colors = CheckboxDefaults.colors(
                                uncheckedColor = Color.LightGray,
                                checkmarkColor = Color.Black
                            )
                        )
                    }
                    Text(
                        text = "Carnívor/a es manté bloquejat segons el disseny base.",
                        style = MaterialTheme.typography.bodySmall
                    )
                }
            }

            Card(
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.surfaceVariant
                )
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text("TriState", Modifier.fillMaxWidth(), style = MaterialTheme.typography.titleMedium)
                    TriStateCheckbox(
                        state = triStateStatus,
                        onClick = { myViewModel.toggleTriStateStatus() },
                        modifier = Modifier.testTag("triStateCheckbox")
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text("Pilota d'Or", style = MaterialTheme.typography.titleMedium)

                    listOf("Vinicius", "Lamine Yamal", "Raphina").forEach { player ->
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            RadioButton(
                                selected = selectedOption == player,
                                onClick = { myViewModel.setSelectedOption(player) },
                                enabled = player != "Vinicius",
                                modifier = Modifier.testTag("radio_$player"),
                                colors = RadioButtonDefaults.colors(
                                    selectedColor = Color.Black,
                                    unselectedColor = Color.LightGray
                                )
                            )
                            Text(player, Modifier.padding(start = 8.dp))
                        }
                    }
                    Text(
                        text = "Vinicius està deshabilitat per requisit de la vista original.",
                        style = MaterialTheme.typography.bodySmall
                    )
                }
            }

            Card(
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.surfaceVariant
                )
            ) {
                Column(modifier = Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(8.dp)) {
                    Text("Volum: ${sliderValue.toInt()}%", style = MaterialTheme.typography.titleMedium)
                    Slider(
                        value = sliderValue,
                        onValueChange = { myViewModel.setSliderValue(it) },
                        valueRange = 0f..100f,
                        modifier = Modifier.testTag("volumeSlider")
                    )

                    Box(modifier = Modifier.wrapContentSize()) {
                        Text(
                            text = selectedItem,
                            modifier = Modifier
                                .clickable { myViewModel.setExpanded(true) }
                                .testTag("dropdownSelectedText")
                        )
                        DropdownMenu(
                            expanded = expanded,
                            onDismissRequest = { myViewModel.setExpanded(false) }
                        ) {
                            listOf("Opció A", "Opció B", "Opció C").forEach { option ->
                                DropdownMenuItem(
                                    text = { Text(option) },
                                    onClick = {
                                        myViewModel.setSelectedItem(option)
                                        myViewModel.setExpanded(false)
                                    },
                                    modifier = Modifier.testTag("dropdown_$option")
                                )
                            }
                        }
                    }
                }
            }

            Card(
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.surfaceVariant
                )
            ) {
                Column(modifier = Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(8.dp)) {
                    OutlinedTextField(
                        value = searchText,
                        onValueChange = { myViewModel.setSearchText(it) },
                        label = { Text("Buscar...") },
                        modifier = Modifier
                            .fillMaxWidth()
                            .testTag("searchField")
                    )
                    Button(
                        onClick = { myViewModel.performSearch() },
                        modifier = Modifier.testTag("searchButton")
                    ) {
                        Text("Buscar")
                    }

                    if (showSnackbar) {
                        Text(
                            text = "Acció completada!",
                            color = Color(0xFF2E7D32)
                        )
                    }

                    Button(
                        onClick = { myViewModel.toggle() },
                        modifier = Modifier.testTag("toggleButton"),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = if (toggleState) Color(0xFF2E7D32) else Color(0xFFC62828)
                        )
                    ) {
                        Text(if (toggleState) "Activat" else "Desactivat")
                    }
                }
            }
        }
    }
}
