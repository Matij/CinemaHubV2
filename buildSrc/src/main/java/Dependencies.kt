import org.gradle.api.JavaVersion

object Versions {
    const val agpVersion = "7.0.2"
    const val androidGifDrawableVersion = "1.2.23"
    const val annotationsVersion = "1.2.0"
    const val appcompatVersion = "1.3.1"
    const val constraintLayoutVersion = "2.1.0"
    const val coreKtxVersion = "1.6.0"
    const val coreTestingVersion = "2.1.0"
    const val coroutinesVersion = "1.5.2"
    const val dagger2 = "2.38.1"
    const val databindingAdapterVersion = "4.0.0"
    const val espressoVersion = "3.4.0"
    const val fragmentKtxVersion = "1.3.6"
    const val glideVersion = "4.12.0"
    const val jUnitVersion = "4.13.2"
    const val kotlinVersion = "1.5.30"
    const val lifecycleCompilerVersion = "2.3.1"
    const val lifecycleExtVersion = "2.2.0"
    const val materialVersion = "1.4.0"
    const val mockkVersion = "1.12.0"
    const val moshiVersion = "1.12.0"
    const val multiDexVersion = "2.0.1"
    const val okHttpVersion = "4.9.1"
    const val recyclerViewVersion = "1.2.0"
    const val retrofitVersion = "2.9.0"
    const val roomVersion = "2.3.0"
    const val sortedAdapterVersion = "0.3.0.27"
    const val testExtJunitVersion = "1.1.2"
    const val testRunnerVersion = "1.4.0"
    const val versionsPluginVersion = "0.39.0"

    const val JAVA_VERSION_STR = "1.8"
    val JAVA_VERSION = JavaVersion.VERSION_1_8
}

object Libs {

    const val androidAppCompat = "androidx.appcompat:appcompat:${Versions.appcompatVersion}"
    const val constraintLayout = "androidx.constraintlayout:constraintlayout:${Versions.constraintLayoutVersion}"
    const val fragmentKtx = "androidx.fragment:fragment-ktx:${Versions.fragmentKtxVersion}"
    const val espresso = "androidx.test.espresso:espresso-core:${Versions.espressoVersion}"
    const val lifecycleCompiler = "androidx.lifecycle:lifecycle-compiler:${Versions.lifecycleCompilerVersion}"
    const val lifecycleExtensions = "androidx.lifecycle:lifecycle-extensions:${Versions.lifecycleExtVersion}"
    const val recyclerView = "androidx.recyclerview:recyclerview:${Versions.recyclerViewVersion}"
    const val roomCompiler = "androidx.room:room-compiler:${Versions.roomVersion}"
    const val roomKtx = "androidx.room:room-ktx:${Versions.roomVersion}"
    const val testRunner = "androidx.test:runner:${Versions.testRunnerVersion}"
    const val annotations = "androidx.annotation:annotation:${Versions.annotationsVersion}"
    const val material = "com.google.android.material:material:${Versions.materialVersion}"
    const val coreKtx = "androidx.core:core-ktx:${Versions.coreKtxVersion}"

    const val dagger = "com.google.dagger:dagger:${Versions.dagger2}"
    const val daggerAndroid = "com.google.dagger:dagger-android:${Versions.dagger2}"
    const val daggerCompiler = "com.google.dagger:dagger-compiler:${Versions.dagger2}"
    const val daggerProcessor = "com.google.dagger:dagger-android-processor:${Versions.dagger2}"

    const val databinding_collectionadapter = "me.tatarka.bindingcollectionadapter2:bindingcollectionadapter:${Versions.databindingAdapterVersion}"
    const val databinding_collectionadapter_recyclerView = "me.tatarka.bindingcollectionadapter2:bindingcollectionadapter-recyclerview:${Versions.databindingAdapterVersion}"

    const val okhttp = "com.squareup.okhttp3:okhttp:${Versions.okHttpVersion}"
    const val loggingInterceptor = "com.squareup.okhttp3:logging-interceptor:${Versions.okHttpVersion}"
    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofitVersion}"
    const val converterMoshi = "com.squareup.retrofit2:converter-moshi:${Versions.retrofitVersion}"
    const val moshi = "com.squareup.moshi:moshi:${Versions.moshiVersion}"
    const val moshiAdapters = "com.squareup.moshi:moshi-adapters:${Versions.moshiVersion}"
    const val moshiKotlin = "com.squareup.moshi:moshi-kotlin:${Versions.moshiVersion}"
    const val moshiKotlinCodegen = "com.squareup.moshi:moshi-kotlin-codegen:${Versions.moshiVersion}"

    const val glide = "com.github.bumptech.glide:glide:${Versions.glideVersion}"

    const val sortedListAdapter = "com.github.wrdlbrnft:sorted-list-adapter:${Versions.sortedAdapterVersion}"

    const val androidGifDrawable = "pl.droidsonroids.gif:android-gif-drawable:${Versions.androidGifDrawableVersion}"
    // Checks for whether dependencies have updates
    const val gradleVersionsPlugin = "com.github.ben-manes:gradle-versions-plugin:${Versions.versionsPluginVersion}"

    const val kotlinStdLib = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlinVersion}"
    const val kotlinGradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlinVersion}"
    const val kotlinTest = "org.jetbrains.kotlin:kotlin-test:${Versions.kotlinVersion}"

    const val core = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutinesVersion}"
    const val rx2 = "org.jetbrains.kotlinx:kotlinx-coroutines-rx2:${Versions.coroutinesVersion}"
    const val android = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutinesVersion}"
    const val test = "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.coroutinesVersion}"
    const val coroutineTest = "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.coroutinesVersion}"
    const val debug = "org.jetbrains.kotlinx:kotlinx-coroutines-debug:${Versions.coroutinesVersion}"

    const val gradle = "com.android.tools.build:gradle:${Versions.agpVersion}"

    const val multiDex = "androidx.multidex:multidex:${Versions.multiDexVersion}"

    const val coreTesting = "androidx.arch.core:core-testing:${Versions.coreTestingVersion}"
    const val jUnit = "junit:junit:${Versions.jUnitVersion}"
    const val mockk = "io.mockk:mockk:${Versions.mockkVersion}"
    const val mockkAndroid = "io.mockk:mockk-android:${Versions.mockkVersion}"
    const val testEspressoCore = "androidx.test.espresso:espresso-core:${Versions.espressoVersion}"
    const val testExtJunit = "androidx.test.ext:junit:${Versions.testExtJunitVersion}"
}
