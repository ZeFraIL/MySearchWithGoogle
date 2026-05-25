# MainActivity Class Description

## 1. General Information
*   **Class Name:** `MainActivity`
*   **Type:** Activity
*   **Purpose:** Serves as the main screen of the application. This class is responsible for displaying the search result and launching the search screen. it acts as the "entry point" where the user begins interacting with the app.
*   **Interaction:** Starts the `Search` Activity and waits for a result (a URL) from it.

---

## 2. Variables (Class Fields)
| Name | Type | Purpose | Where is it used |
| :--- | :--- | :--- | :--- |
| `tvResult` | `TextView` | A text field to display the received link. | In `initComponents` and the result handler `arl`. |
| `bStartSearch` | `Button` | A button to navigate to the search screen. | In `initComponents` and `onCreate` for the click listener. |
| `context` | `Context` | Application context (reference to the current object). | In `initComponents` to create an `Intent`. |
| `arl` | `ActivityResultLauncher<Intent>` | An object to launch another Activity while expecting a result. | In `initComponents` for registration and `onCreate` for launching. |
| `addressUri` | `Uri` | (Unused) Potentially for storing a URI. | Not used in the current logic. |

**Explanations:**
*   **TextView:** A UI element that simply shows text on the screen.
*   **Button:** A clickable element.
*   **Context:** The "environment" of the app. It's needed for the system to understand who is requesting an action (e.g., opening a new window).
*   **ActivityResultLauncher:** The modern Android way to communicate between screens: we send a request like "go to that screen and bring back data."

---

## 3. Class Methods

### Method: onCreate()
*   **Type:** `protected`
*   **Return value:** `void` (returns nothing)
*   **Parameters:** `Bundle savedInstanceState` (app state).
*   **What it does:** This is the "heart" of initialization. It sets the screen layout (`setContentView`), calls component setup, and attaches a "listener" to the button. When the button is clicked, an `Intent` (intention) is created to go to the `Search` class, and this transition is launched via `arl.launch(go)`.
*   **When called:** At the very start of the application.
*   **Important:** You must call `super.onCreate()`, otherwise the app will crash.

### Method: initComponents()
*   **Type:** `private`
*   **Return value:** `void`
*   **Parameters:** None.
*   **What it does:** Finds UI elements in the XML file by their IDs and configures `arl`. Inside `arl`, the logic is defined: "when you return with data, take the string named 'result' and write it into `tvResult`."
*   **When called:** Inside `onCreate`.
*   **Important:** You must always call `setContentView` first before searching for elements via `findViewById`.

---

## 4. Lifecycle (Activity)
*   **onCreate():** Called first. Here we create everything: buttons, texts, and connections.
*   Other methods (onStart, onResume, etc.) are not explicitly overridden, so they operate in standard Android mode.

---

## 5. UI Interaction
*   Uses `TextView` (`tvResult`) and `Button` (`bStartSearch`).
*   Connected via `findViewById(R.id...)`.
*   Handles the **button click** event (`setOnClickListener`).

---

## 6. Interaction with other components
*   **Intent:** Used to transition to `Search.class`.
*   **Data transfer:** Receives data back via `Intent` using the `ActivityResultLauncher` mechanism. The data key is `"result"`.

---

## 7. General Logic of the Class
1. The app starts, and a button appears.
2. The user clicks the button -> the search screen opens.
3. After the user picks a page in search and clicks "back" (on that screen), `MainActivity` catches the URL.
4. The URL is displayed on the screen.

---

## 8. Simplified Explanation
Imagine that `MainActivity` is a **Secretary**.
1. The secretary sits at a desk (the screen).
2. You give them a command: "Find me some info" (button click).
3. The secretary sends a **courier** (`Intent`) to the library (`Search`).
4. When the courier returns with a book, the secretary writes the book's title in their notebook (`tvResult`).

> **Code Tip:** The variable `addressUri` is declared but never used. In good code, it's better to remove such "ghost" variables.
