**Why You Should Use a Base Class in Android**

When building Android apps, you often repeat the same setup code across multiple Activities and Fragments. For example:

Inflating views with ViewBinding

Applying system window insets (edge-to-edge)

Showing Toast messages

Navigating between Activities

Writing this boilerplate again and again is not only boring but also makes your code harder to maintain in large projects.

Benefits of Using a Base Class

**Removes Boilerplate**
Instead of rewriting the same methods in every Activity or Fragment, you put them once in a Base class.

**Centralized Code**
If you ever need to update a common behavior, you only change it in one place.

**Example:** When Android SDK 35 required enabling edge-to-edge for Android 13+ devices, I only needed to update the BaseActivity.

**Without a Base**, I would have had to manually update 50 different screens.

**Consistency Across the App**
UI handling (like padding for system bars) and helpers (like navigation or Toasts) behave the same in every screen.

**Extension Functions Inside Base**
We can include helpers such as:

```toast("Message")```

```start<SecondActivity>()```
This keeps the code cleaner inside each Activity or Fragment.
📚 I’ve published detailed resources here if you want to dive deeper:

How BaseActivity works in Android (Kotlin)
https://medium.com/@hussainfarrukh102/how-baseactivity-works-in-android-kotlin-66d0b0f5b98b 

How BaseFragment works in Android (Kotlin)
https://medium.com/@hussainfarrukh102/how-basefragment-works-in-android-kotlin-30fb3c6a62d6 

GitHub Repo: KotlinBaseCamp
