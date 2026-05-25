# Search Class Description

## 1. General Information
*   **Class Name:** `Search`
*   **Type:** Activity (Search Screen / Browser)
*   **Purpose:** Allows the user to enter a search query, search for information on Google through a built-in mini-browser (`WebView`), and send the selected site's URL back.
*   **Interaction:** Receives control from `MainActivity` and returns a result when a specific button is clicked.

---

## 2. Variables (Class Fields)
| Name | Type | Purpose | Where is it used |
| :--- | :--- | :--- | :--- |
| `context` | `Context` | Context of the current screen. | To initialize components. |
| `et` | `EditText` | Text input field (query). | Read when the search button is clicked. |
| `bSearch` | `Button` | Search launch button. | Click listener set in `onCreate`. |
| `stUrl` | `String` | Stores the user's query text. | To form the Google search link. |
| `wvs` | `WebView` | Mini-browser inside the app. | Loads internet pages. |
| `GOOGLE_SERACH_URL` | `String` (const) | Google base URL. | Prefix for the query: `https://www.google.com/search?q=` |
| `take` | `Intent` | The object that "brought" us to this screen. | In `initElements`. |

---

## 3. Class Methods

### Method: onCreate()
*   **Type:** `protected`
*   **Return value:** `void`
*   **What it does:** Initializes the screen. The main logic here is in the `bSearch.setOnClickListener`. When you press "Search", the program takes text from `et`, enables JavaScript support in the browser, and commands `wvs.loadUrl` to load the Google page with your query.
*   **When called:** When the search screen opens.

### Method: initElements()
*   **Type:** `private`
*   **What it does:** Simple binding of variables to layout elements (buttons, input field, web view).
*   **When called:** At the beginning of `onCreate`.

### Method: backWithLink()
*   **Type:** `public`
*   **Parameters:** `View view` (required for connection with the button in XML).
*   **What it does:** Creates a new `Intent`, takes the current site address from the browser (`wvs.getUrl()`), puts it in a data "bag" under the key `"result"`, sets the status to "success" (`setResult`), and closes this screen (`finish()`).
*   **When called:** When the "Back with Link" button is clicked in the UI.

### Inner Class: myWebViewClient
This is a "helper" for the browser. Without it, links would open in the external Chrome browser; with it, they open right inside your app. It intercepts page loading requests.

---

## 4. Lifecycle
*   **onCreate():** Entry point where the interface is created.
*   **finish():** Termination method. When `finish()` is called, control returns to `MainActivity`.

---

## 5. UI Interaction
*   **EditText (`et`):** The place where the student writes, e.g., "Android Studio".
*   **WebView (`wvs`):** The most complex part — a component capable of showing websites.
*   Connected via `findViewById`.

---

## 6. Interaction with other components
*   **WebView:** Interaction with the internet.
*   **setResult(111, goback):** Sending data back. The number `111` is the result code.

---

## 7. General Logic of the Class
1. The user writes a word.
2. Clicks the button.
3. Google opens in the `WebView`.
4. The user browses the sites.
5. Finds the desired site, clicks "Back with Link".
6. The screen closes, and the URL is sent to `MainActivity`.

---

## 8. Simplified Explanation
The `Search` class is like a **librarian with internet access**.
1. You come to them and give a note: "I want to know about kittens" (`EditText`).
2. The librarian opens their laptop (`WebView`) and searches on Google.
3. You choose a page.
4. The librarian writes the address of that page on a piece of paper and hands it to you as you leave (`backWithLink`).

> **Notes for Improvement:**
> 1. In `myWebViewClient`, the `shouldOverrideUrlLoading` method with one parameter is deprecated. It's better to use only the version with `WebResourceRequest`.
> 2. There is a typo in the constant name: `GOOGLE_SERACH_URL` (missing 'a'). It should be corrected to `GOOGLE_SEARCH_URL`.
