plugins {
    id("android-application-plugin")
}

android {
    viewBinding.isEnabled = true
    buildFeatures.compose = true
    composeOptions.kotlinCompilerExtensionVersion = Versions.compose
}

dependencies {
    appLibProjects()
    kotlin()
    dependencyInjection()
    baseAndroid()
    navigation()
    coroutines()
    compose()
    test()
    androidTest()
}