import org.gradle.api.JavaVersion

object AndroidConfig {

    object Plugin {
        const val androidApp = "com.android.application"
        const val androidLib = "com.android.library"
        const val kotlinAndroid = "kotlin-android"
        const val kapt = "kotlin-kapt"
        const val javaLib = "java-library"
        const val kotlin = "kotlin"
        const val parcelize = "org.jetbrains.kotlin.plugin.parcelize"
        const val ktlint = "org.jlleitschuh.gradle.ktlint"
        const val hilt = "dagger.hilt.android.plugin"
        const val safeArgs = "androidx.navigation.safeargs.kotlin"
    }

    const val sdkVersion = 31
    const val minSdkVersion = 24
    val javaVersion = JavaVersion.VERSION_11
}
