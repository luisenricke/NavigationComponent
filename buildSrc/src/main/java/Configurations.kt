import org.gradle.api.JavaVersion

@Suppress("unused")
object DefaultConfig {

    object Version {
        const val kotlin = "1.3.72"
        const val gradle = "4.0.0"
        const val navigationArgs = "2.3.0"
    }

    const val compileSdk = 29
    const val buildTools = "29.0.3"
    const val minSdk = 21
    const val targetSdk = 29
    val jvm = JavaVersion.VERSION_1_8

    const val gradle = "com.android.tools.build:gradle:${Version.gradle}"
    const val kotlinGradle = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Version.kotlin}"
    const val kotlin = "org.jetbrains.kotlin:kotlin-stdlib:${Version.kotlin}"
    const val navigationArgs = "androidx.navigation:navigation-safe-args-gradle-plugin:${Version.navigationArgs}"
}

@Suppress("unused")
object App {
    const val versionCode = 1
    const val versionName = "1.0"
}

@Suppress("unused")
object AndroidExt {
    const val versionCode = 1
    const val versionName = "1.0"
}
