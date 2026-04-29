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

## Evidencies

Guarda les captures en `docs/images` i el video en `docs/videos`.

### Captures

Execucio correcta de `testDebugUnitTest`:

![Execucio testDebugUnitTest](docs/images/Captura%20de%20pantalla%202026-04-29%20194453.png)

Execucio correcta de `connectedDebugAndroidTest`:

![Execucio connectedDebugAndroidTest](docs/images/Captura%20de%20pantalla%202026-04-29%20195619.png)

### Video

- Demostracio visual dels tests UI corrent (Google Drive): [android-studio-test-exercice 2026-04-29 20-00-39.mp4](https://drive.google.com/file/d/1yLf3swSUB3JV_RdJjnmxR4N0VxrD-kkg/view?usp=sharing)

## Fet per Pablo Arenas Mancebo