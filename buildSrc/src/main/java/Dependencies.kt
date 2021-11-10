import org.gradle.api.artifacts.dsl.DependencyHandler
import org.gradle.kotlin.dsl.project

fun DependencyHandler.kotlin() {
    implementation(Libs.Jetbrains.kotlinStdlib)
}

fun DependencyHandler.baseAndroid() {
    implementation(Libs.AndroidX.coreKtx)
    implementation(Libs.AndroidX.coreSplashScreen)
    implementation(Libs.AndroidX.fragmentKtx)
    implementation(Libs.AndroidX.vmKtx)
    implementation(Libs.AndroidX.lifecycleRuntimeKtx)
    implementation(Libs.AndroidX.appCompat)
    implementation(Libs.Google.material)
    implementation(Libs.Network.Parser.gson)
    implementation(Libs.Network.Retrofit.retrofit)
    implementation(Libs.Network.Adapter.callAdapter)
    implementation(Libs.Network.ImageLoader.coil)
}

fun DependencyHandler.navigation() {
    implementation(Libs.AndroidX.navFragment)
    implementation(Libs.AndroidX.navUi)
}

fun DependencyHandler.dependencyInjection() {
    implementation(Libs.Google.dagger)
    implementation(Libs.Google.hilt)
    kapt(Libs.Google.Annotation.dagger)
    kapt(Libs.Google.Annotation.hilt)
}

fun DependencyHandler.compose() {
    implementation(Libs.AndroidX.Compose.ui)
    implementation(Libs.AndroidX.Compose.uiTooling)
    implementation(Libs.AndroidX.Compose.foundation)
    implementation(Libs.AndroidX.Compose.material)
    implementation(Libs.AndroidX.Compose.constraint)
    implementation(Libs.AndroidX.Compose.materialIconsCore)
    implementation(Libs.AndroidX.Compose.materialIconsExtended)
    implementation(Libs.AndroidX.Compose.activity)
    implementation(Libs.AndroidX.Compose.viewModel)
    implementation(Libs.AndroidX.Compose.runtime)
    androidTestImplementation(Libs.Testing.Compose.androidxComposeUiTest)
}

fun DependencyHandler.coroutines() {
    implementation(Libs.Jetbrains.Coroutines.core)
    implementation(Libs.Jetbrains.Coroutines.android)
}

fun DependencyHandler.network() {
    implementation(Libs.Network.OkHttp.okhttp3)
    implementation(Libs.Network.Parser.gsonConvertor)
}

fun DependencyHandler.test() {
    testImplementation(Libs.Testing.Core.coroutines)
    testImplementation(Libs.Testing.JUnit.jupiter)
    testImplementation(Libs.Testing.JUnit.junit)
    testImplementation(Libs.Testing.JUnit.jUnitParams)
    androidTestImplementation(Libs.Testing.Mockito.mockitoAndroid)
    androidTestImplementation(Libs.Testing.Mockito.mockitoKotlin)
    androidTestImplementation(Libs.Testing.Mockito.mockitoCore)
    testImplementation(Libs.Testing.Compose.androidxComposeUiTestJunit)
    testImplementation(Libs.Testing.Mockito.mockitoKotlin)
    testImplementation(Libs.Testing.Core.coreTesting)
    testImplementation(Libs.Testing.Core.mockk)
}

fun DependencyHandler.androidTest() {
    androidTestImplementation(Libs.Testing.Ui.androidxTestOrchestrator)
    androidTestImplementation(Libs.Testing.Ui.androidxTestRunner)
    androidTestImplementation(Libs.Testing.Espresso.espressoCore)
    androidTestImplementation(Libs.Testing.Espresso.espressoContrib)
    androidTestImplementation(Libs.Testing.Espresso.espressoIntents)
    androidTestImplementation(Libs.Testing.Espresso.espressoWeb)
}

fun DependencyHandler.appLibProjects() {
    libraryProjectImplementation(project(Libs.LibraryProjects.coreNetwork))
    libraryProjectImplementation(project(Libs.LibraryProjects.coreArchitecture))
}
