object Libs {

    object Plugins {
        const val buildGradle = "com.android.tools.build:gradle:${Versions.gradle}"
        const val kotlinGradle = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}"
        const val junit5 = "de.mannodermaus.gradle.plugins:android-junit5:${Versions.junit5Gradle}"
        const val ktlintGradle = "org.jlleitschuh.gradle:ktlint-gradle:${Versions.ktlint}"
        const val hilt = "com.google.dagger:hilt-android-gradle-plugin:${Versions.dagger}"
        const val safeArgs =
            "androidx.navigation:navigation-safe-args-gradle-plugin:${Versions.nav}"
        const val parcelize = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.parcelize}"
    }

    object AndroidX {
        const val coreKtx = "androidx.core:core-ktx:${Versions.ktx}"
        const val coreSplashScreen = "androidx.core:core-splashscreen:${Versions.splashScreen}"
        const val fragmentKtx = "androidx.fragment:fragment-ktx:${Versions.ktxFragment}"
        const val vmKtx = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.ktxViewModel}"
        const val lifecycleRuntimeKtx =
            "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.ktxLifecycleRuntime}"
        const val appCompat = "androidx.appcompat:appcompat:${Versions.appCompat}"
        const val navFragment = "androidx.navigation:navigation-fragment-ktx:${Versions.nav}"
        const val navUi = "androidx.navigation:navigation-ui-ktx:${Versions.nav}"

        object Compose {
            const val ui = "androidx.compose.ui:ui:${Versions.compose}"
            const val uiTooling = "androidx.compose.ui:ui-tooling:${Versions.compose}"
            const val foundation = "androidx.compose.foundation:foundation:${Versions.compose}"
            const val material = "androidx.compose.material:material:${Versions.compose}"
            const val constraint =
                "androidx.constraintlayout:constraintlayout-compose:${Versions.composeConstraint}"
            const val materialIconsCore =
                "androidx.compose.material:material-icons-core:${Versions.compose}"
            const val materialIconsExtended =
                "androidx.compose.material:material-icons-extended:${Versions.compose}"

            const val activity = "androidx.activity:activity-compose:${Versions.composeActivity}"
            const val viewModel =
                "androidx.lifecycle:lifecycle-viewmodel-compose:${Versions.composeViewModel}"
            const val runtime = "androidx.compose.runtime:runtime:${Versions.composeRuntime}"
        }
    }

    object Google {
        const val material = "com.google.android.material:material:${Versions.material}"
        const val dagger = "com.google.dagger:dagger:${Versions.dagger}"
        const val hilt = "com.google.dagger:hilt-android:${Versions.dagger}"

        object Annotation {
            const val dagger = "com.google.dagger:dagger-compiler:${Versions.dagger}"
            const val hilt = "com.google.dagger:hilt-compiler:${Versions.dagger}"
        }
    }

    object Network {

        object Retrofit {
            const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
        }

        object OkHttp {
            const val okhttp3 = "com.squareup.okhttp3:logging-interceptor:${Versions.okhttp3}"
        }

        object Parser {
            const val gsonConvertor =
                "com.squareup.retrofit2:converter-gson:${Versions.gsonConvertor}"
            const val gson = "com.google.code.gson:gson:${Versions.gson}"
        }

        object Adapter {
            const val callAdapter =
                "com.jakewharton.retrofit:retrofit2-kotlin-coroutines-adapter:${Versions.callAdapter}"
        }

        object ImageLoader {
            const val coil = "io.coil-kt:coil:${Versions.coil}"
        }
    }

    object Jetbrains {
        const val kotlinStdlib = "org.jetbrains.kotlin:kotlin-stdlib:${Versions.kotlin}"

        object Coroutines {
            const val core = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutines}"
            const val android =
                "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutines}"
        }
    }

    object Testing {

        object JUnit {
            const val jupiter = "junit:junit:${Versions.junit4}"
            const val junit = "androidx.test.ext:junit:${Versions.androidXJunit}"
            const val jUnitParams = "pl.pragmatists:JUnitParams:${Versions.junitParams}"
        }

        object Espresso {
            const val espressoCore = "androidx.test.espresso:espresso-core:${Versions.espresso}"
            const val espressoContrib =
                "androidx.test.espresso:espresso-contrib:${Versions.espresso}"
            const val espressoIntents =
                "androidx.test.espresso:espresso-intents:${Versions.espresso}"
            const val espressoWeb = "androidx.test.espresso:espresso-web:${Versions.espresso}"
        }

        object Mockito {
            const val mockitoAndroid = "org.mockito:mockito-android:${Versions.mockitoAndroid}"
            const val mockitoKotlin =
                "com.nhaarman.mockitokotlin2:mockito-kotlin:${Versions.mockitoKotlinCore}"
            const val mockitoCore = "org.mockito:mockito-core:${Versions.mockitoCore}"
        }

        object Ui {
            const val androidxTestRunner = "androidx.test:runner:${Versions.testRunner}"
            const val androidxTestOrchestrator = "androidx.test:orchestrator:${Versions.testRunner}"
        }

        object Compose {
            const val androidxComposeUiTest = "androidx.compose.ui:ui-test:${Versions.composeUi}"
            const val androidxComposeUiTestJunit =
                "androidx.compose.ui:ui-test-junit4:${Versions.composeUi}"
        }

        object Core {
            const val coreTesting = "androidx.arch.core:core-testing:${Versions.coreTesting}"
            const val androidxCore = "androidx.test:core${Versions.androidXCore}"
            const val coroutines =
                "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.coroutines}"
            const val mockk = "io.mockk:mockk:${Versions.mockk}"
        }
    }

    object LibraryProjects {
        const val coreNetwork = ":core-network"
        const val coreArchitecture = ":core-architecture"
    }
}