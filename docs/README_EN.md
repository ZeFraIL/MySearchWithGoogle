# 📱 Android Application Documentation (LEVEL 10/10)
________________________________________
🧾 General Information
**Project Name:**
MySearchWithGoogle
**Author(s):**
Zeev Fraiman
**Date:**
May 25, 2026
**Language:**
Java
**Development Environment:**
Android Studio
**Android Version (minSdk / targetSdk):**
26 / 33
________________________________________
🎯 Project Goal
•	**What problem does the application solve:** It allows the user to perform Google search queries directly through a built-in WebView and return the selected page's URL back to the main application window.
•	**Why is this task important:** It demonstrates activity interaction using `ActivityResultLauncher`, working with `WebView`, and data passing via `Intent`.
•	**Target Audience:** Developers learning the basics of Android development.
________________________________________
📌 Application Requirements
**Functional Requirements**
•	Input search query.
•	Display Google search results within the app.
•	Ability to return to the main screen with the current page's URL.
**Non-functional Requirements**
•	**Performance:** Fast web page loading.
•	**Usability:** Minimalist interface.
•	**Reliability:** Stable operation during transitions between windows.
________________________________________
🧠 General Architecture
•	**Chosen Approach:** MVC (Model-View-Controller)
•	**Why it was chosen:** The project is small-scale, so the standard Android Activity structure fully meets the needs without unnecessary complexity.
•	**System Main Components:**
    - `MainActivity`: Displays the result and launches the search.
    - `Search`: Processes input and displays the WebView.
________________________________________
🧩 UML Diagram (Mandatory)
[MainActivity] --(startActivityForResult)--> [Search]
[Search] --(setResult)--> [MainActivity]
________________________________________
**Explanation:**
- Why these packages: The `zeev.fraiman.mysearchwithgoogle` package consolidates the application logic.
- How this helps scaling: Dividing into Activities makes it easy to add new features (e.g., search history).
________________________________________
🧩 Detailed Class Description
📌 Class: MainActivity
**Role:** Application entry point.
**Responsibility:** Displaying the link received from the search engine.
**Main Methods:** 
- `onCreate()` — layout setup and listeners.
- `initComponents()` — UI initialization and `ActivityResultLauncher`.
**Interaction with other classes:** Launches `Search` via `Intent`.
________________________________________
📌 Class: Search
**Role:** Search screen.
**Responsibility:** Query input, WebView display, link return.
**Main Methods:**
- `initElements()` — component initialization.
- `backWithLink()` — returns current URL to `MainActivity`.
- `myWebViewClient` — inner class to manage page loading inside WebView.
________________________________________
🔄 Application Workflow Diagram
**Scenario:**
1. User clicks "Start Search" in `MainActivity`.
2. Enters text in `Search` and clicks the search button.
3. Browses results in `WebView`.
4. Clicks the back button, and the page URL is displayed in `MainActivity`.
________________________________________
🎨 UI/UX Analysis
•	**Why the interface is made this way:** Focus on functionality and simplicity.
•	**Principles used:** Simplicity, logic.
•	**Improvements:** Add a loading indicator (ProgressBar).
________________________________________
⚙️ Thread Management
•	**Used:** Standard UI thread. WebView works asynchronously for content loading.
•	**Why this method:** Simple implementation for basic functionality.
•	**Prevention:** WebView manages resources efficiently.
________________________________________
💾 Data Handling
•	**Where data is stored:** In RAM (passed via Intent). Persistent storage is not used.
•	**Why this method:** No need to save history for this task.
________________________________________
🌐 Networking (if any)
•	**How requests are performed:** Via `WebView.loadUrl()`.
•	**Error handling:** Standard `WebViewClient` behavior.
•	**No Internet:** Standard WebView error page is shown.
________________________________________
🔐 Security (Basic Level)
•	**Sensitive data:** None.
•	**Protection:** Not required.
________________________________________
🧪 Testing
•	**Types of tests:** Unit tests are absent (default templates used).
•	**What is checked:** Manual testing of transitions and search.
________________________________________
🐞 Error Handling
•	Empty search query check is provided.
________________________________________
⚡ Performance
•	**Optimizations:** JavaScript enabled in WebView for correct Google Search operation.
________________________________________
🚀 Expansion Possibilities
•	Adding page caching.
•	Support for multiple search engines.
•	Query history.
________________________________________
📊 Project Self-Assessment
| Criterion | Rating (1–10) |
| :--- | :--- |
| Architecture | 8 |
| Code | 9 |
| UI/UX | 7 |
| Reliability | 9 |
| Overall Level | 8 |
________________________________________
🏁 Conclusion
•	**Best part:** Implementation of data transfer between activities.
•	**Difficulties:** Setting up `WebViewClient` to open links inside the app.
•	**Skills learned:** Working with `ActivityResultLauncher` and `WebView`.
________________________________________
📎 Appendices
•	Screenshots: (not added)
•	Repository links: [GitHub/Local]
