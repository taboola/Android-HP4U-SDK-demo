# Android-HP4U-SDK-demo

## Preface

This project showcases how to integrate Taboola's SDK on Android and use its HomePage capabilities.

### Initialization

1. Add Taboola's SDK to your project by going to your application's `build.gradle` file:
   implementation 'com.taboola:android-sdk:3.7.0'
2. Inside your project's `build.gradle` file, under `allProjects -> repositories` add this:
   maven {
   url 'https://taboolapublic.jfrog.io/artifactory/mobile-release'
   }
3. To initialize the Taboola SDK, you need to create a TBLPublisherInfo object that contains your given publisher name and api key.
   It would be best to do this when your application is just starting, preferably in your application class's `onCreate` method:
   TBLPublisherInfo publisherInfo = new TBLPublisherInfo("PublisherName").setApiKey("apiKey");
   Taboola.init(publisherInfo);

### Creating a HomePage Instance

1. The API to create a HomePage instance in your activity/fragment is:
   TBLHomePage homePage = Taboola.getHomePage(sourceType, pageUrl, tblHomePageListener, sectionsNames);

The parameters you need to pass in are:
- sourceType: String describes the widget's type (e.g. SourceTypeVideo).
- pageUrl: String describes the website's URL.
- tblHomePageListener: Sets the listener for Taboola calls.
- sectionsNames: all sections names which this homePage should work with

> SectionName is the string title of each group of articles separated by categories.

### HomePage Setup

1. In order to link the HomePage to the articles your presenting, call the `attach` API with your viewgroup

        homePage.attach(ViewGroup viewGroup);

2. Next, it is advised to call `fetchContent` as soon as you can so that content will be loaded into the HomePage instance

        homePage.fetchContent();

### Swap Articles

To swap articles with content from Taboola,
call the `shouldSwapItemInSection` function in your OnBind methd to get the swapped item's content.
It returns YES if the item was swapped, NO if it wasn't.


        public boolean shouldSwapItemInSection(
                                final int linePosition,
                                final String sectionName, 
                                View lineView, 
                                @Nullable final TextView titleView,
                                @Nullable final TextView contentView,
                                @Nullable final ImageView thumbnailView,
                                @Nullable AdditionalViews additionalViews) 

The parameters you need to pass in are:
- linePosition: of the cell
- sectionName: representing section
- lineView: view of the cell
- titleView: UI element representing the title of the cell
- contentView: UI element representing the description of the cell
- thumbnailView: UI element representing the image of the cell
- additionalView(optional): UI element representing the all other view in the lineView which aren’t mandatory

#### How does the swapping take place?
When you call `shouldSwapItemInSection`, Taboola verifies that this item is allowed to be swapped and validates the fields of the content, then performs a swap with a recommendation.
Taboola will handle the views the publisher desires to swap.
It will validate the fields of the content and the swapped content as well.
After a successful validation - Taboola will swap the publisher’s content with Taboola recommendations, and return a boolean that indicates if the swapping process did occur.

### Additional HomePage functionality

Previous steps are enough for integrating HomePage, this section describes additional methods for HomePage.

- Get HomePage status if needed: // True if HomePage is on, False if it isn't
  homePage.isActive();


- Set HomePage Listener: // If you didn’t provide a Listener at HomePage creation, you can still set a listener by using this function
  homePage.setTBLHomePageListener(TBLHomePageListener tblHomePageListener);


- Set a targetType: // According to your account manager (Usually will be "mix")
  homePage.setTargetType(String targetType);


- Set a unique id for the HomePage instance
  homePage.setUnifiedId(String unifiedId);

### Callbacks

Listen to TBLHomePageListener. All functions are optional and do not need to be implemented.

- `public void onHomePageStatusChanged(boolean status) {}`
  Triggered when HomePage is being initialized

- `public void onHomePageError(String error, String sectionName) {}`
  Triggered while the swapped items are being rendered.

Possible errors:
- "SWAP_FAILED_DUE_TO_MISSING_DATA"
- "FAILED_TO_RETRIEVE_RECOMMENDATION"
- "SWAP_FAILED_DUE_TO_MISSING_RECOMMENDATION"
- "SWAP_FAILED_DUE_TO_MISSING_START_POSITION_ON_UNIT"

- `public boolean onHomePageItemClick(String sectionName, String itemId, String clickUrl, boolean isOrganic, String customData) {}`
  When implemented, it allows the hosting app to decide what to do when intercepting clicks.

# Legal

Using this repository is subject to Taboola’s [terms of service](https://www.taboola.com/policies/platform-terms-of-use), [privacy policy](https://www.taboola.com/policies/privacy-policy), and the non-disclosed/business agreements set by Taboola and you.
Do not share the content of this repository with any third party.
The files in this repository are for demo usage only and should not use in production without Taboola's approval