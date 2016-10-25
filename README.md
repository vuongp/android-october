# Android October update examples

This project will not be updated and provides examples of new updates in Android. This example has been used for a local meeting based in Amsterdam. As a developer you are very welcome to join us!

## Updates October 25th 2016

### Pre launch report:
Since this year 2016 Google announced pre-launch reports. I recently noticed it in the google play console and its ridiculously easy to use. Just opt in and upload an APK. I takes a while for reports to be generated. But your apk will be tested on different devices.

Sources:
* http://android-developers.blogspot.nl/2016/05/whats-new-in-google-play-at-io-2016.html
* https://medium.com/@AruLNadhaN/awesome-pre-launch-reports-for-alpha-beta-apks-9960ac5c403c
* https://play.google.com/apps/publish/

### Realm Mobile platform
I've used Realm for a while now and it is a great alternative to SQLite. Realm recently released their new Realm Mobile Platform. Which is a realtime synced database like firebase. The difference in a set up like this is that Realm is opensource and you run it on your own servers. There is a separate macOS app to browse through your database.

As an example I've created a simple attendee list. Using the realm mobile browser really shows that syncing the data is quite fast. However I haven't done a regression test on it yet. I used a DigitalOcean Ubuntu VPS. There is a browser macOS client to browse the realm database.

#### Realm Mobile platform usage
As of October 25th there is no Android Documentation for setting realm up, please correct me if I'm wrong but I only found [this](https://realm.io/docs/realm-mobile-platform/example-app/cocoa/). Therefor I've added my implementation steps here.

* Add `classpath 'io.realm:realm-gradle-plugin:2.0.2'` to your project build.gradle script
* Add `apply plugin: 'realm-android'` to the top of yout app build.gradle script under the android one
* Add the following to your dependencies
~~~~
compile('io.realm:android-adapters:1.3.0') {
        exclude group: "io.realm"
    }
~~~~
* Add the following to your app gradle
~~~~
realm {
    syncEnabled = true
}
~~~~
* Add `Realm.init(this);` to Application
* Copy what I did in RealmActivity but better/proper...


Sources:
* https://realm.io/news/introducing-realm-mobile-platform/
* https://realm.io/docs/realm-mobile-platform/install-realm-object-server/

### Constraint Layout
A new layout that looks like iOS. Using this layout now wouldn't be reccomended but playing with it and giving feedback to the Android team would probably be appreciated. Android studio supports this new layout very well and has a couple of features for it. a small and simple example is found in activity_realm.xml

* Still in Alpha-9
* Converting existing views to constraint layouts
* XML code a little bit hard to read
* Constraints:
    * Sizes
        * Any size
        * Fixed
        * Wrap content
    * Types:
        * Parent constraints
        * Position
        * Alignment
        * Baseline alignment constraint
        * Constrain to a guideline
    * Android studio has a feature to auto connect and infer constraints
    * Android studio adds margins by default
    * Needs atleast 1 vertical and horizontal constraint
* Warning: Don't use match parent on any of the views.

Sources:
* https://developer.android.com/training/constraint-layout/index.html

### Android 7.x updates

7.1

* App shortcuts
* Circular app icons
* Image keyboard support
* https://android-developers.blogspot.nl/2016/10/android-71-developer-preview.html

7.0

* Quick settings tiles
* Splitscreen
* Notification enhancements
* Data saver changes
* Vulkan API
* Multi-language
* Network Security Config
* VR SDK!
* https://developer.android.com/about/versions/nougat/android-7.0.html

### Android studio 2.2
* Blueprint mode
* Jack toolchain
    * Annotation processing
    * Java 8 syntax
    * AAPT is quitting :(
* APK browser
* Layout inspector
* PSD file support
* Code samples browser
* Gradle: shrinkresources
* Espresso test recorder
* Emulator: virtual sensors

### Very honorable mentions
* [TextInputLayout](https://developer.android.com/reference/android/support/design/widget/TextInputLayout.html)
* [Android accessibility vulnerability](https://android.jlelse.eu/android-accessibility-75fdc5810025)
* [Android bottom sheets](http://mayojava.github.io/android/bottom-sheets-android/)
* [Certificate pinning in retrofit](https://medium.com/@sreekumar_av/certificate-public-key-pinning-in-android-using-retrofit-2-0-74140800025b)
* [Material design updates](https://developer.android.com/reference/android/support/design/widget/TextInputLayout.html)
* [Diff Util](https://medium.com/@nullthemall/diffutil-is-a-must-797502bc1149)
* [Redux in Android?](https://github.com/Yarikx/reductor)

## Even more sauce
* http://androidweekly.net/
* http://fragmentedpodcast.com/
* https://github.com/artem-zinnatullin/TheContext-Podcast
* https://github.com/nisrulz/android-tips-tricks
* https://medium.com/@ipaulpro/drag-and-swipe-with-recyclerview-b9456d2b1aaf#.xwxcvbgmu
* https://developer.android.com/studio/releases/index.html#Revisions
* https://developers.google.com/android/guides/releases#october_2016_-_v98
* https://github.com/Yarikx/reductor
* https://developer.android.com/topic/libraries/support-library/revisions.html