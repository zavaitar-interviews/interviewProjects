plugins {
    id("android-library-plugin")
}

dependencies {
    kotlin()
    dependencyInjection()
    baseAndroid()
    coroutines()
    network()
}
