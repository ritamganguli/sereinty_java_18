**Environment Initial Setup**

Install Homebrew (brew)

```/bin/bash -c "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/HEAD/install.sh)"```

Brew installation will install also the Xcode Command Line Tools

Install XCode to use the Simulators, either from AppStore or from command line:

```brew install mas```

```mas search xcode``` (get the Xcode ID)

```mas install <ID>```

Install Java, Maven, Appium and drivers

```brew install java```

```brew install maven```

```brew install appium```

```appium driver list```

```appium driver install uiautomator2```

```appium driver install xcuitest```

```appium driver install safari```

```appium driver install chromium```

```sudo /usr/bin/safaridriver --enable```

```appium plugin list```

```appium plugin install execute-driver```

```appium --use-plugins execute-driver```

```sudo /usr/bin/xcode-select -switch /Applications/Xcode.app/Contents/Developer-solved```

```sudo /usr/bin/xcode-select -switch /Applications/Xcode.app/Contents/Developer```

```xattr -d com.apple.quarantine ../webdrivers/chromedriver```

---

**Start Appium server**

Open a Terminal and type:

```appium```

---

**How to start and stop iOS Simulators from the command line**

Show list of available Simulators

```xcrun simctl list```

Start iPhone 13 Pro Simulator

```xcrun simctl boot $(xcrun simctl list devices | grep -m 1 'iPhone 13 Pro' |grep -E -o -i '([0-9a-f]{8}-([0-9a-f]{4}-){3}[0-9a-f]{12})')```

Open Simulator app (Show Simulator on the screen)

```open -a Simulator```

Start iOS Simulators and show them on the screen

```open -a Simulator && xcrun simctl boot 'iPhone 13 Pro'```

```open -a Simulator && xcrun simctl boot 'iPhone 14'```

Stop iPhone 13 Pro Simulator

```xcrun simctl shutdown $(xcrun simctl list devices | grep -m 1 'iPhone 13 Pro' |grep -E -o -i '([0-9a-f]{8}-([0-9a-f]{4}-){3}[0-9a-f]{12})')```

Stop All Simulators

```xcrun simctl shutdown all```

Close Simulator app

```killall Simulator```

---

**Create a New Simulator**

```xcrun simctl create MyNewSimulator com.apple.CoreSimulator.SimDeviceType.iPhone-13-Pro com.apple.CoreSimulator.SimRuntime.iOS-15-4```

**Delete a Simulator**

```xcrun simctl erase <DeviceUDID>```

might work also:

```xcrun simctl erase MyNewSimulator```


---

**How To Run the tests**

* **serenity.conf** is the main configuration file
* more configuration files can be added:
* serenity.properties (default)
  * android.properties
  * ios.properties
  * custom.properties
* then when running the mvn command just add ```-Dproperties=custom.properties```

The Base URL can be specified from the command line:

```-Dwebdriver.base.url=https://60beans.com```

By default it is already set to https://staging.www.60beans.com in the serenity.properties file:

```webdriver.base.url=https://staging.www.60beans.com```

**Run in the cloud with LambdaTest**

Complete command:

```mvn clean test -Dtest=TestSuite -Denvironment=lambdatest_safari_mobile -Dwebdriver.base.url=https://staging.www.60beans.com -Dwebdriver.timeouts.implicitlywait=9000 -Dserenity.timeout=9000 -Dsurefire.rerunFailingTestsCount=1 -Dmaven.test.failure.ignore=true serenity:aggregate```

* ```mvn clean test -Dtest=TestSuite -Denvironment=lambdatest_safari_mobile```
* ```mvn clean test -Dtest=TestSuite -Denvironment=lambdatest_chrome_mobile```
* ```mvn clean test -Dtest=TestSuite -Denvironment=lambdatest_safari_web```
* ```mvn clean test -Dtest=TestSuite -Denvironment=lambdatest_chrome_win_web```

**Run in the cloud with BrowserStack**

* ```mvn clean test -Dtest=TestSuite -Denvironment=browserstack_safari_mobile```
* ```mvn clean test -Dtest=TestSuite -Denvironment=browserstack_chrome_mobile```
* ```mvn clean test -Dtest=TestSuite -Denvironment=browserstack_safari_web```
* ```mvn clean test -Dtest=TestSuite -Denvironment=browserstack_chrome_web```

For more options, look at the github actions workflow files (.yml files in this project)

**Run locally**

When running on mobile browsers, start first the appium server using ```appium``` command in the terminal

* ```mvn clean test -Dtest=TestSuite -Denvironment=chrome_web```
* ```mvn clean test -Dtest=TestSuite -Denvironment=safari_web```
* ```mvn clean test -Dtest=TestSuite -Denvironment=mobile_safari```
* ```mvn clean test -Dtest=TestSuite -Denvironment=mobile_android_chrome```

**Other examples:**

```
mvn
-U 
clean
test
-Dtest=TestSuite
-Dwebdriver.base.url=https://google.com
-Dwebdriver.driver=chrome
-Dwebdriver.remote.url=http://localhost:5555/wd/hub
-Dsurefire.rerunFailingTestsCount=1
-Dmax.retries=1
-DJUNIT_RETRY_TESTS=true
-Dwebdriver.timeouts.implicitlywait=9000
-Dserenity.timeout=9000
-Dmaven.test.failure.ignore=true
serenity:aggregate
```

-Dtags="smoke" -Dtags="regression"

```
mvn -U clean test -Dtest=TestSuite -Dtags="smoke" -Dwebdriver.driver=chrome -Dwebdriver.timeouts.implicitlywait=9000 -Dserenity.timeout=9000 -Dmaven.test.failure.ignore=true serenity:aggregate
```


**Generate the Test Report:**
```
mvn serenity:aggregate
```






# sereinty_java_18
# sereinty_java_18_proj
