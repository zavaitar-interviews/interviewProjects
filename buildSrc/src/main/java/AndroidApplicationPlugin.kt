import org.gradle.api.Plugin
import org.gradle.api.Project

class AndroidApplicationPlugin : Plugin<Project> {
    override fun apply(project: Project) {
        project.addPlugin(AndroidConfig.Plugin.androidApp)
        project.addPlugin(AndroidConfig.Plugin.kotlinAndroid)
        project.addPlugin(AndroidConfig.Plugin.kapt)
        project.addPlugin(AndroidConfig.Plugin.hilt)
        project.addPlugin(AndroidConfig.Plugin.parcelize)
        project.addPlugin(AndroidConfig.Plugin.safeArgs)
        project.androidConfiguration { defaultConfig() }
        project.kotlinCompileOptions()
    }
}
