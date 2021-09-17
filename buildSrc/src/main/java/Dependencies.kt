object Versions {
    const val supportVersion = "27.1.1"
    const val dagger2 = "2.16"
    const val retrofitVersion = "2.4.0"
    const val roomVersion = "1.1.1"
    const val lifecycle = "1.1.1"
    const val constraintLayoutVersion = "1.1.2"
    const val androidGifDrawableVersion = "1.2.7"
    const val kotlinVersion = "1.2.50"
    const val gradle = "3.1.3"
    const val gradlePluginVersion = "0.20.0"
    const val databindingVersion = "1.3.3"
    const val databindingAdapterVersion = "2.2.0"
    const val jUnitVersion = "4.12"
    const val testRunnerVersion = "1.0.2"
    const val espressoVersion = "3.0.2"
    const val picassoVersion = "2.71828"
    const val sortedAdapterVersion = "0.3.0.27"
}

object Libs {
    val androidAppCompatV7 = "com.android.support:appcompat-v7:${Versions.supportVersion}"
    val constraintLayout = "com.android.support.constraint:constraint-layout:${Versions.constraintLayoutVersion}"
    val espresso = "com.android.support.test.espresso:espresso-core:${Versions.espressoVersion}"
    val lifecycleCompiler = "android.arch.lifecycle:compiler:${Versions.lifecycle}"
    val lifecycleExtensions = "android.arch.lifecycle:extensions:${Versions.lifecycle}"
    val recyclerView = "com.android.support:recyclerview-v7:${Versions.supportVersion}"
    val room = "android.arch.persistence.room:runtime:${Versions.roomVersion}"
    val roomCompiler = "android.arch.persistence.room:compiler:${Versions.roomVersion}"
    val testRunner = "com.android.support.test:runner:${Versions.testRunnerVersion}"
    val support_annotations = "com.android.support:support-annotations:${Versions.supportVersion}"
    val support_design = "com.android.support:design:${Versions.supportVersion}"
    val support_supportv4 = "com.android.support:support-v4:${Versions.supportVersion}"

    val dagger = "com.google.dagger:dagger:${Versions.dagger2}"
    val daggerAndroid = "com.google.dagger:dagger-android:${Versions.dagger2}"
    val daggerCompiler = "com.google.dagger:dagger-compiler:${Versions.dagger2}"
    val daggerProcessor = "com.google.dagger:dagger-android-processor:${Versions.dagger2}"
    val daggerSupport = "com.google.dagger:dagger-android-support:${Versions.dagger2}"

    val daggerAndroidProcessor = "com.google.dagger:dagger-android-processor:${Versions.dagger2}"
    val daggerAndroidSupport = "com.google.dagger:dagger-android-support:${Versions.dagger2}"

    val databinding = "com.android.databinding:library:${Versions.databindingVersion}"
    val databinding_adapters= "com.android.databinding:adapters:${Versions.databindingVersion}"
    val databinding_base = "com.android.databinding:baseLibrary:${Versions.databindingVersion}"
    val databinding_collectionadapter = "me.tatarka.bindingcollectionadapter2:bindingcollectionadapter:${Versions.databindingAdapterVersion}"
    val databinding_collectionadapter_recyclerView = "me.tatarka.bindingcollectionadapter2:bindingcollectionadapter-recyclerview:${Versions.databindingAdapterVersion}"
    val databinding_compiler = "com.android.databinding:compiler:${Versions.databindingVersion}"

    val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofitVersion}"
    val retrofit_jacksonconverter = "com.squareup.retrofit2:converter-jackson:${Versions.retrofitVersion}"

    val picasso = "com.squareup.picasso:picasso:${Versions.picassoVersion}"

    val sortedListAdapter = "com.github.wrdlbrnft:sorted-list-adapter:${Versions.sortedAdapterVersion}"

    val androidGifDrawable = "pl.droidsonroids.gif:android-gif-drawable:${Versions.androidGifDrawableVersion}"
    val kotlinGradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlinVersion}"

    // Checks for whether dependencies have updates
    val gradleVersionsPlugin = "com.github.ben-manes:gradle-versions-plugin:${Versions.gradlePluginVersion}"

    val kotlinStdLib = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlinVersion}"

    val gradle = "com.android.tools.build:gradle:${Versions.gradle}"
    val jUnit = "junit:junit:${Versions.jUnitVersion}"
}