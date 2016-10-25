# Android October update examples

This project will not be updated and provides examples of new updates in Android. This example has been used for...

## Updates October 25th 2016

### Pre launch report:
Since this year 2016 Google announced pre-launch reports. I recently noticed it in the google play console and its ridiculously easy to use. Just opt in and upload an APK. I takes a while for reports to be generated. But your apk will be tested on different devices.

* http://android-developers.blogspot.nl/2016/05/whats-new-in-google-play-at-io-2016.html
* https://medium.com/@AruLNadhaN/awesome-pre-launch-reports-for-alpha-beta-apks-9960ac5c403c
* https://play.google.com/apps/publish/

### Realm Mobile platform
I've used Realm for a while now and it is a great alternative to SQLite. Realm recently released their new Realm Mobile Platform. Which is a realtime synced database like firebase. The difference in a set up like this is that Realm is opensource and you run it on your own servers. There is a separate macOS app to browse through your database.

As an example I've created a simple attendee list. Using the realm mobile browser really shows that syncing the data is quite fast. However I haven't done a regression test on it yet. I used a DigitalOcean Ubuntu VPS. There is a browser macOS client to browse the realm database.

* https://realm.io/news/introducing-realm-mobile-platform/
* https://realm.io/docs/realm-mobile-platform/install-realm-object-server/

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

### Constraint Layout
* 

### Bottom sheets
### Quick settings tiles

