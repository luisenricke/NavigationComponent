@Suppress("unused")
object AndroidLib {

    object Version {
        const val appCompat = "1.1.0"
        const val activity = "1.2.0-alpha06"
        const val ktx = "1.3.0"
        const val lifecycleExt = "2.2.0"
        const val fragment = "1.2.5"
        const val annotation = "1.1.0"
        const val preference = "1.1.0"
        const val legacy = "1.0.0"
        const val navigation = "2.1.0"
    }

    const val appCompat = "androidx.appcompat:appcompat:${Version.appCompat}"
    const val activity = "androidx.activity:activity:${Version.activity}"
    const val coreKtx = "androidx.core:core-ktx:${Version.ktx}"
    const val fragmentKtx = "androidx.fragment:fragment-ktx:${Version.fragment}"
    const val annotationX = "androidx.annotation:annotation:${Version.annotation}"
    const val preference = "androidx.preference:preference:${Version.preference}"
    const val legacy = "androidx.legacy:legacy-support-v4:${Version.legacy}"
    const val lifecycleExt = "androidx.lifecycle:lifecycle-extensions:${Version.lifecycleExt}"
    const val navigationFragment = "androidx.navigation:navigation-fragment:${Version.navigation}"
    const val navigationUI = "androidx.navigation:navigation-ui:${Version.navigation}"
    const val navigationFragmentKtx = "androidx.navigation:navigation-fragment-ktx:${Version.navigation}"
    const val navigationUIKtx = "androidx.navigation:navigation-ui-ktx:${Version.navigation}"
}

@Suppress("unused")
object TestLib {

    object Version {
        const val junit = "4.13"
        const val junitExt = "1.1.1"
        const val mockitoCore = "3.3.3"
        const val testRunner = "1.2.0"
        const val espressoCore = "3.2.0"
    }

    const val junit = "junit:junit:${Version.junit}"
    const val junitExt = "androidx.test.ext:junit:${Version.junitExt}"
    const val espresso = "androidx.test.espresso:espresso-core:${Version.espressoCore}"

    const val mockito = "org.mockito:mockito-core:${Version.mockitoCore}"
    const val runner = "androidx.test:runner:${Version.testRunner}"
}

@Suppress("unused")
object ViewLib {

    object Version {
        const val materialDesign = "1.0.0"
        const val recyclerView = "1.1.0"
        const val cardView = "1.0.0"
        const val constraintLayout = "1.1.3"
    }

    const val materialDesign = "com.google.android.material:material:${Version.materialDesign}"
    const val recyclerview = "androidx.recyclerview:recyclerview:${Version.recyclerView}"
    const val cardView = "androidx.cardview:cardview:${Version.cardView}"
    const val constraintLayout = "androidx.constraintlayout:constraintlayout:${Version.constraintLayout}"
}

@Suppress("unused")
object ToolLib {

    object Version {
        const val timber = "4.7.1"
        const val picasso = "2.5.2"
        const val glide = "4.11.0"
    }

    const val timber = "com.jakewharton.timber:timber:${Version.timber}"
    const val picasso = "com.squareup.picasso:picasso:${Version.picasso}"
    const val glide = "com.github.bumptech.glide:glide:${Version.glide}"
}

@Suppress("unused")
object DatabaseLib {

    object Version {
        const val room = "2.2.5"
    }

    const val runtimeRoom = "androidx.room:room-runtime:${Version.room}"
    const val compilerRoom = "androidx.room:room-compiler:${Version.room}"
    const val rxJavaRoom = "androidx.room:room-rxjava2:${Version.room}"
    const val testingRoom = "androidx.room:room-testing:${Version.room}"
}

@Suppress("unused")
object NetworkLib {

    object Version {
        const val retrofit = "2.9.0"
        const val okHttp3 = "4.7.2"
        const val gson = "2.8.6"
    }

    const val mainRetrofit = "com.squareup.retrofit2:retrofit:${Version.retrofit}"
    const val gsonRetrofit = "com.squareup.retrofit2:converter-gson:${Version.retrofit}"
    const val rxJavaRetrofit = "com.squareup.retrofit2:adapter-rxjava2:${Version.retrofit}"
    const val okHttp3 = "com.squareup.okhttp3:okhttp:${Version.okHttp3}"
    const val loggingInterceptor = "com.squareup.okhttp3:logging-interceptor:${Version.okHttp3}"
    const val gson = "com.google.code.gson:gson:${Version.gson}"
}

@Suppress("unused")
object RxLib {

    object Version {
        const val java = "2.2.19"
        const val android = "2.1.1"
    }

    const val java = "io.reactivex.rxjava2:rxjava:${Version.java}"
    const val android = "io.reactivex.rxjava2:rxandroid:${Version.android}"
}
