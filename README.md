Video
------------

[![Watch the video](demo/video.mp4)]

Architecture
------------

### 1\. Data Layer

The **FakeShowRepository** simulates the asynchronous network process (delay(1200)) to fetch the list of shows

### 2\. Domain Layer

The **ShowListUseCase** defines the core business logic by injecting the repository and providing the show list to the presentation layer

### 3\. Presentation Layer

The **ShowsViewModel** injects the Use Case, mapping results to **ShowListUiState** (Loading, Error, Success) for the ShowsListScreen and LiveShowScreen Composables

Included Animations and UX Polish
-----------------------------------

###  1\. Shimmer Loading State:

A custom **Modifier.shimmerEffect()** based on Compose infinite animation APIs for seamless loading feedback

###  2\. Animated Navigation Transition:

The transition uses enterTransition and exitTransition in the NavHost for a transition screens

###  3\. Micro-interaction (Like Button):

A Quick Bounce (100 ms) and haptic feedback are triggered by animateFloatAsState upon tapping the like button

Libraries Used
-----------------

*   **Jetpack Compose:** Core UI structure and declarative component building

*   **Compose Navigation:** Manages screens and animated transitions

*   **Kotlin Coroutines/Flow:** Manages asynchronous data fetching and state updates

*   **Hilt:** for dependency injection

*   **KSP (Kotlin Symbol Processing):** Accelerates the build process for Hilt annotation processing