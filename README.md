# Android Testing - DAM2 0488

Practica individual de l'assignatura **Desenvolupament d'interficies** centrada en completar una app Android amb arquitectura MVVM i aplicar testing de capa de logica i d'interficie.

## Objectiu

Completar l'aplicacio base perque:

- segueixi el patro **MVVM** amb **LiveData**
- inclogui **Unit Tests** per tots els metodes del `MainViewModel`
- inclogui **UI Instrumental Tests** per tots els composables de la `MainView`
- mantingui el comportament i disseny originals

## Tecnologies

- Kotlin
- Jetpack Compose
- Android Studio Ladybug
- JUnit4
- AndroidX Test + Compose UI Test

## Arquitectura MVVM aplicada

- **View**: `MainView` consumeix estat reactiu via `observeAsState()` i delega les accions al ViewModel.
- **ViewModel**: `MainViewModel` exposa `LiveData` immutable i encapsula la logica d'actualitzacio d'estat.
- **State flow de pantalla**: Switch, checkboxes, tristate, radio, slider, dropdown, camp de cerca, snackbar i boto toggle.

## Cobertura de Unit Testing

Fitxer: `app/src/test/java/com/example/android_studio_test_exercice/viewmodel/MainViewModelTest.kt`

Metodes testejats:

- `toggleEstatSwitch()`
- `toggleEsCarnivor()`
- `toggleEsVegetaria()`
- `toggleEsVega()`
- `toggleTriStateStatus()`
- `setSelectedOption()`
- `setSliderValue()`
- `setExpanded()`
- `setSelectedItem()`
- `setSearchText()`
- `performSearch()`
- `dismissSnackbar()`
- `toggle()`

## Cobertura de UI Instrumental Testing

Fitxer: `app/src/androidTest/java/com/example/android_studio_test_exercice/view/MainViewTest.kt`

Composables validats:

- Switch de Wi-Fi
- Checkboxes de tipus de menu
- TriStateCheckbox
- RadioButtons de Pilota d'Or
- Slider de volum
- Dropdown menu
- OutlinedTextField i boto Buscar
- Boto toggle final

## Execucio dels tests

### Unit Tests

```bash
./gradlew testDebugUnitTest
```

### UI Instrumental Tests

```bash
./gradlew connectedDebugAndroidTest
```

> Per executar UI tests cal un emulador o dispositiu Android connectat.

## Evidencies (captures / gifs / videos)

Afegir en aquest repositori captures de:

- execucio correcta de `testDebugUnitTest`
- execucio correcta de `connectedDebugAndroidTest`
- demostracio visual dels tests UI corrent

Exemple d'estructura recomanada:

- `docs/images/unit-tests-ok.png`
- `docs/images/ui-tests-ok.png`
- `docs/gifs/ui-tests-run.gif`

## Estat final

Projecte completat segons enunciat:

- MVVM + LiveData
- Unit tests per tots els metodes del ViewModel
- UI tests per tots els composables de MainView
- Documentacio del proces de testing al README
