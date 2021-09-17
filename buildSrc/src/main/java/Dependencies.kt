import org.gradle.api.JavaVersion

object Versions {
    const val agpVersion = "7.0.2"
    const val androidGifDrawableVersion = "1.2.23"
    const val annotationsVersion = "1.2.0"
    const val appcompatVersion = "1.3.1"
    const val constraintLayoutVersion = "2.1.0"
    const val dagger2 = "2.38.1"
    const val databindingAdapterVersion = "4.0.0"
    const val espressoVersion = "3.4.0"
    const val jUnitVersion = "4.13.2"
    const val kotlinVersion = "1.5.30"
    const val materialVersion = "1.4.0"
    const val multiDexVersion = "2.0.1"
    const val lifecycleCompilerVersion = "2.3.1"
    const val lifecycleExtVersion = "2.2.0"
    const val picassoVersion = "2.71828"
    const val recyclerViewVersion = "1.2.0"
    const val retrofitVersion = "2.9.0"
    const val roomVersion = "2.3.0"
    const val sortedAdapterVersion = "0.3.0.27"
    const val testRunnerVersion = "1.4.0"
    const val versionsPluginVersion = "0.39.0"

    const val JAVA_VERSION_STR = "1.8"
    val JAVA_VERSION = JavaVersion.VERSION_1_8
}

object Libs {

    const val androidAppCompat = "androidx.appcompat:appcompat:${Versions.appcompatVersion}"
    const val constraintLayout = "androidx.constraintlayout:constraintlayout:${Versions.constraintLayoutVersion}"
    const val espresso = "androidx.test.espresso:espresso-core:${Versions.espressoVersion}"
    const val lifecycleCompiler = "androidx.lifecycle:lifecycle-compiler:${Versions.lifecycleCompilerVersion}"
    const val lifecycleExtensions = "androidx.lifecycle:lifecycle-extensions:${Versions.lifecycleExtVersion}"
    const val recyclerView = "androidx.recyclerview:recyclerview:${Versions.recyclerViewVersion}"
    const val roomCompiler = "androidx.room:room-compiler:${Versions.roomVersion}"
    const val roomKtx = "androidx.room:room-ktx:${Versions.roomVersion}"
    const val testRunner = "androidx.test:runner:${Versions.testRunnerVersion}"
    const val annotations = "androidx.annotation:annotation:${Versions.annotationsVersion}"
    const val material = "com.google.android.material:material:${Versions.materialVersion}"

    const val dagger = "com.google.dagger:dagger:${Versions.dagger2}"
    const val daggerAndroid = "com.google.dagger:dagger-android:${Versions.dagger2}"
    const val daggerCompiler = "com.google.dagger:dagger-compiler:${Versions.dagger2}"
    const val daggerProcessor = "com.google.dagger:dagger-android-processor:${Versions.dagger2}"

    const val databinding_collectionadapter = "me.tatarka.bindingcollectionadapter2:bindingcollectionadapter:${Versions.databindingAdapterVersion}"
    const val databinding_collectionadapter_recyclerView = "me.tatarka.bindingcollectionadapter2:bindingcollectionadapter-recyclerview:${Versions.databindingAdapterVersion}"

    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofitVersion}"
    const val retrofit_jacksonconverter = "com.squareup.retrofit2:converter-jackson:${Versions.retrofitVersion}"

    const val picasso = "com.squareup.picasso:picasso:${Versions.picassoVersion}"

    const val sortedListAdapter = "com.github.wrdlbrnft:sorted-list-adapter:${Versions.sortedAdapterVersion}"

    const val androidGifDrawable = "pl.droidsonroids.gif:android-gif-drawable:${Versions.androidGifDrawableVersion}"
    // Checks for whether dependencies have updates
    const val gradleVersionsPlugin = "com.github.ben-manes:gradle-versions-plugin:${Versions.versionsPluginVersion}"

    const val kotlinStdLib = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlinVersion}"
    const val kotlinGradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlinVersion}"

    const val gradle = "com.android.tools.build:gradle:${Versions.agpVersion}"
    const val jUnit = "junit:junit:${Versions.jUnitVersion}"

    const val multiDex = "androidx.multidex:multidex:${Versions.multiDexVersion}"
}
