**Note for learning:**

1. First learn: https://github.com/magsingh/Android-Kotlin-Composable-ListView
2. Next learn first version of the Counter app- https://github.com/magsingh/Android-Kotlin-Compose-CounterApp
3. Then the current app.


**Architecture of current app:**

1. In the previous version of the app, the UI as well as the business logic were part of the main activity.

2. In the current version, the UI no longer changes the state directly.

3. Instead, it asks the ViewModel to perform an action.

4. This separation is the foundation of the MVVM (Model–View–ViewModel) architecture used in modern Android apps.


```log
User clicks +
        
        ▼
Compose Button
        │
        ▼
counterViewModel.increment()
        │
        ▼
count++
        │
        ▼
Compose notices count changed
        │
        ▼
Text is recomposed
```
