# The Challenge:

The challenge is to create a simple Android app that exercises a REST-ful API. The API endpoint `https://api.nytimes.com/svc/books/v3/lists/current/hardcover-fiction.json?api-key=KoRB4K5LRHygfjCL2AH6iQ7NeUqDAGAB&offset=0` returns a JSON object which is a list of different books published by the New York Times. 

Using this endpoint, show a list of these items, with each row displaying at least the following data:

- Image
- Title
- Description 

### Technical Instructions:
- MVP architecture, no ViewModel
- XML Layouts (no Compose)
- Demonstrate use of Dagger, Retrofit and Glide (for the images)
- No database needed
- Feel free to make any assumptions you want along the way or use any third party libraries as needed and document why you used them.

### General Instructions:
- This isn't a visual design exercise. For example, if you set random background colors to clearly differentiate the views when debugging, pick Comic Sans or Papyrus, we won't hold that against you. Well, maybe a little bit if you use Comic Sans :)
- This is also most of the code you'll be showing us – don't understimate the difficulty of the task, or the importance of this exercise in our process, and rush your PR. Put up your best professional game.
- This isn't just about handling the happy path. Think slow network (or no network at all), supporting different device sizes, ease of build and run of the project. If we can't check out and click the run button in Android Studio, you're off to a bad start (we've had PRs without a graddle for instance).
- Explanations on any choice you've made are welcome.
- We appreciate there's a lot that is asked in this exercise. If you need more time, feel free to ask. If you need to de-prioritize something, apply the same judgement you would on a professional project, argument your decision. 

Bonus Points:
  - Unit tests

## My Approach

This PR implements the Android Books List Application using a structured and modular architecture, specifically the Model-View-Presenter (MVP) pattern, alongside dependency injection with Dagger and Data Binding for UI updates. This approach ensures scalability, and separation of concerns across the application.

## Architecture Overview

MVP (Model-View-Presenter): This project utilizes the MVP architecture to separate the presentation layer from the business logic.

View: Defines the contract for UI updates, like displaying data or errors.

Presenter: Acts as an intermediary that handles UI logic, interacts with the Use Case, and updates the View based on the model's response.

Model: Contains business logic and provides data to the Presenter via repository and use case layers.

## Classes Overview

BooksMvpView: The interface that declares UI update methods (showLoading, displayBooks, and showError) for the Books List screen.

BooksListActivity: Implements BooksView, sets up RecyclerView with an adapter and item decorations, and binds UI actions. It utilizes Data Binding to display data and handle view visibility.

BooksPresenter: Interacts with the View and the Use Case (BooksUsecase) to fetch the data. Manages UI state by showing loading indicators and presenting books or errors as appropriate.

BooksRepository: Serves as the data provider, fetching data from ApiService. It handles success and failure states for API responses, ensuring that network errors are managed smoothly.

BooksUsecase: A use case class encapsulating the logic to fetch the books list from the repository. It standardizes data flow into the Presenter.

## Models:

BookResponse, BookResults, Book, Isbn and BuyLink represent the data structure returned by the API.

ApiService: Retrofit-based API service that manages HTTP requests, particularly for fetching the list of books.

Constants: Holds configuration constants, including the API key.

SpacingInRecyclerView: A custom RecyclerView ItemDecoration for setting item spacing and drawing separators between items in the book list.

Glide: Used Glide for showing images (Missed the shimmer view due to time constraints)

MyApplication: The custom Application class that initializes Dagger’s AppComponent to manage dependencies.

## Additional Information

Dagger for Dependency Injection: This ensures all dependencies are efficiently managed, promoting modularity and testability.

Retrofit for Networking: A REST client used for API calls.

Data Binding: Simplifies the process of binding UI components to data sources, enabling dynamic updates without manual intervention.

I was not able to add Unit Tests because of shortage of time.

## TODO

Due to shortage of time I was not able to add following:

- Test Cases.
- navGraph and add detail screen of Book
- Splash Screen
- Base classes like, BaseActivity, BasePresenter etc etc. 
- Fragments
- ROOM Database
- Fancy UI
- Support for Tablets
