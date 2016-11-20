AndroidStarter
==============

Android Application bootstrap sample using Kotlin.


## What's Inside

`WIP`


## Getting Starting

There are few steps should be done before running this project


### Get the Code

`git clone https://github.com/lostintime/android-starter.git`


### Generate Signing Certificates

More details about signing android apps you can find in [Sign Your App](https://developer.android.com/studio/publish/app-signing.html)
android studio documentation section, here I'll list commands to be executed (in project root folder):

__Generate Debug Signing (replace passwords and key alias with yours):__

    keytool -genkey -v -keystore ./certificates/starter-debug-key.keystore \
        -storepass <store password here> \
        -keypass <key password here> \
        -alias <key alias, ex: starter_debug_key> \
        -keyalg RSA -keysize 2048 -validity 10000

__You should fill al certificate fields, ex:__

    What is your first and last name?
      [Unknown]:  Lostintime
    What is the name of your organizational unit?
      [Unknown]:  IT
    What is the name of your organization?
      [Unknown]:  NA        
    What is the name of your City or Locality?
      [Unknown]:  Chisinau 
    What is the name of your State or Province?
      [Unknown]:  Chisinau
    What is the two-letter country code for this unit?
      [Unknown]:  MD
    Is CN=Lostintime, OU=IT, O=NA, L=Chisinau, ST=Chisinau, C=MD correct?
      [no]:  yes
    
    Generating 2,048 bit RSA key pair and self-signed certificate (SHA256withRSA) with a validity of 10,000 days
        for: CN=Lostintime, OU=IT, O=NA, L=Chisinau, ST=Chisinau, C=MD
    [Storing ./certificates/starter-debug-key.keystore]



__Then do the same for release signing:__ 

    keytool -genkey -v -keystore ./certificates/starter-release-key.keystore \
        -storepass <store password here> \
        -keypass <key password here> \
        -alias <key alias, ex: starter_release_key> \
        -keyalg RSA -keysize 2048 -validity 10000
    
    
__... and details:__ 

    What is your first and last name?
      [Unknown]:  Lostintime
    What is the name of your organizational unit?
      [Unknown]:  IT
    What is the name of your organization?
      [Unknown]:  NA
    What is the name of your City or Locality?
      [Unknown]:  Chisinau
    What is the name of your State or Province?
      [Unknown]:  Chisinau
    What is the two-letter country code for this unit?
      [Unknown]:  MD
    Is CN=Lostintime, OU=IT, O=NA, L=Chisinau, ST=Chisinau, C=MD correct?
      [no]:  yes
    
    Generating 2,048 bit RSA key pair and self-signed certificate (SHA256withRSA) with a validity of 10,000 days
        for: CN=Lostintime, OU=IT, O=NA, L=Chisinau, ST=Chisinau, C=MD
    [Storing ./certificates/starter-release-key.keystore]


### Configure Signing

Make a copy of `keystore.sample.properties` at `keystore.properties` and 
update fields with values you provided on previous step, while generating certificates

__Never commit your certificates and credentials (`./keystore.properties` and `./certificates/*.keystore`)!__



### Configure Fabric

In order to use Crashlytics and Beta for app distribution - 
Signup first for an Fabric account: [https://fabric.io/sign_up](https://fabric.io/sign_up)

Make a copy of `app/fabric.sample.properties` at `app/fabric.properties`

Then on your [settings page](https://fabric.io/settings/organizations) - select organization
 you want to add your app to and from page header - get `API Key` and `Build secret` and
 update config values in `app/fabric.properties`.


### Building the app

To build the app and install to attached device run: `./gradlew installPreviewDebug`.

By default Crashlytics is enable only for `release` configuration, 
so Fabric app will be registered only when you run release build first time. 


## Next Steps

Now we're ready to do our custom changes. Start with renaming 
base package (from `com.example.starter`).
